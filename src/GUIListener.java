import java.awt.BorderLayout;
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
import javax.swing.JTextField;

public class GUIListener extends JPanel
{
	static JTextArea textArea = new JTextArea(3, 30);
	
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
        
        JButton buttonY = new JButton("Yes");
        buttonY.setPreferredSize(new Dimension(225, 80));
        buttonY.setMinimumSize(new Dimension(225, 80));
        buttonY.setMaximumSize(new Dimension(225, 80));
        buttonY.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton buttonN = new JButton("No");
        buttonN.setPreferredSize(new Dimension(225, 80));
        buttonN.setMinimumSize(new Dimension(225, 80));
        buttonN.setMaximumSize(new Dimension(225, 80));
        buttonN.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel.add(label);
        panel.add(scrollPane);
        panel.add(buttonY);
        panel.add(buttonN);
        
        add(panel);
    }
	
	public void textUpdate(String temp) {
		textArea.setCaretPosition(0);
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
