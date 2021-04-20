package application;

import java.util.*;
import javafx.scene.image.Image;

/**
 * Represents a Corgi, which is a type of Pet.
 */
public class Corgi extends Pet {
	/**
	 * List of images representing idle animation.
	 */
	LinkedList<Image> idleAnimList = new LinkedList<Image>();

	/**
	 * List of images representing walking animation.
	 */
	LinkedList<Image> walkAnimList = new LinkedList<Image>();

	/**
	 * List of images representing celebratory animation.
	 */
	LinkedList<Image> celebAnimList = new LinkedList<Image>();

	/**
	 * List of images representing sad animation.
	 */
	LinkedList<Image> sadAnimList = new LinkedList<Image>();

	/**
	 * List of images representing death animation (when reversed, the revival
	 * animation).
	 */
	LinkedList<Image> deathAnimList = new LinkedList<Image>();

	/**
	 * List of images representing ghost animation.
	 */
	LinkedList<Image> ghostAnimList = new LinkedList<Image>();

	/**
	 * Creates a Corgi by name and sets up its animation lists
	 * 
	 * @param petName - the name of the pet
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
	 * @param petName             - the name of the pet
	 * @param healthLevel         - the pet's health level
	 * @param timeOfLastExcersize - the time the pet last exercised
	 * @param isSleeping          - whether or not the pet is "sleeping" (in ghost
	 *                            form)
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
	 * {@inheritDoc}
	 */
	public String getPetType() {
		return "Corgi";
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Image> getIdleAnimList() {
		return this.idleAnimList;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Image> getWalkAnimList() {
		return this.walkAnimList;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Image> getCelebAnimList() {
		return this.celebAnimList;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Image> getSadAnimList() {
		return this.sadAnimList;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Image> getDeathAnimList() {
		return this.deathAnimList;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Image> getGhostAnimList() {
		return this.ghostAnimList;
	}

	/**
	 * {@inheritDoc}
	 */
	public void initIdleAnimList() {
		for (int i = 0; i < 2; ++i) {
			this.idleAnimList.add(new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiIdle0.png"), 180,
					132, true, false));
			this.idleAnimList.add(new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiIdle1.png"), 180,
					132, true, false));
			this.idleAnimList.add(new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiIdle2.png"), 180,
					132, true, false));
			this.idleAnimList.add(new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiIdle3.png"), 180,
					132, true, false));
			this.idleAnimList.add(new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiIdle4.png"), 180,
					132, true, false));
			this.idleAnimList.add(new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiIdle0.png"), 180,
					132, true, false));
			this.idleAnimList.add(new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiIdle5.png"), 180,
					132, true, false));
			this.idleAnimList.add(new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiIdle6.png"), 180,
					132, true, false));
			this.idleAnimList.add(new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiIdle7.png"), 180,
					132, true, false));
		}

		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiIdle0.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit0.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit1.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit2.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit3.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit4.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit5.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit6.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit7.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit6.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit5.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit4.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit3.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit2.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit3.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit4.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit5.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit6.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit7.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit6.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit5.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit4.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit3.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit2.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit1.png"), 180, 132, true, false));
		this.idleAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSit0.png"), 180, 132, true, false));
	}

	/**
	 * {@inheritDoc}
	 */
	public void initWalkAnimList() {
		this.walkAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiWalk0.png"), 180, 132, true, false));
		this.walkAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiWalk1.png"), 180, 132, true, false));
		this.walkAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiWalk2.png"), 180, 132, true, false));
		this.walkAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiWalk3.png"), 180, 132, true, false));
	}

	/**
	 * {@inheritDoc}
	 */
	public void initCelebAnimList() {
		this.celebAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiJump0.png"), 180, 132, true, false));
		this.celebAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiJump1.png"), 180, 132, true, false));
		this.celebAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiJump2.png"), 180, 132, true, false));
		this.celebAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiJump3.png"), 180, 132, true, false));
		this.celebAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiJump4.png"), 180, 132, true, false));
		this.celebAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiJump5.png"), 180, 132, true, false));
		this.celebAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiJump6.png"), 180, 132, true, false));
		this.celebAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiJump7.png"), 180, 132, true, false));
		this.celebAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiJump8.png"), 180, 132, true, false));
	}

	/**
	 * {@inheritDoc}
	 */
	public void initSadAnimList() {
		this.sadAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSad0.png"), 180, 132, true, false));
		this.sadAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSad1.png"), 180, 132, true, false));
		this.sadAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSad2.png"), 180, 132, true, false));
		this.sadAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiSad3.png"), 180, 132, true, false));
	}

	/**
	 * {@inheritDoc}
	 */
	public void initDeathAnimList() {
		this.deathAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiDeath0.png"), 180, 132, true, false));
		this.deathAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiDeath1.png"), 180, 132, true, false));
		this.deathAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiDeath2.png"), 180, 132, true, false));
		this.deathAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiDeath3.png"), 180, 132, true, false));
		this.deathAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiDeath4.png"), 180, 132, true, false));
		this.deathAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiDeath5.png"), 180, 132, true, false));
	}

	/**
	 * {@inheritDoc}
	 */
	public void initGhostAnimList() {
		this.ghostAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiGhost0.png"), 180, 132, true, false));
		this.ghostAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiGhost1.png"), 180, 132, true, false));
		this.ghostAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiGhost2.png"), 180, 132, true, false));
		this.ghostAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiGhost3.png"), 180, 132, true, false));
		this.ghostAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiGhost4.png"), 180, 132, true, false));
		this.ghostAnimList.add(
				new Image(this.getClass().getResourceAsStream("/Images/Corgi/corgiGhost5.png"), 180, 132, true, false));
	}
}
