public class Student
{
    private String name;
    private String address;
    private String phoneNo;
    private String email;

    public Student()
    {
        name = "NULL";
        address = "NULL";
        phoneNo = "NULL";
        email = "NULL";
    }

    public Student(String _name, String _address, String _phoneNo, String _email)
    {
        name = _name;
        address = _address;
        phoneNo = _phoneNo;
        email = _email;
    }

    public void display()
    {
        System.out.println(this.toString());
    }

    public String getAddress()
    {
        return address;
    }

    public String getEmail()
    {
        return email;
    }

    public String getName()
    {
        return name;
    }

    public String getPhoneNo()
    {
        return phoneNo;
    }

    public void setAddress(String _address)
    {
        address = _address;
    }

    public void setEmail(String _email)
    {
        email = _email;
    }

    public void setName(String _name)
    {
        name = _name;
    }

    public void setPhoneNo(String _phoneNo)
    {
        phoneNo = _phoneNo;
    }

    public String toString()
    {
        return "{Student: name = " + name + ", address = " + address + ", phoneNo = " + phoneNo + ", email = " + email
                + "}";
    }
}
