package Classes;

import java.io.*;

public class WordFormatter {

    private String[] pocketToWrite = new String[50];
    private int pocketToWriteEmptyElement = 0;

    public WordFormatter() {
    }

    public void readWords() throws IOException {
        FileReader file = new FileReader("textIn.txt");

        try(BufferedReader read = new BufferedReader(file)) {
            String word = read.readLine();
            do {
                if (isPalidrome(word)) {
                    pocketToWrite[pocketToWriteEmptyElement] = word;
                    pocketToWriteEmptyElement++;
                    System.out.println(word);
                    if(pocketToWriteEmptyElement == 50) {
                        writeInFile();
                    }
                }
            } while((word = read.readLine()) != null);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writeInFile();
            file.close();
        }
    }

    /**
     * swap symbols and check if result equals input word
     * return true if equals, false else.
     * @param OneWord
     * @return
     */
    static boolean isPalidrome(String OneWord) {
        if(OneWord.length() < 2)
            return false;

        String temp = new String();

        for (int i = OneWord.length()-1; i >= 0; i--) {
            temp += OneWord.charAt(i);
        }

        if(temp.equals(OneWord))
            return true;
        else
            return false;
    }

    /**
     * will write if buffer contains 50 words.
     */
    public void writeInFile() throws IOException {
        FileWriter file = new FileWriter("textOut.txt",true);

        try(BufferedWriter write = new BufferedWriter(file)) {
            int count = 0;

            do {
                write.append(pocketToWrite[count]);
                write.newLine();
                count++;
            }while(count < pocketToWriteEmptyElement);

            pocketToWriteEmptyElement=0;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            file.close();
        }
    }

}
