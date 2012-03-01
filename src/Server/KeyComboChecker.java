package Server;

public class KeyComboChecker
{

	public static void pressed(int keyCode)
	{
		Server.Main.actors.peek().setAction(codeAction(keyCode));
	}

	private static String codeAction(int keyCode) {
		switch (keyCode)
		// tasten : q,w,e,a,s,d
		{
		case 81:
			return "standing";
		case 87:
			return "roll";
		case 69:
			return "walking";
		case 65:
			return "running";
		case 83:
			return "punch";
		case 68:
			return "super_punch";
		default:
			return "";
		}
	}

	public static void released(int keyCode)
	{
		// TODO Auto-generated method stub

	}

}
