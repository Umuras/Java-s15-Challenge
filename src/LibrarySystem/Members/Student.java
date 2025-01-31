package LibrarySystem.Members;

import LibrarySystem.Enums.MemberType;

public class Student extends MemberRecord{

    private int issueBookValue = 0;

    public Student(Long memberID, MemberType type, String name, String address, String phoneNo) {
        super(memberID, type, name, address, phoneNo);
    }

    @Override
    public Object getMember() {
        return this;
    }

    @Override
    public void incrementBookIssued() {
        issueBookValue++;
        setNoBooksIssued(true);
    }

    @Override
    public void decrementBookIssued() {
        issueBookValue--;
        issueBookValue = Math.max(issueBookValue, 0);
        if(issueBookValue == 0)
        {
            setNoBooksIssued(false);
        }
    }

    @Override
    public void payBill() {

    }
}
