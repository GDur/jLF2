package Server;

public class KeyComboChecker
{

	public static void pressed(int keyCode)
	{
		// TODO Auto-generated method stub
		switch (keyCode)
		// tasten : q,w,e,a,s,d
		{
		case 81:
			Server.Main.actors.peek().setAction("standing");
			break;
		case 87:
			Server.Main.actors.peek().setAction("roll");
			break;
		case 69:
			Server.Main.actors.peek().setAction("walking");
			break;
		case 65:
			Server.Main.actors.peek().setAction("running");
			break;
		case 83:
			Server.Main.actors.peek().setAction("punch");
			break;
		case 68:
			Server.Main.actors.peek().setAction("super_punch");
			break;
		}
	}

	public static void released(int keyCode)
	{
		// TODO Auto-generated method stub

	}

}
