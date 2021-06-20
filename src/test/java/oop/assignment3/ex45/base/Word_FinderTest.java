package oop.assignment3.ex45.base;

import oop.assignment3.Tools.File_Reader;
import oop.assignment3.ex41.base.Name_Sorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class Word_FinderTest {

    public static BufferedReader readFile = null;
    public static BufferedWriter writeFile = null;
    public static ArrayList<String> fileLines = File_Reader.fileReader(readFile, "src/test/java/oop/assignment3/ex45/base/ex45_Test_Input");
    public static final String oldWord = "file";
    public static final String newWord = "FILE";
    @Test
    void wordReplacer() {
        // I expect to find word FILE in the Array returned
        fileLines = Word_Finder.wordReplacer(fileLines, oldWord, newWord);
        String lines = fileLines.toString();
        boolean output = lines.contains("FILE");

        Assertions.assertTrue(output);

    }
    @Test
    void fileWriter(){


        writeFile = Word_Finder.fileWriter(writeFile, fileLines, "src/test/java/oop/assignment3/ex45/base/ex45_Test_Output");
        boolean actualOutput = writeFile != null;
        Assertions.assertTrue(actualOutput);
    }
}