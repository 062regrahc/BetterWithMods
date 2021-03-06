package betterwithmods.damagesource;

import net.minecraft.util.DamageSource;

public class BWDamageSource extends DamageSource {
    public static final BWDamageSource saw = new BWDamageSource("saw", false);
    public static final BWDamageSource choppingBlock = new BWDamageSource("choppingBlock", false);

    protected BWDamageSource(String name, boolean ignoreArmor) {
        super(name);
        if (ignoreArmor)
            setDamageBypassesArmor();
    }
}
