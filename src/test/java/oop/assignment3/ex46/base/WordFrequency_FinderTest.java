package oop.assignment3.ex46.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.util.*;

class WordFrequency_FinderTest {

    @Test
    void wordFrequencyMapCreator() {

        // upload a random text file.  check the frequency of some words

        BufferedReader readFile = null;
        ArrayList<String> fileContent = fileReader_WordbyWord.fileReaderWord(readFile, "src/test/java/oop/assignment3/ex46/base/ex46-Test.Input.txt");
        Collections.sort(fileContent);


        Map< String, Integer> unsoretedMap =WordFrequency_Finder.wordFrequencyMapCreator(fileContent);

        // I expect the Sahar frequency to be 2, Ashley, 3 and Pizza 1


        int expectedFrequency1 = 2;
        int expectedFrequency2 = 3;
        int expectedFrequency3 = 1;

        int actualFrequency1 = unsoretedMap.get("Sahar");
        int actualFrequency2 = unsoretedMap.get("Ashley");
        int actualFrequency3 = unsoretedMap.get("Pizza");

        // chekcing to see if all three keys respond correctly with their corresponding expected frequencies

        boolean result = (actualFrequency1 == expectedFrequency1 && actualFrequency2 == expectedFrequency2 && actualFrequency3 == expectedFrequency3);
        Assertions.assertTrue(result);


    }


    @Test
    void sortMapsByValue() {

        // upload a random text file.  check the frequency of some words


        BufferedReader readFile = null;
        ArrayList<String> fileContent = fileReader_WordbyWord.fileReaderWord(readFile, "src/test/java/oop/assignment3/ex46/base/ex46-Test.Input.txt");
        Collections.sort(fileContent);

        Map< String, Integer> unsoretedMap =WordFrequency_Finder.wordFrequencyMapCreator(fileContent);

        SortedSet<Map.Entry<String ,Integer>> sortedMap = WordFrequency_Finder.sortMapsByValue(unsoretedMap);

        // I expect the highest frequency to be 3 for the word Coffee and that to be the last word
        // I expect the lowest frequency to be 1 and since there are they will be alphabetically organized so Apples should come first

        int expectedFrequencyFirst = 1;
        String expectedWordFirst = "Apples";

        int expectedFrequencyLast = 3;
        String expectedWord2Last= "Coffee";

        // get the first set of value map
        Map.Entry<String, Integer> value = sortedMap.first();

        String actualWordFirst = value.getKey();
        int actualFrequencyFirst = value.getValue();

        // get the last set of value map.
        Map.Entry<String, Integer> value2 = sortedMap.last();

        String actualWordLast = value2.getKey();
        int actualFrequencyLast = value2.getValue();



        boolean result = (expectedFrequencyFirst == actualFrequencyFirst && expectedFrequencyLast == actualFrequencyLast
        && expectedWordFirst.equals(actualWordFirst) && expectedWord2Last.equals(actualWordLast));
        Assertions.assertTrue(result);

    }
}
