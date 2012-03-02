package Server;

import java.util.PriorityQueue;

import processing.core.PApplet;
import processing.core.PImage;
import Client.Actor;

@SuppressWarnings("serial")
public class Main extends PApplet
{
	static PriorityQueue<Actor> actors = new PriorityQueue<Actor>(64);
	public static PApplet p;
	public static final int sleep = 1000 / 7;
	EngineLoop demoThread;

	protected PImage bg;

	public void setup()
	{
		size(800, 600);

		frameRate(30);
		smooth();
		bg = loadImage("sprite/hk_collusseum.png");
		demoThread = new EngineLoop();
		demoThread.start();
		p = this;
		actors.add(new Actor("woody"));
	}

	public void draw()
	{
		// System.out.println( "draw");
		background(255);
		image(bg, 0, 0);
		for (Actor a : actors)
		{

			// flip across x axis
			image(a.draw(), 80 * 1, 80 * 1);
			/*
			 * Main.p.image(tree.play("walking") , 80 * 1, 0);
			 * Main.p.image(tree.play("running") , 80 * 2, 0);
			 * Main.p.image(tree.play("punch") , 80 * 3, 0);
			 * Main.p.image(tree.play("super_punch") , 80 * 4, 0);
			 * Main.p.image(tree.play("roll") , 80 * 5, 0);
			 */
			// a.draw();
		}
	}

	public void keyPressed()
	{
		KeyComboChecker.pressed(keyCode);
	}

	public void keyReleased()
	{
		KeyComboChecker.released(keyCode);
	}

	public static void tick()
	{
		// System.out.println( "tick");
		for (Actor a : actors)
		{
			a.tick();
		}
	}
}
