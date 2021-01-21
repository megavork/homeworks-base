package Market_11.Market;

public class Menu {
    private static String line1 = "************* Market *************";
    private static String line2 = "Options:";
    private static String line3 = "_1_ Show all items in the base.";
    private static String line4 = "_2_ Sort items by ascending order (price).";
    private static String line5 = "_3_ Sort items by order of addition.";
    private static String line6 = "_4_ Add new item to the base.";
    private static String line7 = "_5_ Remove item from the base.";
    private static String line8 = "_6_ Edit Item.";
    private static String line9 = "_7_ Show XML.";
    private static String line10 = "_8_ Convert Items to Json";
    private static String line11 = "_9_ Convert Json to Java Objects";
    private static String line12 = "_0_ Exit.";

    /**
     * will show all menu lines
     */
    public static void showAllMenu() {
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);
        System.out.println(line6);
        System.out.println(line7);
        System.out.println(line8);
        System.out.println(line9);
        System.out.println(line10);
        System.out.println(line11);
        System.out.println(line12);
    }

    /**
     * will show only options lines
     */
    public static void showOptions() {
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);
        System.out.println(line6);
        System.out.println(line7);
        System.out.println(line8);
        System.out.println(line9);
        System.out.println(line10);
        System.out.println(line11);
        System.out.println(line12);
    }

}
