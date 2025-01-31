package Users;

import LibrarySystem.Books.Book;
import LibrarySystem.Enums.BookStatus;
import LibrarySystem.Library;
import LibrarySystem.Members.MemberRecord;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;

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
    }

    public boolean searchBook(Book book)
    {
        return library.getLibraryBooks().contains(book);
    }

    //Kütüphane üyesini listeye ekliyorum.
    public void verifyMember(MemberRecord member)
    {
        memberRecords.add(member);
    }

    //Kitap vermek, kitap çıkarmak demek.
    public void issueBook(Reader reader, Book book)
    {
        if(searchBook(book))
        {
            library.lendBook(book,reader,this);
            book.updateStatus(BookStatus.BORROWLIBRARYBOOK);
            createBill(book);
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
    public void createBill(Book book)
    {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("BookID: ").append(book.getBookID()).append("\n");
        strBuilder.append("BookName: ").append(book.getName()).append("\n");
        strBuilder.append("Book's Author: ").append(book.getAuthor()).append("\n");
        strBuilder.append("Price: ").append(book.getPrice()).append("\n");
        strBuilder.append("DateOfPurchase: ").append(book.getDateOfPurchase());

        System.out.println("Book's Bill");
        System.out.println(strBuilder.toString());
    }

    public void returnBook(Book book, Reader reader)
    {
        double fineValue = calculateFine(book);
        library.setLibraryBalance(fineValue > 0 ? fineValue : book.getPrice());
        library.takeBackBook(book, reader);
    }
}
