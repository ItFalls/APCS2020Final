import java.awt.Point;
import java.awt.Rectangle;


public class FirstScreen extends Screen {

	private DrawingSurface surface;
	
	private Rectangle playButton;
	private Rectangle creditButton;

	public FirstScreen(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;

		playButton = new Rectangle(super.displayWidth/2-100,super.displayHeight/2-50,200,100);
		creditButton = new Rectangle(super.displayWidth/2-100,super.displayHeight/2 + 70,200,100);
	}


	public void draw() {

		surface.pushStyle();
		
		surface.background(255,255,255);
		
		surface.rect(playButton.x, playButton.y, playButton.width, playButton.height, 10, 10, 10, 10);
		surface.fill(0);
		float w = surface.textWidth("Play");
		surface.text("Play", playButton.x+ playButton.width/2-w/2, playButton.y+ playButton.height/2);

		surface.fill(255);
		surface.rect(creditButton.x, creditButton.y, creditButton.width, creditButton.height, 10, 10, 10, 10);
		surface.fill(0);
		float w2 = surface.textWidth("Credits");
		surface.text("Credits", creditButton.x+ creditButton.width/2-w2/2, creditButton.y+ creditButton.height/2);

		surface.textSize(24);
		surface.text("Spaceteroids", super.displayWidth/3 + 65, super.displayHeight/3);

		surface.textSize(16);
		surface.text("Press space to return to title screen \nPress esc to exit", super.displayWidth/3 , 5 * super.displayHeight/6);

		surface.popStyle();
	}
	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (playButton.contains(p))
			surface.switchScreen(ScreenSwitcher.SCREEN2);
		if (creditButton.contains(p))
			surface.switchScreen(ScreenSwitcher.SCREEN3);
	}
}
