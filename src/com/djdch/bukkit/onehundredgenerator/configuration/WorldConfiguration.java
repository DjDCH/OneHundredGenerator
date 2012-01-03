package com.djdch.bukkit.onehundredgenerator.configuration;

import com.djdch.bukkit.onehundredgenerator.OneHundredGenerator;
import com.djdch.bukkit.onehundredgenerator.generator.ChunkProviderGenerate;

/**
 * 
 * @author djdch
 * 
 */
public class WorldConfiguration {
    /**
	 *
	 */
    protected OneHundredGenerator plugin;

    /**
	 *
	 */
    protected ChunkProviderGenerate chunkProvider;

    /**
	 *
	 */
    protected boolean init = false;

    /**
	 * 
	 */
    protected boolean levelStructures = false;

    /**
     * 
     * @param plug
     */
    public WorldConfiguration(OneHundredGenerator plug) {
        this.plugin = plug;
    }

    /**
     * 
     * @return the plugin
     */
    public OneHundredGenerator getPlugin() {
        return plugin;
    }

    /**
     * 
     * @return the chunkProvider
     */
    public ChunkProviderGenerate getChunkProvider() {
        return chunkProvider;
    }

    /**
     * 
     * @param chunkProvider
     */
    public void setChunkProvider(ChunkProviderGenerate chunkProvider) {
        this.chunkProvider = chunkProvider;
    }

    /**
     * 
     * @return the isInit
     */
    public boolean isInit() {
        return init;
    }

    /**
     * 
     * @param isInit
     */
    public void setInit(boolean init) {
        this.init = init;
    }

    /**
     * 
     * @return the levelStructures
     */
    public boolean getLevelStructures() {
        return levelStructures;
    }

    /**
     * 
     * @param levelStructures
     */
    public void setLevelStructures(boolean levelStructures) {
        this.levelStructures = levelStructures;
    }
}
