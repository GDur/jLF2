package Client;

import java.util.Iterator;
import java.util.LinkedList;

import processing.core.PConstants;
import processing.core.PImage;
import Server.Main;

public class Animation
{
	private PImage[] keyPictures;

	LinkedList<Frame> animation;
	Frame tmpFrame;
	Frame startFrame;
	Iterator<Frame> iterator;

	public Animation(PImage image, int[] keyframes, int[] loop, int width, int height)
	{

		keyPictures = new PImage[keyframes.length];

		int x_frames = image.width / width;

		for (int i = 0; i < keyPictures.length; i++)
		{
			int yy = keyframes[i] / x_frames;
			int xx = (keyframes[i] % x_frames);
			keyPictures[i] = Main.p.createGraphics(width, height, PConstants.P3D);
			for (int y = 0; y < height; y++)
			{
				for (int x = 0; x < width; x++)
				{
					int loc = x + y * width;
					int loc2 = x + y * image.width;
					keyPictures[i].pixels[loc] = image.pixels[loc2 + (width * height * yy * x_frames + width * xx)];
				}
			}
		}

		startFrame = new Frame(loop[0], 4, 0, 0, 0, 0, null);
		tmpFrame = new Frame(loop[1], 4, 0, 0, 0, 0, startFrame);
		for (int i = 2; i < loop.length - 1; i++)
		{
			tmpFrame = new Frame(loop[i], 4, 0, 0, 0, 0, tmpFrame);
		}
		tmpFrame.setNext(startFrame);
		// animation.add(new Frame(0, 4, 0, 0, 0, 0));
		// animation.add(new Frame(1, 4, 0, 0, 0, 0));
		// animation.add(new Frame(2, 4, 0, 0, 0, 0));
		// animation.add(new Frame(1, 4, 0, 0, 0, 0));
		// animation.add(animation.get(1));
		// iterator = animation.iterator();
		tmpFrame = startFrame;
	}

	class Frame
	{
		private int keyPic;
		private Frame next;

		public Frame(int keyPic, int displayDuration, int xTranslation, int zTranslation, int offsetX, int offsetZ, Frame prev)
		{
			this.keyPic = keyPic;

			if (prev != null)
				prev.setNext(this);
		}

		public void setNext(Frame next)
		{
			this.next = next;
		}

		public Frame getNext()
		{
			return next;
		}

		public PImage getPic()
		{
			return keyPictures[keyPic];
		}

		public int getKeyPic()
		{
			return keyPic;
		}
	}

	public void tick()
	{
		// tmp = iterator.next();
		System.out.println(tmpFrame.getKeyPic());
		tmpFrame = tmpFrame.getNext();
	}

	public PImage play()
	{
		// return keyPictures[frameNumber];
		return tmpFrame.getPic();
	}

	/*
	 * public void tick() {
	 * 
	 * frameNumber += addi; if (loop) { if (frameNumber == keyPictures.length -
	 * 1 || frameNumber == 0) { addi *= -1; } } else { if (frameNumber ==
	 * keyPictures.length) { frameNumber = 0; } }
	 * 
	 * // System.out.println( frameNumber); }
	 */

}
