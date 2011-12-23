package com.djdch.bukkit.utils;

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
	 * Contains the prefix who will be added to each log message.
	 */
	protected String prefix;

	/**
	 * Contains the name of the Minecraft Logger instance.
	 */
	public static final String MINECRAFT_LOGGER = "Minecraft";

	/**
	 * Constructor for the initialization of the Logger.
	 *
	 * @param prefix Contains the plugin name.
	 */
	public Logger(String prefix) {
		this.logger = java.util.logging.Logger.getLogger(MINECRAFT_LOGGER);
		this.prefix = prefix;
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
		logger.config(getFormatedPrefix() + msg);
	}

	/**
	 * Method who log a fine message prefix with the plugin name.
	 *
	 * @param msg Contains the log message.
	 */
	public void fine(String msg) {
		logger.fine(getFormatedPrefix() + msg);
	}

	/**
	 * Method who log a finer message prefix with the plugin name.
	 *
	 * @param msg Contains the log message.
	 */
	public void finer(String msg) {
		logger.finer(getFormatedPrefix() + msg);
	}

	/**
	 * Method who log a finest message prefix with the plugin name.
	 *
	 * @param msg Contains the log message.
	 */
	public void finest(String msg) {
		logger.finest(getFormatedPrefix() + msg);
	}

	/**
	 * Method who log a info message prefix with the plugin name.
	 *
	 * @param msg Contains the log message.
	 */
	public void info(String msg) {
		logger.info(getFormatedPrefix() + msg);
	}

	/**
	 * Method who log a severe message prefix with the plugin name.
	 *
	 * @param msg Contains the log message.
	 */
	public void severe(String msg) {
		logger.severe(getFormatedPrefix() + msg);
	}

	/**
	 * Method who log a warning message prefix with the plugin name.
	 *
	 * @param msg Contains the log message.
	 */
	public void warning(String msg) {
		logger.warning(getFormatedPrefix() + msg);
	}

	/**
	 * Accessor who return the current used prefix.
	 *
	 * @return Contains the prefix string.
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * Accessor who return the formated version of the current used prefix.
	 */
	public String getFormatedPrefix() {
		return "["+prefix+"] ";
	}

	/**
	 * Mutator who set the used prefix.
	 *
	 * @param prefix Contains the prefix string.
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
