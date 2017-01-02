package betterwithmods.base.util;

import net.minecraft.block.Block;

import java.util.ArrayList;

public class NetherSpawnWhitelist {
    private static final ArrayList<String> whitelist = new ArrayList<>();

    public static void addBlock(Block block) {
        for (int i = 0; i < 16; i++)
            whitelist.add(block + ":" + i);
    }

    public static void addBlock(Block block, int meta) {
        whitelist.add(block + ":" + meta);
    }

    public static boolean contains(Block block, int meta) {
        return whitelist.contains(block + ":" + meta);
    }

    public static void remove(Block block, int meta) {
        if (whitelist.contains(block + ":" + meta))
            whitelist.remove(block + ":" + meta);
    }
}
