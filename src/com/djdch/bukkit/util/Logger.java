package com.djdch.bukkit.util;

/**
 * Class who wrap the Minecraft Logger instance.
 * <p>
 * The purpose of this wrapper is to prefix each log message with the plugin name.
 * 
 * @author DjDCH
 */
public class Logger {
    /**
     * Contains the Minecraft Logger instance.
     */
    protected java.util.logging.Logger logger;

    /**
     * Contains the plugin name string.
     */
    protected String name;

    /**
     * Contains the prefix who will be added to each log message.
     */
    protected String prefix;

    /**
     * Contains the part of the prefix add before the plugin name.
     */
    public static final String PREFIX_PREFIX = "[";

    /**
     * Contains the part of the prefix add after the plugin name.
     */
    public static final String PREFIX_SUFFIX = "] ";

    /**
     * Contains the name of the Minecraft Logger instance.
     */
    public static final String MINECRAFT_LOGGER = "Minecraft";

    /**
     * Constructor for the initialization of the Logger.
     * 
     * @param msg Contains the log message.
     */
    public Logger(String name) {
        this.logger = java.util.logging.Logger.getLogger(MINECRAFT_LOGGER);
        this.setName(name);
    }

    /**
     * Constructor for the initialization of the Logger.
     */
    public Logger() {
        this("");
    }

    /**
     * Method who log a config message prefix with the plugin name.
     * 
     * @param msg Contains the log message.
     */
    public void config(String msg) {
        logger.config(getPrefix() + msg);
    }

    /**
     * Method who log a fine message prefix with the plugin name.
     * 
     * @param msg Contains the log message.
     */
    public void fine(String msg) {
        logger.fine(getPrefix() + msg);
    }

    /**
     * Method who log a finer message prefix with the plugin name.
     * 
     * @param msg Contains the log message.
     */
    public void finer(String msg) {
        logger.finer(getPrefix() + msg);
    }

    /**
     * Method who log a finest message prefix with the plugin name.
     * 
     * @param msg Contains the log message.
     */
    public void finest(String msg) {
        logger.finest(getPrefix() + msg);
    }

    /**
     * Method who log a info message prefix with the plugin name.
     * 
     * @param msg Contains the log message.
     */
    public void info(String msg) {
        logger.info(getPrefix() + msg);
    }

    /**
     * Method who log a severe message prefix with the plugin name.
     * 
     * @param msg Contains the log message.
     */
    public void severe(String msg) {
        logger.severe(getPrefix() + msg);
    }

    /**
     * Method who log a warning message prefix with the plugin name.
     * 
     * @param msg Contains the log message.
     */
    public void warning(String msg) {
        logger.warning(getPrefix() + msg);
    }

    /**
     * Accessor who return the plugin name.
     * 
     * @return Contains the plugin name string.
     */
    public String getName() {
        return name;
    }

    /**
     * Mutator who set the plugin name.
     * 
     * @param name Contains the plugin name string.
     */
    public void setName(String name) {
        this.name = name;
        this.generatePrefix();
    }

    /**
     * Method who generate the formated prefix with the plugin name.
     */
    public void generatePrefix() {
        this.prefix = PREFIX_PREFIX + this.name + PREFIX_SUFFIX;
    }

    /**
     * Accessor who return the current used prefix.
     * 
     * @return Contains the prefix string.
     */
    public String getPrefix() {
        return prefix;
    }
}
