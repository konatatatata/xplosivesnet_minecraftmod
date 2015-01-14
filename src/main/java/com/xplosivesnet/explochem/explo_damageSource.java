package com.xplosivesnet.explochem;

import net.minecraft.util.DamageSource;

public class explo_damageSource extends DamageSource
{
	public static DamageSource poison = new DamageSource("poison");
	public static DamageSource poison_heavy = new DamageSource("poison_heavy");
	public static DamageSource acid = new DamageSource("acid");
	public static DamageSource acid_heavy = new DamageSource("acid_heavy");
	
	
	public explo_damageSource(String name)
	{
		super(name);
		this.damageType = name;
	}

}
