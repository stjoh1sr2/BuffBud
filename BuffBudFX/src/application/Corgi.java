package application;

import java.util.*;
import javafx.scene.image.Image;

public class Corgi extends Pet {
	LinkedList<Image> idleAnimList = new LinkedList<Image>();
	LinkedList<Image> walkAnimList = new LinkedList<Image>();
	LinkedList<Image> celebAnimList = new LinkedList<Image>();
	LinkedList<Image> sadAnimList = new LinkedList<Image>();
	LinkedList<Image> deathAnimList = new LinkedList<Image>();
	LinkedList<Image> ghostAnimList = new LinkedList<Image>();

	public Corgi(String petName) {
		super(petName);
		this.initIdleAnimList();
		this.initWalkAnimList();
		this.initCelebAnimList();
		this.initSadAnimList();
		this.initDeathAnimList(); // TODO
		this.initGhostAnimList(); // TODO
	}

	public Corgi(String petName, int healthLevel, long timeOfLastExcersize, boolean isSleeping) {
		super(petName, healthLevel, timeOfLastExcersize, isSleeping);
		this.initIdleAnimList();
		this.initWalkAnimList();
		this.initCelebAnimList();
		this.initSadAnimList();
		this.initDeathAnimList(); // TODO
		this.initGhostAnimList(); // TODO
	}

	public String getPetType() {
		return "Corgi";
	}

	public List<Image> getIdleAnimList() {
		return this.idleAnimList;
	}
	
	public List<Image> getWalkAnimList() {
		return this.walkAnimList;
	}
	
	public List<Image> getCelebAnimList() {
		return this.celebAnimList;
	}
	
	public List<Image> getSadAnimList() {
		return this.sadAnimList;
	}
	
	// TODO: REMOVE?
	public List<Image> getDeathAnimList() {
		return this.deathAnimList;
	}
	
	// TODO: REMOVE?
	public List<Image> getGhostAnimList() {
		return this.ghostAnimList;
	}

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
	
	public void initWalkAnimList() {
		this.walkAnimList.add(new Image("file:resources/Images/Corgi/corgiWalk0.png", 180, 132, true, false));
		this.walkAnimList.add(new Image("file:resources/Images/Corgi/corgiWalk1.png", 180, 132, true, false));
		this.walkAnimList.add(new Image("file:resources/Images/Corgi/corgiWalk2.png", 180, 132, true, false));
		this.walkAnimList.add(new Image("file:resources/Images/Corgi/corgiWalk3.png", 180, 132, true, false));
	}
	
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
	
	public void initSadAnimList() {
		this.sadAnimList.add(new Image("file:resources/Images/Corgi/corgiSad0.png", 180, 132, true, false));
		this.sadAnimList.add(new Image("file:resources/Images/Corgi/corgiSad1.png", 180, 132, true, false));
		this.sadAnimList.add(new Image("file:resources/Images/Corgi/corgiSad2.png", 180, 132, true, false));
		this.sadAnimList.add(new Image("file:resources/Images/Corgi/corgiSad3.png", 180, 132, true, false));
	}
	
	// TODO: REMOVE?
	public void initDeathAnimList() {
		this.deathAnimList.add(new Image("file:resources/Images/Corgi/corgiDeath0.png", 180, 132, true, false));
		this.deathAnimList.add(new Image("file:resources/Images/Corgi/corgiDeath1.png", 180, 132, true, false));
		this.deathAnimList.add(new Image("file:resources/Images/Corgi/corgiDeath2.png", 180, 132, true, false));
		this.deathAnimList.add(new Image("file:resources/Images/Corgi/corgiDeath3.png", 180, 132, true, false));
		this.deathAnimList.add(new Image("file:resources/Images/Corgi/corgiDeath4.png", 180, 132, true, false));
		this.deathAnimList.add(new Image("file:resources/Images/Corgi/corgiDeath5.png", 180, 132, true, false));
	}
	
	// TODO: REMOVE?
	public void initGhostAnimList() {
		this.ghostAnimList.add(new Image("file:resources/Images/Corgi/corgiGhost0.png", 180, 132, true, false));
		this.ghostAnimList.add(new Image("file:resources/Images/Corgi/corgiGhost1.png", 180, 132, true, false));
		this.ghostAnimList.add(new Image("file:resources/Images/Corgi/corgiGhost2.png", 180, 132, true, false));
		this.ghostAnimList.add(new Image("file:resources/Images/Corgi/corgiGhost3.png", 180, 132, true, false));
		this.ghostAnimList.add(new Image("file:resources/Images/Corgi/corgiGhost4.png", 180, 132, true, false));
		this.ghostAnimList.add(new Image("file:resources/Images/Corgi/corgiGhost5.png", 180, 132, true, false));
	}
}
