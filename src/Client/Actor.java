package Client;

import Server.Main;
import processing.core.PImage;

public class Actor implements Comparable<Actor>
{

	private PImage b;
	private int z_value;
	int offset;
	AnimationTree tree;

	public Actor(String name)
	{
		offset = 320;
		tree = new AnimationTree();
		b = Main.p.loadImage("sprite/" + name + ".png");
		tree.add("standing", new Animation(b, new int[] { 0, 1, 2, 3 }, 80, 80, true));
		tree.add("roll", new Animation(b, new int[] { 59, 58, 69, 4 }, 80, 80, false));
		tree.add("walking", new Animation(b, new int[] { 4, 5, 6, 7 }, 80, 80, true));
		tree.add("running", new Animation(b, new int[] { 20, 21, 22 }, 80, 80, true));
		tree.add("attack", new Animation(b, new int[] { 8, 9, 19, 29, 39, 49 }, 80, 80, false));
	}

	public void draw()
	{
		Main.p.image(tree.play("attack"), 190, 190);
		Main.p.image(tree.play("walking"), 290, 290);
		Main.p.image(tree.play("running"), 390, 290);
		Main.p.image(tree.play("standing"), 90, 90);
		Main.p.image(tree.play("roll"), 0, 0);
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