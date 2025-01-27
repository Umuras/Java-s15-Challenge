package LibrarySystem.Books;

import LibrarySystem.Enums.BookStatus;
import Users.Author;
import Users.Reader;

import java.time.LocalDateTime;

public class Book {
    private Long bookID;
    private String name;
    private Double price;
    private String authorName;
    private BookStatus status;
    private Double edition;
    private LocalDateTime dateOfPurchase;

    public Book(Long bookID, String authorName, String name, Double price, Double edition)
    {
        this.bookID = bookID;
        Author author = new Author(authorName, this);
        this.name = name;
        this.price = price;
        this.edition = edition;
        dateOfPurchase = LocalDateTime.now();
        status = BookStatus.INLIBRARY;
    }

    public String getName()
    {
        return name;
    }

    public Long getBookID()
    {
        return bookID;
    }

    public Double getPrice()
    {
        return price;
    }

    public Double getEdition()
    {
        return edition;
    }

    public String getAuthor()
    {
        return authorName;
    }

    public String getOwner(Reader reader)
    {
       return reader.getName();
    }

    public void changeOwner()
    {

    }

    public void display()
    {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("BookID: ").append(bookID).append("\n");
        strBuilder.append("BookName: ").append(name).append("\n");
        strBuilder.append("Book's Author: ").append(authorName).append("\n");
        strBuilder.append("Price: ").append(price).append("\n");
        strBuilder.append("Status: ").append(status).append("\n");
        strBuilder.append("Edition: ").append(edition).append("\n");
        strBuilder.append("DateOfPurchase: ").append(dateOfPurchase);

        System.out.println(strBuilder);
    }

    public void updateStatus()
    {

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
        return this.name.equals(book.getName()) && this.bookID.equals(book.getBookID()) &&
                this.authorName.equals(book.getAuthor()) && this.edition.equals(book.getEdition());
    }

    @Override
    public String toString()
    {
        return "BookName: " + name;
    }
}
