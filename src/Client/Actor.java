package Client;

import processing.core.PImage;
import Server.Main;

public class Actor implements Comparable<Actor>
{
	protected PImage b;
	String action;
	private int z_value;
	int offset;
	protected AnimationTree tree;

	public Actor(String name)
	{
		// FIXME formatter off
		action = "walking";
		b = Main.p.loadImage("sprite/" + name + ".png");
		tree = new AnimationTree();
		tree.add("standing"		, new Animation(b, new int[] { 0, 1, 2, 3 }						, 80, 80, true	));
		tree.add("roll"			, new Animation(b, new int[] { 59, 58, 69}						, 80, 80, false	));
		tree.add("walking"		, new Animation(b, new int[] { 4, 5, 6, 7 }						, 80, 80, true	));
		tree.add("running"		, new Animation(b, new int[] { 20, 21, 22 }						, 80, 80, true	));
		tree.add("punch"		, new Animation(b, new int[] { 10, 11, 12, 13, 14, 15, 16, 17 }	, 80, 80, false	));
		tree.add("super_punch"	, new Animation(b, new int[] { 8, 9, 19, 29, 39, 49 }			, 80, 80, false	));
	}

	public PImage draw()
	{
		return tree.play(action);
	}

	public void setAction(String action)
	{
		this.action = action;
	}

	@Override
	public int compareTo(Actor a2)
	{
		return this.z_value - a2.z_value;
	}

	public void tick()
	{
		tree.tick();
	}
}

/*
 * for (int y = 0; y < pg.height; y++) { for (int x = 0; x < pg.width; x++) {
 * int loc = x + y * pg.width; int loc2 = x + y * b.width; pg.pixels[loc] =
 * b.pixels[loc2+offset] ; } }
 */