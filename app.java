import java.util.ArrayList;
import java.util.Scanner;

public class app {
    public static int sum(int... args) {
        int tmp = 0;
        for (int item : args)
            tmp += item;

        return tmp;
    }

    public static int fooSum(int... args) {
        return sum(args);
    }

    public static void func() {
        System.out.println("Please input a seat loction. A|B|C");
        Scanner console = new Scanner(System.in);
        String in_str = console.nextLine();
        console.close();
        char seatLocation = in_str.length() > 1 ? ' ' : in_str.charAt(0);
        int price = 0;
        switch (seatLocation) {
            case 'A':
                System.out.println("Front row");
                price = 100;
                break;
            case 'B':
                System.out.println("Stalls");
                price = 80;
                break;
            case 'C':
                System.out.println("Balcony");
                price = 55;
            default:
                System.out.println("Unknown seat location");
                price = 0;
                break;
        }
        System.out.println(price);
    }

    public static void main(String[] args) {
        // System.out.println("HELLO FIT9131!");

        // System.out.println(fooSum(new int[] { 1, 2, 3, 4 }));
        // func();

        // int s = 0;
        // for (int it : new int[] { 1, 2, 3, 4 }) {
        //     s += it;
        // }

        String str = "      dsj sddsd     ";
        System.out.println(str.toUpperCase().trim());

        // System.out.println(s);
    }
}

class GenericClass<T> {
    private T t;

    public GenericClass(T _t) {
        t = _t;
    }

    public <E> T dosomething(E e) {
        return t;
    }
}

class Framebuffer<T extends Number> {
    int width = 0;
    int height = 0;
    ArrayList<ArrayList<T>> data = new ArrayList<ArrayList<T>>(0);
}