package oop.assignment3.ex46.base;

import java.io.BufferedReader;
import java.util.*;


/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Sahar Sheikholelsami
 */
/*
Knowing how often a word appears in a sentence or block of text is helpful for creating word clouds and other

types of word analysis. And it’s more useful when running it against lots of text.

Create a program that reads in a file named `exercise46_input.txt` and counts the frequency of words in the file.

 Then construct a histogram displaying the words and the frequency, and display the histogram to the screen.

Example Output
Given the text file `exercise46_input.txt` with this content

badger badger badger
badger mushroom
mushroom snake badger badger
badger
the program would produce the following output:

badger:   *******
mushroom: **
snake:    *
Constraint
Ensure that the most used word is at the top of the report and the least used words are at the bottom.
Challenges
Use a graphical program and generate bar graphs.
Test the performance of your calculation by providing a very large input file, such as Shakespeare's Macbeth. Tweak your algorithm so that it performs the word counting as fast as possible.
Write the program in another language and compare the processing times of the two implementations.


*/
public class WordFrequency_Finder {

    public static BufferedReader readFile = null;

    public static void main(String[] args) {

        // list needs to be sorted by word and frequency
        // create an Array list to put the words from the file in it (call the read file Reader Class).
        // receive the array in main and sort it.  This way the words can be compared one after another
        // write a word frequency counter that puts each word with its corresponding num of repeats inside map
        //consider factors like repeats of some words.  Cannot use hashMap or tree map key with identical keys.
        // use words as keys so they are unique and add frequency as value
        //create a loop so maps wont be repeated for the same word
        // created a method to compare and sort the maps based on the values (in this case frequencies).
        // ** make case of repeated has been handled, return a 1 if they are equal
        // print the *s by looping a nested loop.  *s will be printed in the amount equal to the corresponding
        // key maps for each word


        ArrayList<String> fileContent = fileReader_WordbyWord.fileReaderWord(readFile, "src/main/java/oop/assignment3/ex46/base/exercise46_input.txt");

        Collections.sort(fileContent);

        Map< String, Integer> unsortedMap = wordFrequencyMapCreator(fileContent);

        SortedSet<Map.Entry<String ,Integer>> sortedMap = sortMapsByValue(unsortedMap);

        printHistogram(sortedMap);


    }

    public static Map <String, Integer> wordFrequencyMapCreator(ArrayList<String> fileContent) {

        // handle boundary cases.
        // a) if the last words are all the same, the loop has to break without iterating more once i reaches
        // end of Array
        // b) if the very last word is repeated only once, no need to loop anymore.
        // for case b, make sure the last word is added to the map before breaking


        Map<String, Integer> wordMap = new HashMap<>();

       int counter;

        for (int i = 0; i < fileContent.size(); i++) {

            counter = 1;  // initialize counter to 1 each time loop finishes to starting counting again



            if (i == (fileContent.size() - 1)) {  // handling the boundary case: if last word only repeated once

                wordMap.put(fileContent.get(i), counter);
                break;
            }


            while (fileContent.get(i).equals(fileContent.get(++i))) {

                counter++;

                if (i == fileContent.size() - 1) {
                    // handle boundary case, if the loop continues until last word
                    // (aka last few words are all the same)
                    break;
                }
            }

            // loop breaks if != , make sure --i to get value of the compared word
            wordMap.put(fileContent.get(--i), counter);

            // handle the case if thr last two words are the same
            if (i == fileContent.size() - 2 && fileContent.get(i).equals(fileContent.get(i + 1)))
                break;


        }


        return wordMap;
    }



    public static void printHistogram(SortedSet<Map.Entry<String ,Integer>> sortedMap) {

      //iterate through sorted map and get the keys and values for each entry
        // store them in arrays so we can access them im decending order

        ArrayList<String> wordArray = new ArrayList<>();
        ArrayList<Integer> frequency = new ArrayList<>();



        for (Map.Entry<String, Integer> data : sortedMap){

            wordArray.add(data.getKey());
            frequency.add(data.getValue());

        }

        // start the loop from last to first, could also reverse and  traverse

       for (int i=wordArray.size()-1; i>=0 ; i--){

           System.out.print(String.format("%-10s", wordArray.get(i) + ":"));
           System.out.print(String.format("%-5.10s", ""));

           // print num of starts based on corresponding frequencies stored in Int array

           for (int j = 0; j < frequency.get(i); j++) {
           System.out.print("*");
           }
           System.out.println();
       }


       }


// compare values in the Maps and sort accordingly

    static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> sortMapsByValue(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        int res = e1.getValue().compareTo(e2.getValue());
                        return res != 0 ? res : 1; // make sure to handle cases of equal values
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}

