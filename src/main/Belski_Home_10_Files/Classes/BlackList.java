package Classes;

import java.io.*;
import java.util.ArrayList;

public class BlackList {

    private static ArrayList<String> blackList = new ArrayList<>();
    private static int countOfBadLines = 0;

    public BlackList() {
    }
    public static void getBlackList() throws IOException {
        FileReader file = new FileReader("wordList.txt");

        try(BufferedReader read = new BufferedReader(file)) {
            String word = read.readLine();
            do {
                if(!word.isEmpty())
                    blackList.add(word);
            } while((word = read.readLine()) != null);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            file.close();
        }
    }

    public static void readAndCheckText() throws IOException {
        FileReader file = new FileReader("textIn2.txt");

        try(BufferedReader read = new BufferedReader(file)) {

            String oneSymbol = "";
            String oneLine = "";
            int symbol = read.read();

            do {
                oneSymbol = String.valueOf((char)symbol);

                if (!oneSymbol.equals(".") && !oneSymbol.equals("!") && !oneSymbol.equals("?")) {
                    oneLine += oneSymbol;
                    continue;
                }
                oneLine += oneSymbol;

                if(checkLine(oneLine)) {
                    System.out.println("Bad line: " + oneLine);
                    countOfBadLines++;
                    oneLine="";
                }
            } while((symbol = read.read()) != -1 );

            if(countOfBadLines > 0) {
                System.out.println("Counts of bad lines: "+countOfBadLines);
            }
            oneLine = "";
            countOfBadLines=0;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            file.close();
        }

    }
    /**
     * check contains line blacklist words or not.
     * if contains will return true.
     * @param line
     * @return
     */
    private static boolean checkLine(String line) {
        String[] words = line.split(" ");

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < blackList.size(); j++) {
                if(words[i].contains(blackList.get(j))) {   //решает проблему: неполное слово/однокоренное/форма и т.д
                    return true;
                }
            }
        }
        return false;
    }
}
