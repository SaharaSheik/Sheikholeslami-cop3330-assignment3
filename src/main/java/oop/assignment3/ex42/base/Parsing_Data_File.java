package oop.assignment3.ex42.base;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Sahar Sheikholelsami
 */
/*
Exercise 42 - Parsing a Data File
Sometimes data comes in as a structured format that you have to break down and turn into records so you can process them.

CSV, or comma-separated values, is a common standard for doing this.

Construct a program that reads in the following data file (you will need to create this data file yourself;

name it `exercise42_input.txt`):

Ling,Mai,55900
Johnson,Jim,56500
Jones,Aaron,46000
Jones,Chris,34500
Swift,Geoffrey,14200
Xiong,Fong,65000
Zarnecki,Sabrina,51500


Process the records and display the results formatted as a table, evenly spaced, as shown in the example output.

Example Output
Last      First     Salary
--------------------------
Ling      Mai       55900
Johnson   Jim       56500
Jones     Aaron     46000
Jones     Chris     34500
Swift     Geoffrey  14200
Xiong     Fong      65000
Zarnecki  Sabrina   51500



Constraints
Write your own code to parse the data. Don't use a CSV parser.
Challenges
Make each column one space longer than the longest value in the column.
Format the salary as currency with dollar signs and commas.
Sort the results by salary from highest to lowest.
Rework your program to use a CSV parsing library and compare the results.

 */

import oop.assignment3.Tools.File_Reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Parsing_Data_File {

    public static BufferedReader readFile=null;
    public static BufferedWriter writeFile=null;
    public static void main(String[] args) {

        //step 1: create two file references (in and out)
        //step 2: use read method from Tools package classes I created
        //step 3: pass reference to a read method along with file name (passing file name helps with testability).
        //read file function was tested in exercise 42
        //step 4: return string to main
        //step 5: take the string from step 6 to write function
        //step 6: pass the string, name of file and output file pointer to a file writer
        //step 7: Parse data by slicing each line by regex ','
        //step 8: format the out by format.string
        //step 9: return the output pointer to ensure its no longer NULL and file was created.  helps wth testing

        ArrayList<String> fileLines = File_Reader.fileReader(readFile, "src/main/java/oop/assignment3/ex42/base/exercise42_input.txt");
        writeFile = fileWriter(writeFile, fileLines,"src/main/java/oop/assignment3/ex42/base/exercise42_output.txt");

    }



    public static BufferedWriter fileWriter(BufferedWriter outputFile, ArrayList<String> inputString, String fileName){

        try {
            outputFile = new BufferedWriter(new FileWriter(fileName));
            String[] parsedString;



            outputFile.write("Last      First     Salary\n--------------------------\n");

            for (String eachline : inputString)
            {
                parsedString = eachline.split(",");
                outputFile.write(String.format("%-10s" + "%-10.10s" + "%-10.50s", parsedString[0], parsedString[1], parsedString[2]));

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
