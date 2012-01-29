package Server;

import java.util.PriorityQueue;

import processing.core.PApplet;
import Client.Actor;

@SuppressWarnings("serial")
public class Main extends PApplet
{
	static PriorityQueue<Actor> actors = new PriorityQueue<Actor>(64);
	public static PApplet p;
	public static final int sleep = 1000 / 7;
	EngineLoop demoThread;

	public void setup()
	{
		size(800, 600);
		frameRate(30);
		smooth();
		demoThread = new EngineLoop();
		demoThread.start();
		p = this;
		actors.add(new Actor("woody"));
	}

	public void draw()
	{
		// System.out.println( "draw");
		background(255);
		for (Actor a : actors)
		{
			a.draw();
		}
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
