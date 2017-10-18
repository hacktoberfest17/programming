import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame{
	private JPanel tablePanel;
	private JTable table;
	public App(){
		
		initUI();
	}
	private void initUI(){
		Object test[][] = new Object[5][2];
		test[0][0] = "Peter";
		test[0][1] = 19;
		test[1][0] = "Charles";
		test[1][1] = 35;
		test[2][0] = "Eduard";
		test[2][1] = 13;
		test[3][0] = "Leo";
		test[3][1] = 15;
		test[4][0] = "Nick";
		test[4][1] = 9;
		String titles[] = {"Name","Age"};
		table = new FTable(test,titles);
		tablePanel = new TablePanel(table);
		
		setContentPane(tablePanel);
		setTitle("Table use example");
		pack();
		//setResizable(false);
		setSize(800,500);
		setMinimumSize(new Dimension(800,500));

		setLocationRelativeTo(null);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// setVisible(true);
	}

	public static void main(String args[]){
		App app = new App();
		app.setVisible(true);
	}
}