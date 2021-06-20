package oop.assignment3.ex46.base;

import oop.assignment3.ex41.base.Name_Sorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class fileReader_WordbyWordTest {

    @Test
    void fileReaderWord() {

        BufferedReader readFile = null;

        // uploading a random file.  I am expecting the third word to be  "Chocolate"
        ArrayList<String> fileContent = fileReader_WordbyWord.fileReaderWord(readFile, "src/test/java/oop/assignment3/ex46/base/ex46-Test.Input.txt");
        String expected = "Chocolate";
        String actual = fileContent.get(2);
        Assertions.assertTrue(actual.equals(expected));
    }
}