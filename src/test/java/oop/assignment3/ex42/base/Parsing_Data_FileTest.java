package oop.assignment3.ex42.base;

import oop.assignment3.ex41.base.Name_Sorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Collections;

class Parsing_Data_FileTest {
    BufferedReader readFile = null;
    BufferedWriter writeFile = null;
    @Test
    void fileWriter() {
        // making sure the pointer to output file is created and no longer NULL (file was created successfully)
        ArrayList<String> fileLines = Name_Sorter.fileRead(this.readFile, "src/test/java/oop/assignment3/ex42/base/Test_InputFile");
        Collections.sort(fileLines);
        this.writeFile = Parsing_Data_File.fileWriter(this.writeFile, fileLines, "src/test/java/oop/assignment3/ex42/base/Test_OutputFile");
        boolean actualOutput = this.writeFile != null;
        Assertions.assertTrue(actualOutput);
    }


    @Test
    void fileReader() {

        // uploading a random file.  I am expecting the first line to be  "Sheikholeslami,Sahar,100,000"
        ArrayList<String> fileLines = Name_Sorter.fileRead(this.readFile, "src/test/java/oop/assignment3/ex42/base/Test_InputFile");
        String expected = "Sheikholeslami,Sahar,100,000";
        String actual = (String)fileLines.get(0);
        Assertions.assertTrue(actual.equals(expected));
    }


}