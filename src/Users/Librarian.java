package Users;

import LibrarySystem.Books.Book;
import LibrarySystem.Enums.BookStatus;
import LibrarySystem.Library;
import LibrarySystem.Members.MemberRecord;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Librarian {
    private String name;
    private String password;
    private Library library;
    private Set<MemberRecord> memberRecords;

    public Librarian(String name, String password, Library library)
    {
        this.name = name;
        this.password = password;
        this.library = library;
        memberRecords = new HashSet<>();
    }

    public String getName()
    {
        return name;
    }

    public String getPassword()
    {
        return password;
    }

    public boolean searchBook(Book book)
    {
        return library.getLibraryBooks().contains(book);
    }

    public MemberRecord searchAndGetMember(String memberName)
    {
        for(MemberRecord memberRecord : memberRecords)
        {
            if(memberRecord.getName().equals(memberName))
            {
                return memberRecord;
            }
        }
        return null;
    }

    //Kütüphane üyesini listeye ekliyorum.
    public void verifyMember(Reader member)
    {
        ((MemberRecord)member).setVerifiedMemberStatus(true);
        memberRecords.add((MemberRecord) member);
    }

    //Kitap vermek, kitap çıkarmak demek.
    public void issueBook(Reader reader, Book book)
    {
        if(searchBook(book))
        {
            library.lendBook(book,reader,this);
            book.updateStatus(BookStatus.BORROWLIBRARYBOOK);
            createBill(book, reader);
            ((MemberRecord)reader).payBill(book);
            library.addLibraryBalance(book.getPrice());
        }else{
            System.out.println("Library hasn't this book");
        }
    }

    //Kütüphaneden kitap alan üye belli bir zaman sonra kitabını iade etmezse onun ödeyeceği para
    public double calculateFine(Book book)
    {
        long days = ChronoUnit.DAYS.between(LocalDateTime.now(), book.getDateOfPurchase());
        if(days >= 14)
        {
            double fineValue = (book.getPrice() / 2) + 15.0;
            return fineValue;
        }
        return 0.0;
    }

    //Kitap ödünç alınınca veya satın alınınca oluşturulacak fatura.
    public void createBill(Book book, Reader reader)
    {
        StringBuilder billBuilder = new StringBuilder();
        billBuilder.append("Book's Bill").append("\n");
        billBuilder.append("Bill's Owner: ").append(reader.getName()).append("\n");
        billBuilder.append("BookID: ").append(book.getBookID()).append("\n");
        billBuilder.append("BookName: ").append(book.getName()).append("\n");
        billBuilder.append("Book's Author: ").append(book.getAuthor().getName()).append("\n");
        billBuilder.append("Price: ").append(book.getPrice()).append("\n");
        billBuilder.append("DateOfPurchase: ").append(book.getDateOfPurchase());

        ((MemberRecord)reader).addBillInBillList(billBuilder,book.getBookID());
        System.out.println(billBuilder.toString());
    }

    public void returnBook(Book book, Reader reader)
    {
        double fineValue = calculateFine(book);
        ((MemberRecord)reader).addMemberBalance(fineValue > 0 ? (-fineValue+book.getPrice()) : book.getPrice());
        library.addLibraryBalance(fineValue > 0 ? (fineValue-book.getPrice()) : -book.getPrice());
        ((MemberRecord)reader).removeBillInBillList(book.getBookID());
        book.updateStatus(BookStatus.INLIBRARY);
        library.takeBackBook(book, reader);
    }
}
