package application;

import java.util.*;
import javafx.scene.image.Image;

public class Corgi extends Pet {
	LinkedList<Image> idleAnimList = new LinkedList<Image>();
	
	public Corgi(String petName) {
		super(petName);
		this.initIdleAnimList();
	}
	
	public List<Image> getIdleAnimList() {
		return this.idleAnimList;
	}
	
	public void initIdleAnimList() {
		this.idleAnimList.add(new Image("file:Images/Corgi/corgiIdle0.png", 132, 108, true, false));
		this.idleAnimList.add(new Image("file:Images/Corgi/corgiIdle1.png", 132, 116, true, false));
		this.idleAnimList.add(new Image("file:Images/Corgi/corgiIdle2.png", 132, 108, true, false));
		this.idleAnimList.add(new Image("file:Images/Corgi/corgiIdle3.png", 132, 116, true, false));
		this.idleAnimList.add(new Image("file:Images/Corgi/corgiIdle4.png", 132, 108, true, false));
		this.idleAnimList.add(new Image("file:Images/Corgi/corgiIdle5.png", 132, 116, true, false));
		this.idleAnimList.add(new Image("file:Images/Corgi/corgiIdle6.png", 132, 108, true, false));
		this.idleAnimList.add(new Image("file:Images/Corgi/corgiIdle7.png", 132, 116, true, false));
		this.idleAnimList.add(new Image("file:Images/Corgi/corgiIdle8.png", 132, 108, true, false));
	}
}
