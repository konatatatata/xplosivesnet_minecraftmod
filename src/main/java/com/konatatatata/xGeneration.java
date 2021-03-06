package com.konatatatata;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class xGeneration implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		/* runs 'generateNether' or 'generateSurface' depending on which dimension you're loading */
		switch(world.provider.dimensionId)
		{
			case -1: generateNether(world, random, chunkX*16, chunkZ*16);
			break;
			case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
			break;
		}
	}
	
	public void generateSurface(World world, Random random, int x, int z)
	{
		for(int i = 0; i < xOres.getBlocks().length; i++)
		{
			this.addOreSpawn(xOres.getBlocks()[i], world, random, x, z, 16, 16, xOres.getSizeById(i), xOres.getSpawnrateById(i), 0, 256);	
		}
	}
	
	public void generateNether(World world, Random random, int x, int z)
	{
	}
	
	public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY )
	{
		for(int i = 0; i < chancesToSpawn; i++)
		{
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY -minY);
			int posZ = blockZPos + random.nextInt(maxZ);
			new WorldGenMinable(block, maxVeinSize).generate(world, random, posX, posY, posZ);
		}
	}
}