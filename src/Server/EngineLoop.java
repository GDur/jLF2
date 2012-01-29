package Server;

import Server.Main;

class EngineLoop extends Thread
{
	
	public void run()
	{
		int d = 1000 / 7;
		while (true)
		{
			try
			{
				Main.tick();
				sleep(d);
			} catch (InterruptedException e)
			{
				System.out.println( "fehrer");
			}
		}
	}
}