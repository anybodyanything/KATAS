package main.katas;


import java.util.*;

public class CakeBaker {
    /*
    Pete likes to bake some cakes. He has some recipes and ingredients. Unfortunately he is not good in maths.
    Can you help him to find out, how many cakes he could bake considering his recipes?
    Write a function cakes(), which takes the recipe (object) and the available ingredients (also an object)
    and returns the maximum number of cakes Pete can bake (integer).
    For simplicity there are no units for the amounts (e.g. 1 lb of flour or 200 g of sugar are simply 1 or 200).
    Ingredients that are not present in the objects, can be considered as 0.

    Examples:
    // must return 2
    cakes({flour: 500, sugar: 200, eggs: 1}, {flour: 1200, sugar: 1200, eggs: 5, milk: 200});
    // must return 0
    cakes({apples: 3, flour: 300, sugar: 150, milk: 100, oil: 100}, {sugar: 500, flour: 2000, milk: 2000});
     */

    //submitted
    public int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
        int cakes = Integer.MAX_VALUE;

        if (recipe.size() <= available.size()) {
            for (String recipeKey : recipe.keySet()) {
                if (available.containsKey(recipeKey)) {

                    int neededAmount = recipe.get(recipeKey);
                    int availableAmount = available.get(recipeKey);
                    int possibleCakes = availableAmount / neededAmount;

                    cakes = Math.min(cakes, possibleCakes);
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }
        return cakes;
    }


    //better solutions

    //Way shorter solution, only 2 returns
    public int cakesShort(Map<String, Integer> requirements, Map<String, Integer> availableResources) {
        int maxSets = Integer.MAX_VALUE;
        for (String key: requirements.keySet()) {
            if (!availableResources.containsKey(key)) return 0;

            maxSets = Integer.min(maxSets, availableResources.get(key) / requirements.get(key));
        }

        return maxSets;
    }

    //Using streams
    public int streamCakes(Map<String, Integer> recipe, Map<String, Integer> available) {
        return recipe.entrySet().stream().mapToInt(e -> available.getOrDefault(e.getKey(), 0) / e.getValue()).min().orElse(0);
    }
}
