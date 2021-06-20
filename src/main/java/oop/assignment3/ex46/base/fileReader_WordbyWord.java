package oop.assignment3.ex46.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Sahar Sheikholelsami
 */

// read this file word by word instead of line by line
// we need each word to calculate its frequency
// add all the words to the array and return to main

public class fileReader_WordbyWord {


    public static ArrayList<String> fileReaderWord (BufferedReader inputFile, String fileName) {

        ArrayList<String> fileLines = new ArrayList<>();
        String[] wordsInLine;


        try {
            inputFile = new BufferedReader(new FileReader(fileName));

            String eachLines = inputFile.readLine();


            while (eachLines != null)
            {
                wordsInLine = eachLines.split(" ");

                for(int i=0; i<wordsInLine.length; i++)
                fileLines.add(wordsInLine[i]);

                eachLines = inputFile.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try
            {
                if (inputFile != null)
                {
                    inputFile.close();
                }

            } catch (IOException e)
            {
                e.printStackTrace();
            }


        }




        return fileLines;
    }
}
