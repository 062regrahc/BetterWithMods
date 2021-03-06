package betterwithmods.craft;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.Random;

/**
 * Created by blueyu2 on 12/12/16.
 */
public class CuttingRecipe extends ShapelessOreRecipe {
    private final ItemStack input;

    public CuttingRecipe(ItemStack result, ItemStack input) {
        super(result, new ItemStack(Items.SHEARS, 1, OreDictionary.WILDCARD_VALUE), input);
        this.input = input;
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        boolean hasShears = false;
        boolean hasInput = false;

        for (int x = 0; x < inv.getSizeInventory(); x++)
        {
            boolean inRecipe = false;
            ItemStack slot = inv.getStackInSlot(x);

            if (slot != null) {
                if (isShears(slot)) {
                    if(!hasShears) {
                        hasShears = true;
                        inRecipe = true;
                    }
                    else
                        return false;
                }
                else if (OreDictionary.itemMatches(slot, input, true)) {
                    if(!hasInput) {
                        hasInput = true;
                        inRecipe = true;
                    }
                    else
                        return false;
                }
                if(!inRecipe)
                    return false;
            }
        }
        return hasShears && hasInput;
    }

    private boolean isShears(ItemStack stack) {
        if (stack != null) {
            if (stack.getItem() instanceof ItemShears)
                return true;
        }
        return false;
    }

    @Override
    public ItemStack[] getRemainingItems(InventoryCrafting inv) {
        ItemStack[] ret = new ItemStack[inv.getSizeInventory()];
        for (int i = 0; i < ret.length; i++)
        {
            ItemStack stack = inv.getStackInSlot(i);
            if(stack != null && isShears(stack)) {
                ItemStack copy = stack.copy();
                if (!copy.attemptDamageItem(1, new Random())) {
                    ret[i] = copy;
                }
            }
        }
        return ret;
    }
}
