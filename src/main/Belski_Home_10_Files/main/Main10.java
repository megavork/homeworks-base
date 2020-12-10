package main;

import Classes.BlackList;
import Classes.TextFormatter;
import Classes.WordFormatter;

import java.io.*;

public class Main10 {

    private static boolean isShortString = false;
    private static String bufferNextLine = "";

    public static void main(String[] args) throws IOException {
        System.out.println("Exercise 1.");
        WordFormatter tex = new WordFormatter();
        tex.readWords();

        System.out.println("Exercise 2.");
        readFile();

        System.out.println("Exercise 3.");
        BlackList.getBlackList();
        BlackList.readAndCheckText();
    }








    private static void writeFile(String line) throws IOException {
        FileWriter file = new FileWriter("textOut2.txt",true);

        try(BufferedWriter write = new BufferedWriter(file)) {
                write.append(line);
                write.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            file.close();
        }
    }

    private static void readFile() throws IOException {
        FileReader file = new FileReader("textIn2.txt");

        try(BufferedReader read = new BufferedReader(file)) {

            String oneSymbol = "";
            String oneLine = "";
            int symbol;

            while((symbol = read.read()) != -1 ) {
                oneSymbol = String.valueOf((char)symbol);

                if (!oneSymbol.equals(".") && !oneSymbol.equals("!") && !oneSymbol.equals("?")) {
                    oneLine += oneSymbol;
                    continue;
                }
                oneLine += oneSymbol;
                int countWords = TextFormatter.getWordCount(oneLine);

                if(TextFormatter.checkPalindromWords(oneLine) || (countWords > 3 && countWords < 6)) {
                    writeFile(oneLine);
                    oneLine = "";
                }
                oneLine = "";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            file.close();
        }
    }
}
