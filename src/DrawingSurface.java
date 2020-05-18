

import java.awt.Point;
import java.util.ArrayList;

import processing.core.PApplet;

public class DrawingSurface extends PApplet implements ScreenSwitcher {

    public float ratioX, ratioY;

    private ArrayList<Integer> keys;

    private Screen activeScreen;
    private ArrayList<Screen> screens;


    public DrawingSurface() {
        screens = new ArrayList<Screen>();

        keys = new ArrayList<Integer>();


        FirstScreen screen1 = new FirstScreen(this);
        screens.add(screen1);

        SecondScreen screen2 = new SecondScreen(this);
        screens.add(screen2);

        activeScreen = screens.get(0);

    }

    public void settings() {
        loadImage("/assets/lemon.png");
        loadImage("/assets/icon.png");
        loadImage("/assets/norm.png");
        loadImage("/assets/lil.png");
        // size(DRAWING_WIDTH, DRAWING_HEIGHT, P2D);
        size(activeScreen.displayWidth, activeScreen.displayHeight);
    }

    public void setup() {
        loadImage("/assets/lemon.png");
        loadImage("/assets/icon.png");
        loadImage("/assets/norm.png");
        loadImage("/assets/lil.png");
        surface.setResizable(true);
        for (Screen s : screens)
            s.setup();
    }

    public void draw() {
        ratioX = (float) width / activeScreen.displayWidth;
        ratioY = (float) height / activeScreen.displayHeight;

        pushMatrix();

        scale(ratioX, ratioY);

        activeScreen.draw();

        popMatrix();
    }

    public void keyPressed() {
        keys.add(keyCode);
    }

    public void keyReleased() {
        while (keys.contains(keyCode))
            keys.remove(new Integer(keyCode));
    }

    public boolean isPressed(Integer code) {
        return keys.contains(code);
    }

    public void mousePressed() {
        activeScreen.mousePressed();
    }

    public void mouseMoved() {
        activeScreen.mouseMoved();
    }

    public void mouseDragged() {
        activeScreen.mouseDragged();
    }

    public void mouseReleased() {
        activeScreen.mouseReleased();
    }

    public Point assumedCoordinatesToActual(Point assumed) {
        return new Point((int) (assumed.getX() * ratioX), (int) (assumed.getY() * ratioY));
    }

    public Point actualCoordinatesToAssumed(Point actual) {
        return new Point((int) (actual.getX() / ratioX), (int) (actual.getY() / ratioY));
    }

    @Override
    public void switchScreen(int i) {
        activeScreen = screens.get(i);
    }

}
