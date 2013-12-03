public class Pause 
{	
	public static void oneSec()
	{
		try
		{
			Thread.sleep(1000);
		}catch (InterruptedException ex){
			Thread.currentThread().interrupt();
		}
	}
}
