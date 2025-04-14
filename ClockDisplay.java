public class ClockDisplay {
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private NumberDisplay seconds;
    private String displayString;

    public ClockDisplay()
    {
        hours = new NumberDisplay();
        minutes = new NumberDisplay();
        seconds = new NumberDisplay();
        displayString = "00 : 00 : 00";
    }

    public ClockDisplay(int _hours, int _minutes, int _seconds)
    {
        hours = new NumberDisplay(_hours, 24);
        minutes = new NumberDisplay(_minutes, 60);
        seconds = new NumberDisplay(_seconds, 60);
        displayString = hours.getValue() + " : " + minutes.getValue() + " : " + seconds.getValue();
    }

    public int getHours()
    {
        return hours.getValue();
    }

    public int getMinutes()
    {
        return minutes.getValue();
    }

    public int getSeconds()
    {
        return seconds.getValue();
    }

    public String getDisplayString()
    {
        return displayString;
    }

    public void setHours(int _hours)
    {
        hours.setValue(_hours);
    }

    public void setMinutes(int _minutes)
    {
        minutes.setValue(_minutes);
    }

    public void setSeconds(int _seconds)
    {
        seconds.setValue(_seconds);
    }

    public void setDisplayString(String _display)
    {
        displayString = _display;
    }

    public void display()
    {
        System.out.println(displayString);
    }

    public static void main(String[] args) {

    }
    
    public void setTime(int _hours, int _minutes, int _seconds)
    {
        setHours(_hours);
        setMinutes(_minutes);
        setSeconds(_seconds);
        updateDisplay();
        display();
    }

    public void timeTick()
    {
        seconds.increment();
        if (seconds.getValue() == 0)
            minutes.increment();
        if (minutes.getValue() == 0)
            hours.increment();
        updateDisplay();
    }
    
    public void updateDisplay()
    {
        setDisplayString(hours.getValue() + " : " + minutes.getValue() + " : " + seconds.getValue());
    }
}
