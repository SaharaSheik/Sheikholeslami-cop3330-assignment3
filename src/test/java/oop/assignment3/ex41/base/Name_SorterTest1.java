package oop.assignment3.ex41.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Name_SorterTest {
    BufferedReader readFile = null;
    BufferedWriter writeFile = null;

    Name_SorterTest() {
    }

    @Test

        // uploading a random file.  I am expecting the first line to be  "Sheikholeslami,Sahar"
    void fileReader() {
        ArrayList<String> fileLines = Name_Sorter.fileRead(this.readFile, "src/main/java/oop/assignment3/ex41/base/testFile-ex41");
        String expected = "Sheikholeslami, Sahar";
        String actual = (String)fileLines.get(0);
        Assertions.assertTrue(actual.equals(expected));
    }

    @Test
    void fileWriter() {
        // making sure the pointer to output file is created and no longer NULL (file was created successfully)


        ArrayList<String> fileLines = Name_Sorter.fileRead(this.readFile, "src/main/java/oop/assignment3/ex41/base/testFile-ex41");
        Collections.sort(fileLines);
        this.writeFile = Name_Sorter.fileWriter(this.writeFile, fileLines, "src/main/java/oop/assignment3/ex41/base/ex41-testOutputFile.txt");
        boolean actualOutput = this.writeFile != null;
        Assertions.assertTrue(actualOutput);
    }
}