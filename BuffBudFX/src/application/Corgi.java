package application;

import java.util.*;
import javafx.scene.image.Image;

public class Corgi extends Pet {
	LinkedList<Image> idleAnimList = new LinkedList<Image>();
	LinkedList<Image> walkAnimList = new LinkedList<Image>();

	public Corgi(String petName) {
		super(petName);
		this.initIdleAnimList();
		this.initWalkAnimList();
	}

	public Corgi(String petName, int healthLevel, long timeOfLastExcersize, boolean isSleeping) {
		super(petName, healthLevel, timeOfLastExcersize, isSleeping);
		this.initIdleAnimList();
		this.initWalkAnimList();
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
}
