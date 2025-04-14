public class NumberDisplay
{
    private int limit;
    private int value;

    public NumberDisplay()
    {
        limit = 0;
        value = 1;
    }

    public NumberDisplay(int _value, int _limit)
    {
        limit = _limit;
        value = _value >= _limit ? _value % _limit : _value;
    }

    public int getLimit()
    {
        return limit;
    }

    public int getValue()
    {
        return value;
    }

    public void setLimit(int _limit)
    {
        limit = _limit;
    }

    public void setValue(int _value)
    {
        value = _value;
    }

    public String toString()
    {
        return "{limit = " + limit + ", value = " + value + "}";
    }

    public void display()
    {
        System.out.print(this.toString());
    }

    public void increment()
    {
        value = (value + 1) >= limit ? (value + 1) % limit : value + 1;
    }
}