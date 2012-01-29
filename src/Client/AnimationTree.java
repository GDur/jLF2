package Client;

import java.util.HashMap;

import processing.core.PImage;

public class AnimationTree
{
	private HashMap<String, Animation> tree;

	public AnimationTree()
	{
		tree = new HashMap<String, Animation>();
	}

	public void add(String name, Animation a)
	{
		tree.put(name, a);
	}

	public PImage play(String name)
	{
		return tree.get(name).play();
	}

	public void tick()
	{
		for (String k : tree.keySet())
		{
			tree.get(k).tick();
		}
	}
}
