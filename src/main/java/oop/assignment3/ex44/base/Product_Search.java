package oop.assignment3.ex44.base;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Sahar Sheikholelsami
 */
/*Exercise 44 - Product Search
Pulling data from a file into a complex data structure makes parsing much simpler.
Many programming languages support the JSON format, a popular way of representing data.

Create a program that takes a product name as input and retrieves the current price and quantity for that product. The product data is in a data file in the JSON format  and looks like this (you will create this file as `exercise44_input.json`):

{
    "products" : [
        {"name": "Widget", "price": 25.00, "quantity": 5 },
        {"name": "Thing", "price": 15.00, "quantity": 5 },
        {"name": "Doodad", "price": 5.00, "quantity": 10 }
    ]
}
Print out the product name, price, and quantity if the product is found.
If no product matches the search, state that no product was found and start over.

Example Output
What is the product name? iPad
Sorry, that product was not found in our inventory.
What is the product name? Galaxy
Sorry, that product was not found in our inventory.
What is the product name? Thing
Name: Thing
Price: 15.00
Quantity: 5
Constraints
The file is in the JSON format. Use a JSON parser to pull the values out of the file (e.g. https://github.com/google/gson (Links to an external site.)).
If no record is found, prompt again.
Challenges
Ensure that the product search is case insensitive.
When a product is not found, ask if the product should be added. If yes, ask for the price and the quantity, and save it in the JSON file. Ensure the newly added product is immediately available for searching without restarting the program.


 */


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Product_Search {

    public static final Scanner output = new Scanner(System.in);

    //we have json -> first download & dependency
    // download Maven library com.google.code.gson  //
    // <dependency>
    //  <groupId>com.google.code.gson</groupId>
    //  <artifactId>gson</artifactId>
    //  <version>2.8.7</version>
    //</dependency>

    //create json file
    // products are objects with name String, price Double, Quantity Int -> Create a products object
    //set up getters and setters

    // create Json Parser to parse the data from json file
    // store data from json file into a jason object array
    // load data from jason object to an array of product object

    //prompt for product name search key
    //iterate the product object array, in the .name section to see if product is found
    // if found return a boolean value, increase your flag so you can break the loop
    // if not found continue with loop

    // send result of the search to printer function so it can either print the product info or the error massage
    // if boolean == true, print product inf using .name, .price,...




    public static void main(String[] args) {

        File input = new File("src/main/java/oop/assignment3/ex44/base/exercise44_input.json");

        List<Products> products = productArrayMaker(input);

        String productSearchKey;
        boolean productExists;

        int flag = 0;

        while (flag == 0) {

            productSearchKey = getProductName();

            productExists = productFinder(products, productSearchKey);

            if (productExists)  // handling the loop to break when the product is found
                flag++;

            printProductInfo(products, productSearchKey, productExists);


        }


    }

    public static List<Products> productArrayMaker(File input) {

        List<Products> products = new ArrayList<>();  // will store our product objects


        try {
            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));  // Parse data from the file

            JsonObject fileObject = fileElement.getAsJsonObject();  // convert the parsed data to Jason Objets


            // price all products

            JsonArray jasonArrayOfProducts = fileObject.get("products").getAsJsonArray(); // convert to Jason Array


            for (JsonElement productElement : jasonArrayOfProducts) {
                // make  Json object
                JsonObject productObject = productElement.getAsJsonObject();
                String name = productObject.get("name").getAsString();
                Double price = productObject.get("price").getAsDouble();
                Integer quantity = productObject.get("quantity").getAsInt();

                Products product = new Products(name, price, quantity);  // load the data from Json object to product object

                products.add(product);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return products;

    }

    public static String getProductName() {
        // get product name from user
        String choice;

        System.out.print("What is the product name? ");
        choice = output.nextLine();


        return choice;
    }

    public static boolean productFinder(List<Products> products, String searchKey) {

        // see if the product name exists in the our product Object Array

        for (int i = 0; i < products.size(); i++) {

            if (products.get(i).name.equals(searchKey))
                return true;
        }

        return false;
    }

    public static void printProductInfo(List<Products> products, String searchKey, boolean productExists) {


        // print results based on if products exists or not

        if (productExists) {

            for (int i = 0; i < products.size(); i++) {

                if (products.get(i).name.equals(searchKey)) {
                    System.out.printf("Name: %s\n" +
                            "Price: %.2f\n" +
                            "Quantity: %d", products.get(i).name, products.get(i).price, products.get(i).quantity);
                    break;
                }

            }
        } else
            System.out.print("Sorry, that product was not found in our inventory.\n");
    }

}