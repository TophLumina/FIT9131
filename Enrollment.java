public class Enrollment
{
    private String date;
    private Student student;
    private Unit units;

    public Enrollment()
    {
        date = "null";
        student = new Student();
        units = new Unit();
    }

    public Enrollment(String _date, Student _student, Unit _units)
    {
        date = _date;
        _student = student;
        units = _units;
    }

    public void display()
    {
        System.out.println(this.toString());
    }

    public String getDate()
    {
        return date;
    }

    public Student getStudent()
    {
        return student;
    }

    public Unit getUnits()
    {
        return units;
    }

    public void inputStudentDetail()
    {
        Input in = new Input();
        student.setName(in.acceptStringInput("Please enter the student name."));
        student.setAddress(in.acceptStringInput("Please enter the student address."));
        student.setPhoneNo(in.acceptStringInput("Please enter the student phone number."));
        student.setEmail(in.acceptStringInput("Please enter the student email."));
    }

    public void inputUnitDetail()
    {
        Input in = new Input();
        units.setUnitCode(in.acceptStringInput("Please enter the unit code."));
        units.setUnitDescription(in.acceptStringInput("Please enter the unit description."));
        units.setCreditPoints(in.acceptIntegerInput("Please enter the unit credit points."));
    }

    public void inputDate()
    {
        Input in = new Input();
        date = in.acceptStringInput("Please enter the enrollment date.");
    }

    public void setDate(String _date)
    {
        date = _date;
    }

    public void setStudent(Student _student)
    {
        student = _student;
    }

    public void setUnits(Unit _units)
    {
        units = _units;
    }

    public String toString()
    {
        return "{Enrollment: date = " + date + ", " + student.toString() + ", " + units.toString() + "}";
    }
}
