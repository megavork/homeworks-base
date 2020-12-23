package MySOUT;

/**
 * Class need to lock and unlock all my prints I used for debugging
 */
public class Debug {
    public static boolean flag = true;

    public static void sout(String line) {
        if(flag)
            System.out.println(line);
    }
    public static void sout(int line) {
        if(flag)
            System.out.println(line);
    }
}
