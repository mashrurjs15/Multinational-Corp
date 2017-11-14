/**
 * 
 * @author Andrew, Sunny
 *
 */
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class GUI {

	private int TEXTFIELD_LENGTH = 15;
	private int BUTTON_WIDTH = 250;
	private int BUTTON_HEIGHT = 40;
	private int FRAME_HEIGHT = 350;
	private int FRAME_WIDTH = 350;
	
	
	private int COMPONENT_LEFT_SIDE_CONSTRAINT = 15;
    private int TEXTFIELD_LEFT_CONSTRAINT = 50;
    private int CORECLOCK_TOP_CONSTRAINT = 10;
    private int BOOSTCLOCK_TOP_CONSTRAINT = 40;
    private int MEMORYSIZE_TOP_CONSTRAINT = 70;
    private int COMPANY_TOP_CONSTRAINT = 100;
    private int ROOM_TOP_CONSTRAINT = 130;
    private int KNN_TOP_CONSTRAINT = 160;
    private int ANALYZEBUTTON_TOP_CONSTRAINT = 190;
    private int RESULT_LABEL_TOP_CONSTRAINT = 235;
    private int RESULT_TEXTFIELD_TOP_CONSTRAINT = 255;
    
	public GUI(SimpleMachine unit){
		
		
		JLabel coordinateX,coordinateY,squareFeet,houseAge, roomSize,resultLabel,knnLabel;
		JTextField coordinateXField,coordinateYField,squareFeetField,houseAgeField,roomSizeField,resultTextField,knnTextField;
		JButton analyzeButton;
		JFrame frame;
		Container contentPane;
		SpringLayout layout;
		
		//Initialize frame
		frame = new JFrame("PROJECT");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create layout
		contentPane = frame.getContentPane();
	    layout = new SpringLayout();
	    contentPane.setLayout(layout);
		
	    // Create Labels and Text Fields
		coordinateX = new JLabel("Coordinate X: ");
		coordinateXField = new JTextField("", TEXTFIELD_LENGTH);
		coordinateY = new JLabel("Coordinate Y: ");
		coordinateYField = new JTextField("",TEXTFIELD_LENGTH);
		squareFeet = new JLabel("Square Feet: ");
		squareFeetField = new JTextField("", TEXTFIELD_LENGTH);
		houseAge = new JLabel("House Age (old/new): ");
		houseAgeField = new JTextField("", TEXTFIELD_LENGTH);
		roomSize = new JLabel("Overall Room Size: ");
		roomSizeField = new JTextField("", TEXTFIELD_LENGTH);
		knnLabel = new JLabel("kNN: ");
		knnTextField = new JTextField("", TEXTFIELD_LENGTH);
		
		resultLabel = new JLabel("Result:");
		
		resultTextField = new JTextField("", TEXTFIELD_LENGTH);
		resultTextField.setEditable(false);
		
		// Create Analyze button
		analyzeButton = new JButton("Analyze");
		analyzeButton.setPreferredSize(new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT));
		// Analyze results when button is pressed
		analyzeButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) {
				  
				///Test input values
				if (!isDouble(coordinateXField.getText())){
					coordinateXField.setText("Enter a Double");
				}if(!isDouble(coordinateYField.getText())) {
					coordinateYField.setText("Enter a Double");
				}if(!isInt(squareFeetField.getText())) {
					squareFeetField.setText("Enter an Int");
				}if(!isInt(roomSizeField.getText())) {
					roomSizeField.setText("Enter an Int");
				}if(!isInt(knnTextField.getText())) {
					knnTextField.setText("Enter an int between 1 and " + (unit.getListSize() -1));
				}else if (Integer.parseInt(knnTextField.getText()) <= 0 || Integer.parseInt(knnTextField.getText()) >= unit.getListSize() ) {
					knnTextField.setText("Enter an int between 1 and " + (unit.getListSize() -1));
				}
				
				else {
					// if inputs are all valid, analyze the result
					double price = unit.determinePrice(Double.parseDouble(coordinateXField.getText()),
				    		Double.parseDouble(coordinateYField.getText()),
				    		Integer.parseInt(squareFeetField.getText()),
				    		houseAgeField.getText(), Integer.parseInt(knnTextField.getText()));
				    
				    resultTextField.setText(Double.toString(price));
				    
				    // Add new GPU to central unit list
				    unit.addToList(new HouseInfo(Integer.parseInt(coordinateXField.getText()),
				    		Integer.parseInt(coordinateYField.getText()),
				    		Integer.parseInt(squareFeetField.getText()),
				    		houseAgeField.getText(), price, Integer.parseInt(roomSizeField.getText())));
					 		
				}
				  
			    
			  } 
			} );
			
		//add content to layout
		contentPane.add(coordinateX);
	    contentPane.add(coordinateXField);    
	    contentPane.add(coordinateY);
	    contentPane.add(coordinateYField);
	    contentPane.add(squareFeet);
	    contentPane.add(squareFeetField);
	    contentPane.add(houseAge);
	    contentPane.add(houseAgeField);
	    contentPane.add(roomSize);
	    contentPane.add(roomSizeField);
	    contentPane.add(knnLabel);
	    contentPane.add(knnTextField);
	    contentPane.add(analyzeButton);
	    contentPane.add(resultLabel);
	    contentPane.add(resultTextField);
	    
	    
	    //layout constraints
	    
	    
	    layout.putConstraint(SpringLayout.WEST, coordinateX, COMPONENT_LEFT_SIDE_CONSTRAINT, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, coordinateX, CORECLOCK_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);		
	    layout.putConstraint(SpringLayout.WEST, coordinateXField, TEXTFIELD_LEFT_CONSTRAINT, SpringLayout.EAST, coordinateX);
	    layout.putConstraint(SpringLayout.NORTH, coordinateXField, CORECLOCK_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);

	    layout.putConstraint(SpringLayout.WEST, coordinateY, COMPONENT_LEFT_SIDE_CONSTRAINT, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, coordinateY, BOOSTCLOCK_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);		
	    layout.putConstraint(SpringLayout.WEST, coordinateYField, TEXTFIELD_LEFT_CONSTRAINT, SpringLayout.EAST, coordinateX);
	    layout.putConstraint(SpringLayout.NORTH, coordinateYField, BOOSTCLOCK_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);
		
	    layout.putConstraint(SpringLayout.WEST, squareFeet, COMPONENT_LEFT_SIDE_CONSTRAINT, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, squareFeet, MEMORYSIZE_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);		
	    layout.putConstraint(SpringLayout.WEST, squareFeetField, TEXTFIELD_LEFT_CONSTRAINT, SpringLayout.EAST, coordinateX);
	    layout.putConstraint(SpringLayout.NORTH, squareFeetField, MEMORYSIZE_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);

	    layout.putConstraint(SpringLayout.WEST, houseAge, COMPONENT_LEFT_SIDE_CONSTRAINT, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, houseAge, COMPANY_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);		
	    layout.putConstraint(SpringLayout.WEST, houseAgeField, TEXTFIELD_LEFT_CONSTRAINT, SpringLayout.EAST, coordinateX);
	    layout.putConstraint(SpringLayout.NORTH, houseAgeField, COMPANY_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);
	    
	    layout.putConstraint(SpringLayout.WEST, roomSize, COMPONENT_LEFT_SIDE_CONSTRAINT, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, roomSize, ROOM_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);		
	    layout.putConstraint(SpringLayout.WEST, roomSizeField, TEXTFIELD_LEFT_CONSTRAINT, SpringLayout.EAST, coordinateX);
	    layout.putConstraint(SpringLayout.NORTH, roomSizeField, ROOM_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);
	    
	    layout.putConstraint(SpringLayout.WEST, knnLabel, COMPONENT_LEFT_SIDE_CONSTRAINT, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, knnLabel, KNN_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);		
	    layout.putConstraint(SpringLayout.WEST, knnTextField, TEXTFIELD_LEFT_CONSTRAINT, SpringLayout.EAST, coordinateX);
	    layout.putConstraint(SpringLayout.NORTH, knnTextField, KNN_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);
	    
	    
	    layout.putConstraint(SpringLayout.WEST, analyzeButton, COMPONENT_LEFT_SIDE_CONSTRAINT, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, analyzeButton, ANALYZEBUTTON_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);
	    
	    layout.putConstraint(SpringLayout.WEST, resultLabel, COMPONENT_LEFT_SIDE_CONSTRAINT, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, resultLabel, RESULT_LABEL_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);
	    layout.putConstraint(SpringLayout.WEST, resultTextField, COMPONENT_LEFT_SIDE_CONSTRAINT, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, resultTextField, RESULT_TEXTFIELD_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);
	    
		
	    //Make the frame visible
	    frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		frame.setVisible(true);
		
		
	}
	
	// Checks to see if the string is a double or not
	boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
	// Checks to see if the string is an integer or not
	public boolean isInt(String str)
	{
	    try
	    {
	        Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException ex)
	    {
	        return false;
	    }
	}
	
	
	
	
}
