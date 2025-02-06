package LibrarySystem.Books;

import LibrarySystem.Enums.BookStatus;
import LibrarySystem.Enums.BookType;
import Users.Author;
import Users.Reader;

import java.time.LocalDateTime;

public abstract class Book {
    private Long bookID;
    private String name;
    private Double price;
    private Author author;
    private BookStatus status;
    private Double edition;
    private LocalDateTime dateOfPurchase;
    private Reader reader;
    private BookType bookType;
    public static Long stbookID = 1L;

    public Book(Long bookID, Author author, String name, Double price, Double edition)
    {
        this.bookID = stbookID;
        this.author = author;
        this.name = name;
        this.price = price;
        this.edition = edition;
        status = BookStatus.INLIBRARY;
        stbookID++;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getBookID()
    {
        return bookID;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Double getEdition()
    {
        return edition;
    }

    public void setEdition(Double edition)
    {
        this.edition = edition;
    }

    public Author getAuthor()
    {
        return author;
    }

    public void setAuthor(Author author)
    {
        this.author = author;
    }

    public LocalDateTime getDateOfPurchase()
    {
        return dateOfPurchase;
    }

    public BookType getBookType()
    {
        return bookType;
    }

    public void setBookType(BookType bookType)
    {
        this.bookType = bookType;
    }

    public void setReader(Reader reader)
    {
        this.reader = reader;
    }

    public Reader getOwner()
    {
        if(reader != null)
        {
            return reader;
        }
        System.out.println("This book hasn't a reader");
        return null;
    }

    public void changeOwner(Reader newReader)
    {
        if(BookStatus.BORROWLIBRARYBOOK.equals(this.status))
        {
            reader = newReader;
        }
    }

    public void display()
    {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("BookID: ").append(bookID).append("\n");
        strBuilder.append("BookName: ").append(name).append("\n");
        strBuilder.append("Book's Author: ").append(author.getName()).append("\n");
        strBuilder.append("Price: ").append(price).append("\n");
        strBuilder.append("Status: ").append(status).append("\n");
        strBuilder.append("Edition: ").append(edition).append("\n");

        System.out.println(strBuilder);
    }

    public void updateStatus(BookStatus status)
    {
        if(BookStatus.INLIBRARY.equals(this.status))
        {
            if(BookStatus.BORROWLIBRARYBOOK.name().equals(status.name()))
            {
                this.dateOfPurchase = LocalDateTime.now();
            }
            this.status = status;
        }else{
            this.dateOfPurchase = null;
            this.status = status;
        }
    }


    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }

        if(obj == null || this.getClass() != obj.getClass())
        {
            return false;
        }

        Book book = (Book)obj;
        return this.name.equals(book.getName()) &&
                this.author.getName().equals(book.getAuthor().getName());
    }

    @Override
    public String toString()
    {
        return "BookName: " + name;
    }
}
