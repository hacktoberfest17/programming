//Import Unga Bunga
import javax.swing.*;
import java.awt.*;

public class BasicChatAppInterface {
	//Class
    public static void main(String args[]) {
	//Main Method
        //main frame
        JFrame frame = new JFrame("Chat Frame");

        Color bg = Color.decode("#181f23");
        Color fontclr = Color.decode("#eff9ff");
        Color panelbg= Color.decode("#ffd6a5");
        Color menubg = Color.decode("#1c2a50");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        //The Menu that will later allow us to connect and create rooms to join a chat
        JMenuBar mb = new JMenuBar();
        mb.setBackground(panelbg);
        JMenu m1 = new JMenu("Connect");
        JMenu m2 = new JMenu("Help");
		//This is for help
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Create new room");
        JMenuItem m22 = new JMenuItem("Join an Existing Room");
        m1.add(m11);
        m1.add(m22);

        //Our panel
        JPanel panel = new JPanel();
        panel.setSize(400,300);
		panel.setBackground(panelbg);
        JLabel label = new JLabel("Enter Text");
        //The Message field
		JTextField tf = new JTextField(15);
		//The Sending button
        JButton send = new JButton("Send");
		
		
		//The resetting button
        JButton reset = new JButton("Reset");
		//Adding the panel
        panel.add(label); 
        panel.add(tf);
        panel.add(send);
        panel.add(reset);

		//The text area where the messages will go
        JTextArea ta = new JTextArea();
        ta.setEditable(false);
        ta.setFont(new Font("Consolas", Font.PLAIN, 12));
        ta.setBackground(bg);
        ta.setForeground(fontclr);
		//Adding it to the Scroll Pane so that It has scrolls
		JScrollPane sp = new JScrollPane(ta);
		
		//Actionlisteners allow us to listen to the actions that take place with 
		//The Specific components like here when the button is pressed
		send.addActionListener(e ->{
			//It will first store the text of the the text field in a
			//variable called msg
			String msg = tf.getText();	
			//Then Will remove the Text from the field so that new messages can be 
			//sent
			tf.setText(null);
			//Now it will send The message to the message text area
			ta.append(msg+"\n");
			});
        reset.addActionListener(e ->{
			//This is for the reset option
				ta.setText(null);
			//It will jus set all the text of the message area to null
			//i.e. Nothing
		}	
		);

		tf.addActionListener(e ->{
			String msg = tf.getText();
			tf.setText(null);
			ta.append(msg+"\n");
		});
		
		//adds all the content and components to the main frame.

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
		/*notice the BorderLayout here, it is from the awt package and it 
		is letting us lay the components in a specific layout. 
		Also we have changed the component below after the center to sp
		i.e. it is the scrollpane instead of our textarea to get the Scroll Bars!!*/
        frame.getContentPane().add(BorderLayout.CENTER, sp);
        frame.setVisible(true);
		//Pretty Self-Explanatory
    }
    
}

