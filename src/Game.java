import com.leapmotion.leap.Controller;

public class Game 
{
	private RPSListener listener;
	private Controller controller;
	private int rand;
	
	public Game()
	{
		listener = new RPSListener();
		controller = new Controller();
		rand = -1;
	}
	
	public Game(RPSListener listener, Controller controller, int rand)
	{
		this.listener = listener;
		this.controller = controller;
		this.rand = rand;
	}
}
