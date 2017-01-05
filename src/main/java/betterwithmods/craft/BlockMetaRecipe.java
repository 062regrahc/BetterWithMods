package betterwithmods.craft;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 11/11/16
 */
public class BlockMetaRecipe {
    private final Block block;
    private final int meta;
    private final List<ItemStack> outputs;

    public BlockMetaRecipe(Block block, int meta, List<ItemStack> outputs) {
        this.block = block;
        this.meta = meta;
        this.outputs = outputs;
    }

    public boolean equals(Block block, int meta) {
        return this.block == block && this.meta == meta;
    }

    public List<ItemStack> getOutputs() {
        return outputs;
    }

    public ItemStack getInput() {
        return new ItemStack(block, 1, meta);
    }


}