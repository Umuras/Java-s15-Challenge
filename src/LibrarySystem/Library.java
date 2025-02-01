package LibrarySystem;

import LibrarySystem.Books.Book;
import Users.Author;
import Users.Librarian;
import Users.Reader;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Library {
    private List<Book> libraryBooks;
    private List<Reader> libraryReaders;
    private Set<Author> libraryBooksAuthors;
    private double libraryBalance = 0;

    public Library(List<Book> libraryBooks, List<Reader> libraryReaders, Set<Author> libraryBooksAuthors)
    {
        this.libraryBooks = libraryBooks;
        this.libraryReaders = libraryReaders;
        this.libraryBooksAuthors = libraryBooksAuthors;
    }

    public List<Book> getLibraryBooks()
    {
        return libraryBooks;
    }

    public List<Reader> getLibraryReaders()
    {
        return libraryReaders;
    }

    public void addNewBookInLibraryBooks(Book newBook)
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
            //System.out.println("Library'e yeni kitap eklendi!...");
        }
    }

    public void removeBookInLibraryBooks(Book book){
        Iterator<Book> itr = libraryBooks.iterator();
        while (itr.hasNext())
        {
            if(itr.next().equals(book))
            {
                String bookName = book.getName();
                book.getAuthor().getAuthorBooks().remove(book);
                itr.remove();
                System.out.println(bookName + " kitabı başarıyla silindi");
            }
        }
    }



    //Lend: Ödünç vermek
    //Borrow: Ödünç almak
    //Öğrenciye kitap vermek için kullanılacak
    public void lendBook(Book lendBook, Reader reader, Librarian librarian)
    {
        if(librarian.searchBook(lendBook))
        {
            reader.addBookToBookList(lendBook);
            libraryBooks.remove(lendBook);
            System.out.println("Lendbook operation finished.");
        }else{
            System.out.println("Library hasn't this book");
        }
    }

    //Öğrenciden alınan kitap
    public void takeBackBook(Book takeBackBook, Reader reader)
    {
        if(!libraryBooks.contains(takeBackBook))
        {
            libraryBooks.add(takeBackBook);
            reader.removeBookToBookList(takeBackBook);
        }
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

    public Book searchBookId(int bookId)
    {
        for (int i = 0; i < libraryBooks.size(); i++) {
            if(libraryBooks.get(i).getBookID() == bookId)
            {
                libraryBooks.get(i).display();
                return libraryBooks.get(i);
            }
        }
        System.out.println("Kütüphanede bu idde kitap yoktur.");
        return null;
    }

    public Book searchBookName(String bookName)
    {
        for (Book libraryBook : libraryBooks) {
            if (libraryBook.getName().equals(bookName)) {
                libraryBook.display();
                return libraryBook;
            }
        }
        System.out.println("Kütüphanede bu isimde kitap yoktur.");
        return null;
    }

    public List<Book> searchBookAuthorName(String authorName)
    {
        for(Author libraryBookAuthor : libraryBooksAuthors)
        {
            if (libraryBookAuthor.getName().equals(authorName))
            {
                libraryBookAuthor.getAuthorBooks().forEach(book -> book.display());
                return libraryBookAuthor.getAuthorBooks();
            }
        }
        System.out.println("Kütüphanede bu yazara ait kitap yok.");
        return null;
    }

    public Author checkAuthor(String authorName)
    {
        for(Author libraryBookAuthor : libraryBooksAuthors)
        {
            if (libraryBookAuthor.getName().equals(authorName))
            {
                return libraryBookAuthor;
            }
        }
        return new Author(authorName);
    }

    public double getLibraryBalance() {
        return libraryBalance;
    }

    public void setLibraryBalance(double libraryBalance) {
        this.libraryBalance += libraryBalance;
    }

    public void addLibraryBooksAuthor(Author author)
    {
        if(!libraryBooksAuthors.contains(author))
        {
            libraryBooksAuthors.add(author);
        }
    }
}
