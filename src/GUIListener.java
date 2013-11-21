import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIListener extends JPanel
{
	static JTextArea textArea;
	
	public GUIListener() {
        
        JPanel panel = new JPanel();
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension (20, 100));
        
        textArea = new JTextArea(10, 50);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        JLabel label = new JLabel("Would you like to play a game of Rock, Paper, Scissors?");
        
        JButton buttonY = new JButton("Yes");
        buttonY.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttonY.setPreferredSize(new Dimension(225, 80));
        JButton buttonN = new JButton("No");
        buttonN.setAlignmentX(Component.RIGHT_ALIGNMENT);
        buttonN.setPreferredSize(new Dimension(225, 80));
        
        panel.add(label);
        panel.add(textArea);
        panel.add(scrollPane);
        panel.add(buttonY);
        panel.add(buttonN);
        
        add(panel);
    }
	
	public void textUpdate(String temp) {
		//textArea.setCaretPosition(0);
		textArea.append(temp + "\n");
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
