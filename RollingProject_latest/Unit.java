public class Unit
{
    private String unitCode;
    private String unitDescription;
    private int creditPoints;

    public Unit()
    {
        unitCode = "NULL";
        unitDescription = "NULL";
        creditPoints = -1;
    }

    public Unit(String _unitCode, String _unitDescription, int _creditPoints)
    {
        unitCode = _unitCode;
        unitDescription = _unitDescription;
        creditPoints = _creditPoints;
    }

    public void display()
    {
        System.out.println(this.toString());
    }

    public int getCreditPoints()
    {
        return creditPoints;
    }

    public String getUnitCode()
    {
        return unitCode;
    }

    public String getUnitDescription()
    {
        return unitDescription;
    }

    public void setCreditPoints(int _creditPoints)
    {
        creditPoints = _creditPoints;
    }

    public void setUnitCode(String _unitCode)
    {
        unitCode = _unitCode;
    }

    public void setUnitDescription(String _unitDescription)
    {
        unitDescription = _unitDescription;
    }

    public String toString()
    {
        return "{Unit: UnitCode = " + unitCode + "UnitDescription = " + unitDescription + "CreditPoints = "
                + creditPoints + "}";
    }
}
