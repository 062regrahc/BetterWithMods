package betterwithmods.base.client.gui;

import betterwithmods.base.BWMod;
import betterwithmods.base.modules.config.BWConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyler on 9/14/16.
 */
public class BWGuiConfig extends GuiConfig {
    public BWGuiConfig(GuiScreen parentScreen) {
        super(parentScreen,
                getConfigElements(), BWMod.MODID, false, false, GuiConfig.getAbridgedConfigPath(BWConfig.config.toString()));
    }

    /**
     * Compiles a list of config elements
     */
    private static List<IConfigElement> getConfigElements() {
        List<IConfigElement> list = new ArrayList<>();

        //Add categories to config GUI
        list.add(categoryElement(BWConfig.HARDCORE, "Hardcore", "bwm.config.hardcore"));
        list.add(categoryElement(BWConfig.DEBUG, "Debug", "bwm.config.debug"));
        list.add(categoryElement(BWConfig.VANILLA_TWEAKS, "Vanilla Tweaks", "bwm.config.vanilla_tweaks"));
        list.add(categoryElement(BWConfig.PULLEY, "Pulley", "bwm.config.pulley"));
        list.add(categoryElement(BWConfig.MOD_COMPAT, "Mod Compat", "bwm.config.mod_compat"));

        return list;
    }

    /**
     * Creates a button linking to another screen where all options of the category are available
     */
    private static IConfigElement categoryElement(String category, String name, String tooltip_key) {
        return new DummyConfigElement.DummyCategoryElement(name, tooltip_key,
                new ConfigElement(BWConfig.config.getCategory(category)).getChildElements());
    }
}
