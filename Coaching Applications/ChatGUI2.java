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

public class ChatGUI2 extends JFrame {
	
	private JTextField txt1, txt2;
	private JButton open, send;
	private JLabel host, port;
	
	public ChatGUI2() {
		
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
		
		open = new JButton("Open");
		add(open);
		
		send = new JButton("Send");
		add(send);
		
		ActionHandler handler1 = new ActionHandler();
		ActionHandler handler2 = new ActionHandler();
		ActionHandler handler3 = new ActionHandler();
		ActionHandler handler4 = new ActionHandler();
		
		txt1.addActionListener(handler1);
		txt2.addActionListener(handler2);
		open.addActionListener(handler3);
		send.addActionListener(handler4);
		
	}
	
	private class ActionHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			JOptionPane.showMessageDialog(null, String.format("%s", event.getActionCommand()));
		}
	}
		
	public static void main(String[] args) {
		ChatGUI2 chtFrame = new ChatGUI2();
		chtFrame.getContentPane().setBackground(Color.BLUE);
		chtFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chtFrame.setSize(350, 100);
		chtFrame.setVisible(true);
	}
}
