package Classes;

public class TextFormatter {

    public TextFormatter() {
    }
    public static int getWordCount(String line) {
        String[] buffer = line.split(" ");
        if(buffer[0].isEmpty())
            return buffer.length-1;
        else
            return buffer.length;
    }

    public static boolean checkPalindromWords(String line) {
        String[] buffer = line.split(" ");

        for (int i = 0; i < buffer.length; i++) {
            if(!buffer[i].isEmpty() && WordFormatter.isPalidrome(buffer[i])) {
                return true;
            }
        }
        return false;
    }

}
