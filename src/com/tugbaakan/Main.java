package com.tugbaakan;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static Category[] defineCategories() {

        // Definition of categories.
        // Keywords are the one that help us to find what is the main ingredient.
        // Ignore words are the ones that misdirect us from the main ingredient. e.g. chicken stock.
        // Beef
        String[] kws_1 = {"lamb", " lamb ", " lamb\n", "steak", "beef"};
        String[] igs_1 = {"stock"};
        Category cate1 = new Category(1, "Beef", kws_1, igs_1);

        // Chicken
        String[] kws_2 = {"chicken"};
        String[] igs_2 = {"stock"};
        Category cate2 = new Category(2, "Chicken", kws_2, igs_2);

        // Vegetable
        String[] kws_3 = {"parsnip", "parsnips", "beetroot", "broccoli", "cauliflower"
                , "courgette", "courgettes", "cucumber", "lettuce", "spinach", "runner beans"};
        String[] igs_3 = {"stock"};
        Category cate3 = new Category(3, "Vegetables", kws_3, igs_3);
        Category[] categories = {cate1, cate2, cate3};
        return categories;
    }

    public static void main(String[] args) {

        // Developer: Tugba Akan
        // Recipe Journal: A journal keeping your recipes in categories by the ingredients
        // letting you enter a new recipe
        // listing the recipes of the desired category

        // The recipes are taken from the website https://www.jamieoliver.com/

        // Version 1 : The categories are: Beef, Chicken, Vegetables
        // if you would like to add a new recipe, put the text document into the folder
        // that the code runs and run the code. It will load all the text documents
        // including the new one. You can run the jupyter notebook
        // or the py file from the command line

        // Define the categories in the journal
        Category[] categories = defineCategories();

        //Create a Journal object and import txt files as recipes
        Journal recipeJournal = new Journal(categories);

        boolean quit = false;
        int inp_cate_ID = 0;
        while (!quit) {
            System.out.println("Type the number of the category you wish to be listed");
            for (Category item : categories) {
                System.out.println(item.getID() + " for " + item.getName());
            }
            System.out.println("Enter 4 to exit");
            try{
                inp_cate_ID = scanner.nextInt();
                if (inp_cate_ID == 4) {
                    quit = true;
                } else {
                    recipeJournal.listRecipes(inp_cate_ID);
                }
            } catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("Please only enter the number written below:");
            }


        }
    }
}
