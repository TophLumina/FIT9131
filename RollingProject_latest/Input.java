import java.util.Scanner;

public class Input 
{
    private Scanner sc;

    public Input()
    {
        sc = new Scanner(System.in);
    }

    public char acceptCharInput(String msg, int idx)
    {
        System.out.println(msg);
        return sc.nextLine().charAt(idx);
    }

    public double acceptDoubleInput(String msg)
    {
        System.out.println(msg);
        return Double.parseDouble(sc.nextLine());
    }

    public int acceptIntegerInput(String msg)
    {
        System.out.println(msg);
        return Integer.parseInt(sc.nextLine());
    }

    public String acceptStringInput(String msg)
    {
        System.out.println(msg);
        return sc.nextLine();
    }
}
