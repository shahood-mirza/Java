import javax.swing.JOptionPane;
import java.lang.System.*;

public class GUI_Basics {

	public static void main(String[] args) {
		// Get inputs from dialog boxes
		String fName = 	JOptionPane.showInputDialog("Enter First Name:");
		String lName = 	JOptionPane.showInputDialog("Enter Last Name:");
		String phone = 	JOptionPane.showInputDialog("Enter Telephone #:");
		
		// Display message to user
		JOptionPane.showMessageDialog(null, "Name: " + fName + " " + lName +
				"\nTelephone Number: " + phone,
				"User Information", JOptionPane.INFORMATION_MESSAGE);
	}

}
