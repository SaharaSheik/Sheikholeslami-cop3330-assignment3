package oop.assignment3.ex41.challenge.challenge1;

import java.io.*;
import java.util.*;

/*
   *  UCF COP3330 Summer 2021 Assignment 3 Solution
   *  Copyright 2021 Sahar Sheikholelsami
   */
/*
Exercise 41 - Name Sorter - Challenge 1 DONE!
Alphabetizing the contents of a file, or sorting its contents, is a great way to get comfortable manipulating a
file in your program.

Create a program that reads in the following list of names from a file called `exercise41_input.txt`

and sorts the list alphabetically:

Ling, Mai
Johnson, Jim
Zarnecki, Sabrina
Jones, Chris
Jones, Aaron
Swift, Geoffrey
Xiong, Fong
Then print the sorted list to a file called `exercise41_output.txt`

that looks like the following example output.

Example Output
Total of 7 names
-----------------
Johnson, Jim
Jones, Aaron
Jones, Chris
Ling, Mai
Swift, Geoffrey
Xiong, Fong
Zarnecki, Sabrina
Constraint
Don't hard-code the number of names.
Challenges
Implement this program by reading in the names from the user, one at a time,
and printing out the sorted results to a file.
Use the program to sort data from a large data set (e.g. census data) and use a profiler to analyze its performance.
 */

import javax.lang.model.type.NullType;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Name_Sorter_Challenge1 {

    private static Scanner input = new Scanner(System.in);

        public static void main(String[] args) {

            //step 1: create two file references (in and out)
            //step 2: create read method
            //step 3: pass reference to a read method along with file name (passing file name helps with testability)
            //step 4: store the data inside a string array
            //step 5: return string to main
            //step 6: use collection method to sort
            //step 7: take the string from step 6
            //step 8: pass the string, name of file and output file pointer to a file writer
            //step 9: need to get  num of strings(aka num of names) by checking on string length in the file writer
            //step 10: return the output pointer to ensure its no longer NULL and file was created.  helps wth testing



            BufferedWriter writeFile=null;

            ArrayList<String> UserInput = getUserInput();

            Collections.sort(UserInput);

            writeFile = fileWriter(writeFile, UserInput,"src/main/java/oop/assignment3/ex41/challenge/challenge1/exercise41_challenge1.output.txt");




        }



        public static ArrayList<String> getUserInput() {

            ArrayList<String> fileLines = new ArrayList<>();

            String choice;

                while (true)
                {
                    System.out.print("enter a name or type EXIT to exit the program: ");
                    choice = input.nextLine();
                    if (choice.equals("EXIT"))
                        break;

                    fileLines.add(choice);

                }


            return fileLines;
        }

        public static BufferedWriter fileWriter(BufferedWriter outputFile, ArrayList<String> sortedString, String fileName){

            try {
                outputFile = new BufferedWriter(new FileWriter(fileName));

                // get num of lines for the firs print line
                int numOfLines = sortedString.size();

                outputFile.write("Total of " + numOfLines + " names\n-----------------\n");

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

