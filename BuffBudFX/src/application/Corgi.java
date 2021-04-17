package application;

/**
 * Class to represent a Corgi, which is a type of Pet.
 * 
 * UPDATED:	16 APR 2021
 */

import java.util.*;
import javafx.scene.image.Image;

public class Corgi extends Pet {
	// Sprite lists for animation
	LinkedList<Image> idleAnimList = new LinkedList<Image>();
	LinkedList<Image> walkAnimList = new LinkedList<Image>();
	LinkedList<Image> celebAnimList = new LinkedList<Image>();
	LinkedList<Image> sadAnimList = new LinkedList<Image>();
	LinkedList<Image> deathAnimList = new LinkedList<Image>();
	LinkedList<Image> ghostAnimList = new LinkedList<Image>();

	/**
	 * Creates a Corgi by name and sets up its animation lists
	 * 
	 * @param petName
	 */
	public Corgi(String petName) {
		super(petName);
		this.initIdleAnimList();
		this.initWalkAnimList();
		this.initCelebAnimList();
		this.initSadAnimList();
		this.initDeathAnimList();
		this.initGhostAnimList();
	}

	/**
	 * Creates a Corgi with chosen parameters and initializes animation lists
	 * 
	 * @param petName
	 * @param healthLevel
	 * @param timeOfLastExcersize
	 * @param isSleeping
	 */
	public Corgi(String petName, int healthLevel, long timeOfLastExcersize, boolean isSleeping) {
		super(petName, healthLevel, timeOfLastExcersize, isSleeping);
		this.initIdleAnimList();
		this.initWalkAnimList();
		this.initCelebAnimList();
		this.initSadAnimList();
		this.initDeathAnimList();
		this.initGhostAnimList();
	}

	/**
	 * Retrieves species/breed of pet
	 * 
	 * @return Corgi - the type of pet this is
	 */
	public String getPetType() {
		return "Corgi";
	}

	/**
	 * Retrieves the animations for idling
	 * 
	 * @return list of animations for idling
	 */
	public List<Image> getIdleAnimList() {
		return this.idleAnimList;
	}

	/**
	 * Retrieves the animations for walking
	 * 
	 * @return list of animations for walking
	 */
	public List<Image> getWalkAnimList() {
		return this.walkAnimList;
	}

	/**
	 * Retrieves the animations for celebrating
	 * 
	 * @return list of animations for celebrating
	 */
	public List<Image> getCelebAnimList() {
		return this.celebAnimList;
	}

	/**
	 * Retrieves the animations for reacting sadly
	 * 
	 * @return list of animations for reacting sadly
	 */
	public List<Image> getSadAnimList() {
		return this.sadAnimList;
	}

	/**
	 * Retrieves the animations for transition from real to "sleeping"
	 * 
	 * @return list of animations for transition from real to "sleeping"
	 */
	public List<Image> getDeathAnimList() {
		return this.deathAnimList;
	}

	/**
	 * Retrieves the animations for the "sleeping" state
	 * 
	 * @return list of animations for the "sleeping" state
	 */
	public List<Image> getGhostAnimList() {
		return this.ghostAnimList;
	}

	/**
	 * Initializes the animation list for idling
	 */
	public void initIdleAnimList() {
		for (int i = 0; i < 2; ++i) {
			this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiIdle0.png", 180, 132, true, false));
			this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiIdle1.png", 180, 132, true, false));
			this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiIdle2.png", 180, 132, true, false));
			this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiIdle3.png", 180, 132, true, false));
			this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiIdle4.png", 180, 132, true, false));
			this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiIdle0.png", 180, 132, true, false));
			this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiIdle5.png", 180, 132, true, false));
			this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiIdle6.png", 180, 132, true, false));
			this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiIdle7.png", 180, 132, true, false));
		}

		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiIdle0.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit0.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit1.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit2.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit3.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit4.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit5.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit6.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit7.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit6.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit5.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit4.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit3.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit2.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit3.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit4.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit5.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit6.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit7.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit6.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit5.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit4.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit3.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit2.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit1.png", 180, 132, true, false));
		this.idleAnimList.add(new Image("file:resources/Images/Corgi/corgiSit0.png", 180, 132, true, false));
	}

