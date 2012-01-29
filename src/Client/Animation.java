package Client;

import Server.Main;
import processing.core.PConstants;
import processing.core.PImage;

public class Animation
{
	private PImage[] frames;
	private int frameNumber;

	private boolean loop;

	private int addi;

	public Animation(PImage image, int[] keyframes, int width, int height, boolean loop)
	{
		this.loop = loop;
		addi = 1;
		frames = new PImage[keyframes.length];
		int offset = width;

		int x_frames = image.width / width;

		for (int i = 0; i < frames.length; i++)
		{
			int yy = keyframes[i] / x_frames;
			int xx = (keyframes[i] % x_frames);
			System.out.println(yy + " - " + xx);
			frames[i] = Main.p.createGraphics(width, height, PConstants.P3D);
			for (int y = 0; y < height; y++)
			{
				for (int x = 0; x < width; x++)
				{
					int loc = x + y * width;
					int loc2 = x + y * image.width;
					frames[i].pixels[loc] = image.pixels[loc2+(width * height * yy * x_frames + width * xx)];
				}
			}
		}
		frameNumber = 0;
	}

	public void tick()
	{
		frameNumber += addi;
		if (frameNumber == frames.length - 1)
		{
			if (loop)
			{
				addi *= -1;
			} else
			{
				frameNumber = 0;
			}
		} else if (frameNumber == 0)
		{
			if (loop)
			{
				addi *= -1;
			}
		}
		// System.out.println( frameNumber);
	}

	public PImage play()
	{
		return frames[frameNumber];
	}
}
