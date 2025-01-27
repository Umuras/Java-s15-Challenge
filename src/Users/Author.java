package Users;

import LibrarySystem.Books.Book;

import java.util.Iterator;
import java.util.List;

public class Author extends Person{

    private List<Book> authorBooks;

    public Author(String name, Book book)
    {
        super(name);
        addNewBook(book);
    }

    public void showBook()
    {
        Iterator itr = authorBooks.iterator();
        while(itr.hasNext())
        {
            if(itr.next() instanceof Book)
            {
                ((Book)itr.next()).display();
            }
        }
    }

    public void addNewBook(Book newBook)
    {
        boolean hasAuthorThisBook = false;
        Iterator<Book> itr = authorBooks.iterator();
        while (itr.hasNext())
        {
            if(itr.next().equals(newBook))
            {
                hasAuthorThisBook = true;
            }
        }
        if(!hasAuthorThisBook)
        {
            authorBooks.add(newBook);
        }else{
            System.out.println("This book already create it.");
        }

    }


    @Override
    public void whoYouAre() {
        System.out.println("Author: " + super.getName());
    }
}
