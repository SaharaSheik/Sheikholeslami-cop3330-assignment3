package oop.assignment3.ex44.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Product_SearchTest {

    File input = new File("src/test/java/oop/assignment3/ex44/base/Test_ex44.inPut.Json");
    List<Products> products = Product_Search.productArrayMaker(input);


    String productSearchKey;



    @Test
    void productArrayMaker() {

        // expecting the second element (index 1) name to be: "Shirt", "quantity": 35
        // checking to see if the data was successfully parsed using json file and stored into product array

        //expected values;
        String expectedName = "Shirt";
        Double expectedPrice = 90.0;
        Integer expectedQuantity = 35;



        String actualName = products.get(1).name.toString();
        Integer actualQuantity = products.get(1).quantity;


        boolean result = (actualName.equals(expectedName) && expectedQuantity == actualQuantity);


        Assertions.assertTrue(result);






    }

    @Test
    void productFinder_true() {

        // expecting to get true if I enter a product that is in the list

        productSearchKey = "Shirt";

        boolean actual = Product_Search.productFinder(products, productSearchKey);

        Assertions.assertTrue(actual);

    }

    @Test
    void productFinder_false() {

        // expecting to get false if I enter a product that is in not list

        productSearchKey = "Spoon";

        boolean actual = Product_Search.productFinder(products, productSearchKey);

        Assertions.assertFalse(actual);

    }
}