	/**
	 * Initializes the animation list for walking
	 */
	public void initWalkAnimList() {
		this.walkAnimList.add(new Image("file:resources/Images/Corgi/corgiWalk0.png", 180, 132, true, false));
		this.walkAnimList.add(new Image("file:resources/Images/Corgi/corgiWalk1.png", 180, 132, true, false));
		this.walkAnimList.add(new Image("file:resources/Images/Corgi/corgiWalk2.png", 180, 132, true, false));
		this.walkAnimList.add(new Image("file:resources/Images/Corgi/corgiWalk3.png", 180, 132, true, false));
	}

	/**
	 * Initializes the animation list for celebrating
	 */
	public void initCelebAnimList() {
		this.celebAnimList.add(new Image("file:resources/Images/Corgi/corgiJump0.png", 180, 132, true, false));
		this.celebAnimList.add(new Image("file:resources/Images/Corgi/corgiJump1.png", 180, 132, true, false));
		this.celebAnimList.add(new Image("file:resources/Images/Corgi/corgiJump2.png", 180, 132, true, false));
		this.celebAnimList.add(new Image("file:resources/Images/Corgi/corgiJump3.png", 180, 132, true, false));
		this.celebAnimList.add(new Image("file:resources/Images/Corgi/corgiJump4.png", 180, 132, true, false));
		this.celebAnimList.add(new Image("file:resources/Images/Corgi/corgiJump5.png", 180, 132, true, false));
		this.celebAnimList.add(new Image("file:resources/Images/Corgi/corgiJump6.png", 180, 132, true, false));
		this.celebAnimList.add(new Image("file:resources/Images/Corgi/corgiJump7.png", 180, 132, true, false));
		this.celebAnimList.add(new Image("file:resources/Images/Corgi/corgiJump8.png", 180, 132, true, false));
	}

	/**
	 * Initializes the animation list for reacting sadly
	 */
	public void initSadAnimList() {
		this.sadAnimList.add(new Image("file:resources/Images/Corgi/corgiSad0.png", 180, 132, true, false));
		this.sadAnimList.add(new Image("file:resources/Images/Corgi/corgiSad1.png", 180, 132, true, false));
		this.sadAnimList.add(new Image("file:resources/Images/Corgi/corgiSad2.png", 180, 132, true, false));
		this.sadAnimList.add(new Image("file:resources/Images/Corgi/corgiSad3.png", 180, 132, true, false));
	}

	/**
	 * Initializes the animation list for transition from real to "sleeping"
	 */
	public void initDeathAnimList() {
		this.deathAnimList.add(new Image("file:resources/Images/Corgi/corgiDeath0.png", 180, 132, true, false));
		this.deathAnimList.add(new Image("file:resources/Images/Corgi/corgiDeath1.png", 180, 132, true, false));
		this.deathAnimList.add(new Image("file:resources/Images/Corgi/corgiDeath2.png", 180, 132, true, false));
		this.deathAnimList.add(new Image("file:resources/Images/Corgi/corgiDeath3.png", 180, 132, true, false));
		this.deathAnimList.add(new Image("file:resources/Images/Corgi/corgiDeath4.png", 180, 132, true, false));
		this.deathAnimList.add(new Image("file:resources/Images/Corgi/corgiDeath5.png", 180, 132, true, false));
	}

	/**
	 * Initializes the animation list for being in "sleeping"/ghost-state
	 */
	public void initGhostAnimList() {
		this.ghostAnimList.add(new Image("file:resources/Images/Corgi/corgiGhost0.png", 180, 132, true, false));
		this.ghostAnimList.add(new Image("file:resources/Images/Corgi/corgiGhost1.png", 180, 132, true, false));
		this.ghostAnimList.add(new Image("file:resources/Images/Corgi/corgiGhost2.png", 180, 132, true, false));
		this.ghostAnimList.add(new Image("file:resources/Images/Corgi/corgiGhost3.png", 180, 132, true, false));
		this.ghostAnimList.add(new Image("file:resources/Images/Corgi/corgiGhost4.png", 180, 132, true, false));
		this.ghostAnimList.add(new Image("file:resources/Images/Corgi/corgiGhost5.png", 180, 132, true, false));
	}
}
