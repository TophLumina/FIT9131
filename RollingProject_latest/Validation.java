public class Validation {
    public static boolean isBlank(String str)
    {
        return str.isBlank();
    }
    
    public static boolean stringLengthRange(String str, int min, int max)
    {
        return str.length() >= min && str.length() <= max;
    }
}
