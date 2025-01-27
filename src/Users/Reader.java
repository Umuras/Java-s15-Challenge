package Users;

import LibrarySystem.Books.Book;

import java.util.Iterator;
import java.util.List;

public class Reader extends Person{

    List<Book> readerBooks;

    public Reader(String name)
    {
        super(name);
    }

    public void purchaseBook()
    {

    }

    public void borrowBook()
    {

    }

    public void returnBook()
    {

    }

    public void showBook()
    {
        Iterator<Book> itr = readerBooks.iterator();
        while (itr.hasNext())
        {
            System.out.println(getName() +" Reader's book: " + itr.next());
        }
    }

    @Override
    public void whoYouAre()
    {
        System.out.println("Reader: " + super.getName());
    }
}
