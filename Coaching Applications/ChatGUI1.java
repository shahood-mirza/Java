import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ChatGUI1 extends JFrame {
	
	private JTextField txt1, txt2;
	private JButton open, send;
	private JLabel host, port;
	
	public ChatGUI1() {
		
		super("Simple Chat");
		super.setLocation(500, 300);
		setLayout(new GridLayout(3,2,2,0));
		//setLayout(new FlowLayout());
		
		host = new JLabel("Host");
		add(host);
		
		txt1 = new JTextField(10);
		add(txt1);
		
		port = new JLabel("Port");
		add(port);
		
		txt2 = new JTextField(10);
		add(txt2);
		
		open = new JButton("Open35");
		add(open);
		
		send = new JButton("Send");
		add(send);
		
		ActionHandler handler = new ActionHandler();
		txt1.addActionListener(handler);
		txt2.addActionListener(handler);
		open.addActionListener(handler);
		send.addActionListener(handler);
	}
	
	private class ActionHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			String string = "";
			
			if (event.getSource() == txt1)
				string = String.format("Host: %s", event.getActionCommand());
			else if (event.getSource() == txt2)
				string = String.format("Port: %s", event.getActionCommand());
			else if (event.getSource() == open)
				string = String.format(open.getText(), event.getActionCommand());
			else if (event.getSource() == send)
				string = String.format(send.getText(), event.getActionCommand());
			
			//JOptionPane.showMessageDialog(null, String.format("%s", event.getActionCommand()));
			
			JOptionPane.showMessageDialog(null, string);
		}
	}
	
	public static void main(String[] args) {
		ChatGUI1 chtFrame = new ChatGUI1();
		chtFrame.getContentPane().setBackground(Color.GREEN);
		chtFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chtFrame.setSize(350, 100);
		chtFrame.setVisible(true);
	}
}
