package com.tugbaakan;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Journal {

    // Import txt files and create a list of the objects of the Recipe class.
    private List<Recipe> recipes;
    private Category[] categories;

    public Journal(Category[] categories) {
        this.categories = categories;
        this.recipes = importRecipes();
    }

    public List<Recipe> importRecipes(){
        // Import txt files and create a list of the objects of the Recipe class.
        List<Recipe> recipes = new ArrayList<Recipe>();
        // We assume that there are at most 20 recipes.
        for (int i = 1; i <= 20; i++) {
            Path wiki_path = Paths.get("C:\\Users\\tugbaa\\Documents\\GitHub\\recipe_journal_golang", "recipe" + i + ".txt");
            Charset charset = Charset.forName("ISO-8859-1");
            try {
                /* Read each line of the file into a string array. Each element
                  of the array is one line of the file. */
                String[] new_recipe = Files.readAllLines(wiki_path, charset).toArray(new String[0]);
                int ing_index = 0;
                for (int j = 0; j < new_recipe.length; j++) {
                    //String line : new_recipe
                    // take the below line of 'Ingredients' for ingredient list
                    // find the index and assign it to ing_index
                    if (new_recipe[j].equals("Ingredients")) {
                        ing_index = j;
                        break;
                    }
                }
                Recipe rec = new Recipe(new_recipe[0], Arrays.copyOfRange(new_recipe, ing_index, new_recipe.length), this.categories);
                recipes.add(rec);
                System.out.println("recipe imported");
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return recipes;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    // method listing the recipes in the desired category
    public void listRecipes(int inp_cate_ID) {
        for (Category item : this.categories) {
            if (item.getID() == inp_cate_ID) {
                System.out.println(item.getName());
                for (Recipe item2 : this.recipes) {
                    for (Category item3 : item2.getCategory()) {
                        if (item3 == item) {
                            System.out.println(item2.getName());
                        }
                    }
                }
            }
        }
    }


}
