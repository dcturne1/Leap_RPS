import java.util.Random;
import com.leapmotion.leap.*;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;

class RPSListener extends Listener
{
	public void onInit(Controller controller)
	{
		System.out.println("Intialized");
	}
	
	public void onConnect(Controller controller)
	{
		System.out.println("Connected");
		controller.enableGesture(Gesture.Type.TYPE_SWIPE);
	    controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
	    controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
	    controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
	}
	
	public void onDisconnect(Controller controller) 
	{
        //Note: not dispatched when running in a debugger.
        System.out.println("Disconnected");
    }
	
	public void onExit(Controller controller)
	{
        System.out.println("Exited");
    }
	
	public void onFrame(Controller controller)
	{
		try {
			Robot robot = new Robot();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		Frame frame = controller.frame();
		Finger finger = frame.fingers().frontmost();
		Vector stabilizedPosition = finger.stabilizedTipPosition();
		
		InteractionBox iBox = controller.frame().interactionBox();
		Vector normalizedPosition = iBox.normalizePoint(stabilizedPosition);
		double tempX = normalizedPosition.getX() * screenSize.getWidth();
		double tempY = screenSize.getHeight() - normalizedPosition.getY() * screenSize.getHeight();
		
		int x = (int)tempX;
		int y = (int)tempY;
		
		if (!frame.hands().isEmpty()) 
		{
			robot.mouseMove(x, y);
        }
         robot.delay(50);  
		 GestureList gestures = frame.gestures();
	        for (int i = 0; i < gestures.count(); i++) {
	            Gesture gesture = gestures.get(i);

	            switch(gesture.type()) {
	            case TYPE_SCREEN_TAP:
        			robot.mousePress(InputEvent.BUTTON1_MASK);
        			robot.mouseRelease(InputEvent.BUTTON1_MASK);
        			//Toolkit.getDefaultToolkit().beep();
        			robot.delay(1000);
                    break;
	            case TYPE_KEY_TAP: 
	            	break;
	            case TYPE_CIRCLE:
	            	break;
	            case TYPE_INVALID:
	            	break;
	            case TYPE_SWIPE:
	            	break;
	            default:
	            	System.out.println("No gesture.");
	           }
	        }
	        
	} catch (AWTException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}

class Sample {
	
	static RPSListener listener = new RPSListener();
	static Controller controller = new Controller();
	static Random r = new Random(); //DCT
	static GUIListener guiStuff = new GUIListener();
	static String playerThrow = ""; //DCT
	static String compThrow = ""; //DCT
	static String temp = "";
	static String winner = "";
	static int computer = 0; //DCT
	static int player = 0;
	
    public static void main(String[] args) 
    {
        // Create a sample listener and controller
    	controller.addListener(listener);
		
		//Scanner play = new Scanner(System.in);
		//System.out.println("Do you want to play Rock Paper Scissor???  (1/0)");
		//////////////////////////////////////////////////////DCT		
		guiStuff.createAndShowGUI();
    }
    
	 public static void run() {
			for(int x = 3; x > 0; x--)
			{	
				Toolkit.getDefaultToolkit().beep();
				Pause.oneSec();
			}
	        
			if(controller.frame().hands().count() == 0)  //No hand   //DCT
			{
				player = 0;
			}
			else if(controller.frame().fingers().count() == 0 || controller.frame().fingers().count() == 1)  //ROCK
			{
				player = 1;
			}
			else if(controller.frame().fingers().count() == 2 || controller.frame().fingers().count() == 3) //SCISSOR
			{
				player = 3;
			}
			else if(controller.frame().fingers().count() == 5)
			{
				player = 2;
			}
			else
			{
				player = 0;
			}
	                
			computer = r.nextInt(3) + 1; //DCT
			/////////////////////////////////////////DCT
			switch(player){
			case 0:
	        	playerThrow = "None";
	        	break;
	       	case 1:
	       		playerThrow = "Rock";
	       		break;
	       	case 2:
	       		playerThrow = "Paper";
	       		break;
	       	case 3:
	       		playerThrow = "Scissors";
	       		break;
			}
	        
			switch(computer){
	       	case 1:
	       		compThrow = "Rock";
	       		break;
	       	case 2:
	       		compThrow = "Paper";
	       		break;
	       	case 3:
	       		compThrow ="Scissors";
	       		break;
			}
			//////////////////////////////////////////DCT
			//System.out.println("Player: " + playerThrow + "\tComputer: " + compThrow + "\n"); //DCT
	        
			if((player== 1 && computer==3) || (player== 2 && computer==1) || (player== 3 && computer==2)) //p win
			{
				//System.out.println("Player wins!");
				winner = "Player wins!";
			}
			else if((player== 1 && computer==2) || (player== 2 && computer==3) || (player== 3 && computer==1)) //c win
			{
				//System.out.println("Computer Wins!");
				winner = "Computer wins!";
			}
			else if(player==computer) //draw
			{
				//System.out.println("It's a draw!");
				winner = "It's a draw!";
			}
				else //nothing
			{
				//System.out.println("No hand drawn");
				winner = "No hand drawn.";
			}
			
			temp = "Player: " + playerThrow + "\nComputer: " + compThrow + "\n" + winner;
			System.out.println(temp);
			//guiStuff.textUpdate();
			
	}
}