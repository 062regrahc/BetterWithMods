package betterwithmods.integration.minetweaker;

import betterwithmods.craft.BlockMetaHandler;
import betterwithmods.craft.BlockMetaRecipe;
import com.blamejared.mtlib.utils.BaseListAddition;
import com.google.common.collect.Lists;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class BMAdd extends BaseListAddition<BlockMetaRecipe> {

    public BMAdd(String name, BlockMetaHandler recipes, BlockMetaRecipe recipe) {
        super(name, recipes.getRecipes(), Lists.newArrayList(recipe));
    }

    @Override
    protected String getRecipeInfo(BlockMetaRecipe recipe) {
        return recipe.getInput().getDisplayName();
    }
}