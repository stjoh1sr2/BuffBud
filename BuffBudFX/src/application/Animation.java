package application;

import java.util.LinkedList;
import javafx.scene.image.*;
import javafx.util.Duration;

public class Animation {
	private ImageView imageView;
	private Duration duration;
	private LinkedList<Image> animationImages;
	int index = 0;
	
	public Animation(ImageView imageView, Duration duration, LinkedList<Image> animationImages) {
		super();
		this.imageView = imageView;
		this.duration = duration;
		this.animationImages = animationImages;
	}
	
	public void nextFrame() {
		
	}


}
