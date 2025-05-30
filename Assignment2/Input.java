import java.util.Scanner;

public class Input
{
    private static Scanner sc;

    static
    {
        sc = new Scanner(System.in);
    }

    // Methods in alphabetical order
    public static char acceptCharInput(String msg, int idx)
    {
        System.out.println(msg);
        return sc.nextLine().charAt(idx);
    }

    public static double acceptDoubleInput(String msg)
    {
        System.out.println(msg);
        return Double.parseDouble(sc.nextLine());
    }

    public static int acceptIntegerInput(String msg)
    {
        System.out.println(msg);
        return Integer.parseInt(sc.nextLine());
    }

    public static String acceptStringInput(String msg)
    {
        System.out.println(msg);
        return sc.nextLine();
    }

    public static Scanner getScanner()
    {
        return sc;
    }

    public static void setScanner(Scanner scanner)
    {
        sc = scanner;
    }
}
