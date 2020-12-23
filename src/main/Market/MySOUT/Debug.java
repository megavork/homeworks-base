package MySOUT;

/**
 * Class need to lock and unlock all my prints I used for debugging
 */
public class Debug {
    private static boolean flag = true;

    public static void sout(String line) {
        if(flag)
            System.out.println(line);
    }
}
