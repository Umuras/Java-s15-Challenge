package LibrarySystem;

import LibrarySystem.Books.Book;
import Users.Reader;

import java.util.Iterator;
import java.util.List;

public class Library {
    private List<Book> libraryBooks;
    private List<Reader> libraryReaders;

    public Library(List<Book> libraryBooks, List<Reader> libraryReaders)
    {
        this.libraryBooks = libraryBooks;
        this.libraryReaders = libraryReaders;
    }

    public List<Book> getLibraryBooks()
    {
        return libraryBooks;
    }

    public List<Reader> getLibraryReaders()
    {
        return libraryReaders;
    }

    public void addNewBook(Book newBook)
    {
        boolean hasLibraryThisBook = false;
        Iterator<Book> itr = libraryBooks.iterator();
        while (itr.hasNext())
        {
            if(itr.next().equals(newBook))
            {
                hasLibraryThisBook = true;
            }
        }
        if(!hasLibraryThisBook)
        {
            libraryBooks.add(newBook);
        }
    }

    //Lend: Ödünç vermek
    //Borrow: Ödünç almak
    //Öğrenciye kitap vermek için kullanılacak
    public void lendBook(Book lendBook, Reader reader)
    {

    }

    //Öğrenciden alınan kitap
    public void takeBackBook(Book takeBackBook)
    {

    }

    public void showBooks()
    {
        Iterator itr = libraryBooks.iterator();
        System.out.println("Library has " + libraryBooks.size() + " right now.");
        while(itr.hasNext())
        {
            if(itr.next() instanceof Book)
            {
                ((Book)itr.next()).display();
            }
        }
    }
}
