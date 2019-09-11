package com.tugbaakan;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private String name;
    private String[] ingredients;
    private List<Category> category;

    public Recipe(String name, String[] ingredients, Category[] categories) {
        this.name = name;
        this.ingredients = ingredients;
        this.setCategory(categories);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(Category[] categories) {
        //this.category = categories;
        this.category = new ArrayList<Category>();
        // loop for all categories
        for (Category cate : categories)
        {
            // loop for all ingredients
            outerloop:
            for (String ingr : this.ingredients)
            {
                // loop for all the words to be ignored
                for (String kw0 : cate.getIgnoreWords())
                {
                    if (ingr.contains(kw0) == false)
                    {
                        //loop for all keywords
                        for (String kw : cate.getKeywords())
                        {
                            if (ingr.contains(kw))
                            {
                                //System.out.println(kw);
                                //System.out.println(ingr);
                                //System.out.println(this.getName());
                                //System.out.println(cate.getName());
                                this.category.add(cate);
                                break outerloop;
                            }
                        }
                    }
                }
            }
        }
    }


}


