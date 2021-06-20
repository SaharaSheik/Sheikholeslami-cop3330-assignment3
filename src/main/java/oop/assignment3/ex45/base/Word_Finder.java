package oop.assignment3.ex45.base;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Sahar Sheikholelsami
 */
/*
Exercise 45 - Word Finder
        There will be times when you'll need to read in one file, modify it, and then write a
        modified version of that file to a new file.

        Given an input file named `exercise45_input.txt`, read the file and look for all
        occurrences of the word utilize. Replace each occurrence with use. Write the modified file to a new file.

        Example Output
        Given the input file of

        One should never utilize the word "utilize" in writing. Use "use" instead.
        For example, "She uses an IDE to write her Java programs" instead of "She
        utilizes an IDE to write her Java programs".
        The program should generate

        One should never use the word "use" in writing. Use "use" instead.
        For example, "She uses an IDE to write her Java programs" instead of "She
        uses an IDE to write her Java programs".
        Constraints
        Prompt for the name of the output file.
        Write the output to a new file.
        Challenges
        Modify the program to track the number of replacements and report that to the screen when the program finishes.
        Create a configuration file that maps “bad” words to “good” words and use this file instead of a hard-coded value.
        Modify the program so that it can handle every file in a folder of files instead of a single file.
*/


import oop.assignment3.Tools.File_Reader;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Word_Finder {

    public static BufferedReader readFile = null;
    public static BufferedWriter writeFile = null;
    private static final Scanner input = new Scanner(System.in);
    public static final String oldWord = "utilize";
    public static final String newWord = "use";


    public static void main(String[] args) {

        // first read the file
        // store each line as a string in a Array List
        // create a function to extract the old words and replaces them with new words
        // in the wordReplacer function iterate through the array list, string by string
        //use string function replace("string old word, "string new word") to replace all occurrences of word "utilize"
        // as each line is corrected store the data a new Array List String
        // Return the updated Array list - will use this later to print to a file
        // create a function to ask for file name
        //have to pass the directory so the name can be added on to the directory string
        //create a write function - use the updated Array list to print to the new file




        ArrayList<String> fileLines = File_Reader.fileReader(readFile, "src/main/java/oop/assignment3/ex45/base/exercise45_input.txt");


        fileLines = wordReplacer(fileLines, oldWord, newWord);


        String newFileName = createFileName("src/main/java/oop/assignment3/ex45/base/");

        writeFile = fileWriter(writeFile, fileLines, newFileName);

    }



        static public ArrayList<String> wordReplacer (ArrayList<String> fileLines, String oldWord, String newWord){
        // iterate the arraylist one string at the time
            //replace the old word with new word.
                // add each line/string to Array list


        ArrayList<String> replacedWordLines = new ArrayList<>();
        String replaced;


            for (String fileLine : fileLines) {

                replaced = fileLine.replace(oldWord, newWord);
                replacedWordLines.add(replaced);

            }

        return replacedWordLines;


    }

    public static String createFileName(String newFileName){

        //get the name for the file, concatenate the name to directory plus txt to create a text file

        System.out.print("Please enter a name for your output file (with no space): ");
        newFileName+=input.nextLine()+".txt";


        return newFileName;


    }

    public static BufferedWriter fileWriter(BufferedWriter outputFile, ArrayList<String> sortedString, String fileName){


        //create and write on a new file

        try {
            outputFile = new BufferedWriter(new FileWriter(fileName));


            for (String eachline : sortedString)
            {
                outputFile.write(eachline);

                outputFile.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try
            {
                if (outputFile != null)
                {
                    outputFile.close();
                }

            } catch (IOException e)
            {
                e.printStackTrace();
            }


        }


        return outputFile;

    }

}



