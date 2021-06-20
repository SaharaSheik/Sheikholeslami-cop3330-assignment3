package oop.assignment3.ex43.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
// Please delete the file from the folder for test. otherwise identical file names will not allow the program to clear the folder

class Website_GeneratorTest {


    public static String sourceDirectoryinTestFolder = "src/test/java/oop/assignment3/ex43/base";
    public static final String ParentFolderName = "TestFolder_Website";
    public static final String subFolderName = "SubFolder1";
    public static FileWriter htmlFile = null;


    @Test
    void folderCreator() {

        // check to see if the folder was created sucessfully using mkdir;




        File folder = Website_Generator.folderCreator(sourceDirectoryinTestFolder,ParentFolderName);

        boolean result = folder.mkdirs();

        Assertions.assertTrue(result);

        sourceDirectoryinTestFolder += "//" + ParentFolderName;



    }

    @Test
    void testFolderCreator_FunctionOverload() {

        File folder = Website_Generator.folderCreator(sourceDirectoryinTestFolder, ParentFolderName, subFolderName);

        boolean result = folder.mkdirs();

        Assertions.assertTrue(result);


    }


    @Test
    void testFolderCreator_FunctionOverload2() {


        String subFolderName2 = "TestSubFolder2";
        File folder = Website_Generator.folderCreator(sourceDirectoryinTestFolder, subFolderName, subFolderName2);

        boolean result = folder.mkdirs();

        Assertions.assertTrue(result);


    }
    void testFolderCreator_FunctionOverload3() {


        String subFolderName3 = "TestSubFolder3";
        File folder = Website_Generator.folderCreator(sourceDirectoryinTestFolder, subFolderName, subFolderName3);

        boolean result = folder.mkdirs();

        Assertions.assertTrue(result);


    }

    void testFolderCreator_FunctionOverload4() {


        String subFolderName4 = "TestSubFolder4";
        File folder = Website_Generator.folderCreator(sourceDirectoryinTestFolder, subFolderName, subFolderName4);

        boolean result = folder.mkdirs();

        Assertions.assertTrue(result);


    }

    @Test
    void htmlMaker() {

        ArrayList<String> websiteData = new ArrayList<>();
        websiteData.add("Name:TestHTML");
        websiteData.add("AuthorName: Sahara");

       htmlFile = Website_Generator.htmlMaker(htmlFile, websiteData, "src/test/java/oop/assignment3/ex43/base" + "//index.html");

        boolean result = ( htmlFile!=null );
        Assertions.assertTrue(result);




    }
}