package Users;

import LibrarySystem.Books.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Reader extends Person{

    List<Book> readerBooks;

    public Reader(String name)
    {
        super(name);
        readerBooks = new ArrayList<>();
    }

    public List<Book> getReaderBooks()
    {
        return readerBooks.stream().collect(Collectors.toUnmodifiableList());
    }

    public void purchaseBook(Librarian librarian, Book book)
    {
        if(librarian.searchBook(book))
        {
            librarian.issueBook(this, book);
            readerBooks.add(book);
        }else{
            System.out.println("Kütüphanede bu kitap bulunmamaktadır!!!");
        }
    }

    //Borrow: Ödünç almak
    public void borrowBook(Book book, Librarian librarian)
    {
        if(librarian.searchBook(book))
        {
            librarian.issueBook(this,book);
        }else{
            System.out.println("Kütüphanede bu kitap bulunmamaktadır!!!");
        }
    }

    public void addBookToBookList(Book newBook)
    {
        if(!readerBooks.contains(newBook) && newBook != null)
        {
            readerBooks.add(newBook);
        }
    }

    public void removeBookToBookList(Book removingBook)
    {
        if(removingBook != null)
        {
            readerBooks.remove(removingBook);
        }
    }

    public Book searchUserBookId(int bookId)
    {
        for (int i = 0; i < readerBooks.size(); i++) {
            if(readerBooks.get(i).getBookID() == bookId)
            {
                readerBooks.get(i).display();
                return readerBooks.get(i);
            }
        }
        System.out.println("Kullanıcının bu id de bir kitabı yoktur.");
        return null;
    }

    public void returnBook(Librarian librarian, Book book)
    {
        librarian.returnBook(book, this);
    }

    public void showBook()
    {
        Iterator<Book> itr = readerBooks.iterator();
        while (itr.hasNext())
        {
            System.out.println(getName() +" Reader's book: " + itr.next());
        }
        if(readerBooks.isEmpty())
        {
            System.out.println(getName() + " adlı kullanıcının kiraladığı veya satın aldığı kitap yoktur.");
        }
    }

    @Override
    public void whoYouAre()
    {
        System.out.println("Reader: " + super.getName());
    }
}
