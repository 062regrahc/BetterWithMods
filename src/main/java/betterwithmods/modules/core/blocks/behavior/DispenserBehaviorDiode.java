package betterwithmods.modules.core.blocks.behavior;

import betterwithmods.base.util.DirUtils;
import betterwithmods.modules.core.blocks.BlockBDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.item.ItemBlockSpecial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.FakePlayerFactory;

public class DispenserBehaviorDiode extends BehaviorDefaultDispenseItem {
    @Override
    protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
        EnumFacing facing = source.getBlockState().getValue(BlockBDispenser.FACING);
        IPosition pos = BlockBDispenser.getDispensePosition(source);
        BlockPos check = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        ItemStack stack1 = stack.splitStack(1);
        if (facing != EnumFacing.DOWN && facing != EnumFacing.UP && stack.getItem() instanceof ItemBlockSpecial) {
            FakePlayer fake = FakePlayerFactory.getMinecraft((WorldServer) source.getWorld());
            DirUtils.setEntityOrientationFacing(fake, facing);
            if (stack.getItem().onItemUse(stack1, fake, source.getWorld(), check, EnumHand.MAIN_HAND, facing, 0.1F, 0.0F, 0.1F) == EnumActionResult.SUCCESS) {
                return stack;
            } else {
                stack.stackSize += 1;
                return stack;
            }
        } else {
            stack.stackSize += 1;
            return stack;
        }
    }
}
