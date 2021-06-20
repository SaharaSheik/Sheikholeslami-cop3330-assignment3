package oop.assignment3.Tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class File_Reader {



    public static ArrayList<String> fileReader(BufferedReader inputFile, String fileName) {

        ArrayList<String> fileLines = new ArrayList<>();

        try {
            inputFile = new BufferedReader(new FileReader(fileName));

            String eachLines = inputFile.readLine();

            while (eachLines != null)
            {
                fileLines.add(eachLines);

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
