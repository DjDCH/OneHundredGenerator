package com.djdch.bukkit.onehundredgenerator.generator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

/**
 * 
 * @author djdch
 * 
 */
public class ObjectSpawner extends BlockPopulator {
    /**
     * 
     */
    protected ChunkProviderGenerate chunkProvider;

    /**
     * 
     * @param chunkProvider
     */
    public ObjectSpawner(ChunkProviderGenerate chunkProvider) {
        this.chunkProvider = chunkProvider;
    }

    /**
     * 
     * @param world
     * @param random
     * @param chuck
     */
    public void populate(World world, Random random, Chunk chunk) {
        this.chunkProvider.getChunkAt(this.chunkProvider, chunk.getX(), chunk.getZ());
    }
}
