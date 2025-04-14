public class Enrollment
{
    private String date;
    private Student student;
    private Unit[] units;

    public Enrollment()
    {
        date = "null";
        student = new Student();
        units = new Unit[4];
    }

    public Enrollment(String _date, Student _student, Unit[] _units)
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

    public Unit[] getUnits()
    {
        return units;
    }

    public void inputStudentDetail()
    {
        Input in = new Input();
        // TODO::Validation
        student.setName(in.acceptStringInput("Please enter the student name."));
        student.setAddress(in.acceptStringInput("Please enter the student address."));
        student.setPhoneNo(in.acceptStringInput("Please enter the student phone number."));
        student.setEmail(in.acceptStringInput("Please enter the student email."));
    }

    public void inputUnitDetail()
    {
        Input in = new Input();
        // TODO::Validation
        Unit[] units = new Unit[4];
        for (int i = 0; i < 4; ++i)
        {
            // unit.setUnitCode(in.acceptStringInput("Please enter the unit code."));
            // unit.setUnitDescription(in.acceptStringInput("Please enter the unit description."));
            // unit.setCreditPoints(in.acceptIntegerInput("Please enter the unit credit points."));
            
            String name = in.acceptStringInput("Please enter the unit code.");
            String desc = in.acceptStringInput("Please enter the unit description.");
            int cred = in.acceptIntegerInput("Please enter the unit credit points.");
            units[i] = new Unit(name, desc, cred);
        }
    }

    public void setDate(String _date)
    {
        date = _date;
    }

    public void setStudent(Student _student)
    {
        student = _student;
    }

    public void setUnits(Unit[] _units)
    {
        units = _units;
    }

    public void startProgram()
    {
        // TODO:: Starting Point
    }

    public String toString()
    {
        return "{Enrollment: date = " + date + ", " + student.toString() + ", " + units.toString() + "}";
    }
}
