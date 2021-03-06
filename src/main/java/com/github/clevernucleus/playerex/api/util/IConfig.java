package com.github.clevernucleus.playerex.api.util;

import java.util.function.Supplier;

/**
 * The primary access point to the mod's config options.
 * 
 * @author CleverNucleus
 *
 */
public interface IConfig {
	
	/**
	 * @return The number of experience levels the player needs to gain a PlayerEx level initially (when their PlayerEx level is 0).
	 */
	int levelOffset();
	
	/** 
	 * @return A multiplier that 'squeezes' or 'stretches' the level requirements curve; smaller values squeeze and larger values stretch.
	 */
	float levelMultiplier();
	
	/**
	 * @return Whether to reset all attributes to their defaults on respawn.
	 */
	boolean resetOnDeath();
	
	/**
	 * @return Whether to play the level up effects (sound + particles).
	 */
	boolean playLevelUpSound();
	
	/**
	 * @return The level up sound volume. 
	 */
	float levelUpVolume();
	
	/**
	 * @return Whether an additional name plate is displayed on multiplier just below the player's name, showing the player's level.
	 */
	boolean showLevelNameplates();
	
	/**
	 * @return Whether to play the sound on spending a skill point. Client Sided.
	 */
	boolean playSkillUpSound();
	
	/**
	 * @return The skill up sound volume. Client Sided.
	 */
	float skillUpVolume();
	
	/**
	 * @return The x-position of the gui inventory button. Client Sided.
	 */
	int guiButtonPosX();
	
	/**
	 * @return The y-position of the gui inventory button. Client Sided.
	 */
	int guiButtonPosY();
	
	/**
	 * The supplier of our config.
	 * 
	 * @author CleverNucleus
	 *
	 */
	@FunctionalInterface
	interface Provider extends Supplier<IConfig> {}
}
