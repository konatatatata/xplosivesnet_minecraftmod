package com.konatatatata;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class xAchievements
{	
	public static AchievementPage realisticExplosivesAchievements;	
	public static LinkedList<Achievement> achievementList = new LinkedList<Achievement>();
	public static LinkedList<String> achievementListNames = new LinkedList<String>();
	
	
	public static void loadAchivements()
	{
		addAchievement("craftBottle", xItems.getItemByName("bottle"), 0, 0, null);
		addAchievement("craftAN", xItems.getItemByName("ammoniumNitrate"), 0, 2, xAchievements.getByName("craftBottle"));
		addAchievement("craftAMMONAL", xItems.getItemByName("AMMONAL"), 0, 3, xAchievements.getByName("craftAN"));
		addAchievement("craftINI", xItems.getItemByName("HMTD"), 2, 3, xAchievements.getByName("craftAN"));
		
		realisticExplosivesAchievements = new AchievementPage("RE", achievementList.toArray(new Achievement[achievementList.size()]));
		AchievementPage.registerAchievementPage(realisticExplosivesAchievements);
	}
	
	private static void addAchievement(String name, Item icon, int x, int y, Achievement parent)
	{
		achievementList.add(new Achievement(name, name, x, y, icon, parent).registerStat());		
		achievementListNames.add(name);
	}
	
	public static Achievement getByName(String name)
	{
		int c = 0;
		for(Achievement ac : achievementList)
		{
			if(achievementListNames.get(c).equals(name))
			{
				return ac;
			}
		}
		
		return null;
	}
	
}
