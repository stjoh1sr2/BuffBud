import javafx.scene.image.Image;

public class Corgi extends Pet {
	private Image corgiIdle = new Image("file:testCorgi.png");

	public Corgi(String petName) {
		super(petName);
	}
	
	public Image getCorgiIdle() {
		return corgiIdle;
	}

	public void setCorgiIdle(Image corgiIdle) {
		this.corgiIdle = corgiIdle;
	}
}
