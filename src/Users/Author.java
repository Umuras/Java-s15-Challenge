package Users;

import LibrarySystem.Books.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Author extends Person{

    private List<Book> authorBooks;

    public Author(String name)
    {
        super(name);
        authorBooks = new ArrayList<>();
    }

    public List<Book> getAuthorBooks()
    {
        return authorBooks.stream().collect(Collectors.toUnmodifiableList());
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
            System.out.println("Yazara ait bu kitap zaten listede var!!!");
        }
    }

    public void removeBookFromBookList(Book book)
    {
        authorBooks.remove(book);
    }



    @Override
    public void whoYouAre() {
        System.out.println("Author: " + super.getName());
    }

    @Override
    public boolean equals(Object obj)
    {
      if(this == obj)
      {
          return true;
      }

      if (obj == null || this.getClass() != obj.getClass())
      {
          return false;
      }

      Author author = (Author) obj;
      return this.getName().equals(author.getName());
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(getName());
    }

    public String toString()
    {
        return "Author Name: " + getName() + " ";
    }
}
