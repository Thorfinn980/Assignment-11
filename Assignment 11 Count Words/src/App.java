import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


    //New Concept: PrintWriter
    /* PrintWriter acts like a pencil that I can write text to a piece of paper.
     * IMPORTANT: Creating a new PrwinterWriter, I need to tell which file I want to write to.
     */

    /*  CURRENT OBJ:
     *
     *  Write a java program to count words in an input file and write the results to an output file.
     * 
     *  The input file is a .txt file with each line a single word.
     *  The words are not case-sensitive. That means, "Dictionary" and "dictionary" will be treated as the same word in the file.
     * 
     *  Suppose the input file contains "hello" in 3 lines, "world" in 5 lines, and "java" in 6 lines. Your output will be a text file containing the following three lines:
     *  hello 3
     *  java 6
     *  world 5
     */


public class App {
    public static void main(String[] args) throws FileNotFoundException {

        int[] wordCounts = new int[26];
        Scanner scanner = new Scanner(new File("input.txt"));

        //For each line, the code first converts the entire line to lowercase using the toLowerCase() method. 
        //Problem statement specifies that the words are not case-sensitive
        //Store the first letter of each word is to keep track of how many words start with each letter of the alphabet.

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().toLowerCase();
            char firstChar = line.charAt(0);

            wordCounts[firstChar - 'a']++;
        }

        PrintWriter writer = new PrintWriter("output.txt");

        //Now write the word counts to the output file.
        for (int i = 0; i < wordCounts.length; i++) {

            //REMINDER: Base case to skip letters that don't have any words.
            if (wordCounts[i] == 0) {
                continue;
            }

            // Convert the letter index to a character and write to output file.
            char letter = (char) (i + 'a');
            writer.println(letter + " " + wordCounts[i]);
        }

        //Close due wrapping up.
        scanner.close();
        writer.close();
    }
}