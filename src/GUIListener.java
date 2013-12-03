import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUIListener extends JPanel
{
	JButton buttonY = new JButton("Yes");
	JButton buttonN = new JButton("No");
	
	JTextArea textArea = new JTextArea(3, 30);
	
	public GUIListener() {
       
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension (250, 250));
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
                
        JLabel label = new JLabel("Would you like to play a game of Rock, Paper, Scissors?");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        buttonY.setPreferredSize(new Dimension(225, 80));
        buttonY.setMinimumSize(new Dimension(225, 80));
        buttonY.setMaximumSize(new Dimension(225, 80));
        buttonY.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonY.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0)	{
    			/*for(int x = 3; x > 0; x--)
    			{	
    				Sample.temp = Integer.toString(x);
    				Pause.oneSec();
    				textUpdate();
    			}*/
        		Sample.run();
        		textUpdate();
        	}
        });
        
        buttonN.setPreferredSize(new Dimension(225, 80));
        buttonN.setMinimumSize(new Dimension(225, 80));
        buttonN.setMaximumSize(new Dimension(225, 80));
        buttonN.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonN.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		System.exit(0);
        	}
        });
        
        panel.add(label);
        panel.add(scrollPane);
        panel.add(buttonY);
        panel.add(buttonN);
        
        add(panel);
    }
	
	public void textUpdate() {
			textArea.setCaretPosition(0);
			textArea.append(Sample.temp + "\n");
			textArea.setCaretPosition(textArea.getDocument().getLength());
	}
	
	public void createAndShowGUI(){
        JFrame frame = new JFrame("Rock, Paper, Scissors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 325);
        
        frame.add(new GUIListener());
        
        frame.pack();
        frame.setVisible(true);
	}
}
