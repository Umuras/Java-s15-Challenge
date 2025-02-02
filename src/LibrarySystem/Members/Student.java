package LibrarySystem.Members;

import LibrarySystem.Books.Book;
import LibrarySystem.Enums.MemberType;

public class Student extends MemberRecord{

    public Student(Long memberID, MemberType type, String name, String address, String phoneNo) {
        super(memberID, type, name, address, phoneNo);
    }

    @Override
    public MemberRecord getMember() {
        return this;
    }

    @Override
    public void incrementBookIssued() {
        setIssueBookValue(1);
        setNoBooksIssued(true);
    }

    @Override
    public void decrementBookIssued() {
        setIssueBookValue(-1);
        if(getIssueBookValue() == 0)
        {
            setNoBooksIssued(false);
        }
    }

    @Override
    public double payBill(Book book) {
        return book.getPrice();
    }

    @Override
    public String toString()
    {
        return "Member Name: " + getName() + "\n" + "Member type: " + getType() + "\n" + "Member address: " + getAddress() + "\n"
                + "Member phone: " + getPhoneNo() + "\n" + "Member Verify Status: " +getVerifiedMemberStatus();
    }
}
