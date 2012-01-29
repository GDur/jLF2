package Server;

import Server.Main;

class EngineLoop extends Thread
{
	
	public void run()
	{
		while (true)
		{
			try
			{
				Main.tick();
				sleep(Main.sleep);
			} catch (InterruptedException e)
			{
				System.out.println( "fehrer");
			}
		}
	}
}