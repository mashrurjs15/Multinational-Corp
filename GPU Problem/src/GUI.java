/**
 * 
 * @author Eric, Adam
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
	private int FRAME_HEIGHT = 300;
	private int FRAME_WIDTH = 300;
	
	private int COMPONENT_LEFT_SIDE_CONSTRAINT = 15;
    private int TEXTFIELD_LEFT_CONSTRAINT = 10;
    private int CORECLOCK_TOP_CONSTRAINT = 10;
    private int BOOSTCLOCK_TOP_CONSTRAINT = 40;
    private int MEMORYSIZE_TOP_CONSTRAINT = 70;
    private int COMPANY_TOP_CONSTRAINT = 100;
    private int KNN_TOP_CONSTRAINT = 130;
    private int ANALYZEBUTTON_TOP_CONSTRAINT = 170;
    private int RESULT_LABEL_TOP_CONSTRAINT = 215;
    private int RESULT_TEXTFIELD_TOP_CONSTRAINT = 235;
    
	public GUI(CentralUnit unit){
		
		
		JLabel coreClockLabel,boostClockLabel,memorySizeLabel,companyLabel,resultLabel,knnLabel;
		JTextField coreClockTextField,boostClockTextField,memorySizeTextField,companyTextField,resultTextField,knnTextField;
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
		coreClockLabel = new JLabel("Core Clock: ");
		coreClockTextField = new JTextField("", TEXTFIELD_LENGTH);
		boostClockLabel = new JLabel("Boost Clock: ");
		boostClockTextField = new JTextField("",TEXTFIELD_LENGTH);
		memorySizeLabel = new JLabel("Memory Size: ");
		memorySizeTextField = new JTextField("", TEXTFIELD_LENGTH);
		companyLabel = new JLabel("Company: ");
		companyTextField = new JTextField("", TEXTFIELD_LENGTH);
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
				if (!isDouble(coreClockTextField.getText())){
					coreClockTextField.setText("Enter a Double");
				}if(!isDouble(boostClockTextField.getText())) {
					boostClockTextField.setText("Enter a Double");
				}if(!isInt(memorySizeTextField.getText())) {
					memorySizeTextField.setText("Enter an Int");
				}if(!isInt(knnTextField.getText())) {
					knnTextField.setText("Enter an int between 1 and " + (unit.getListSize() -1));
				}else if (Integer.parseInt(knnTextField.getText()) <= 0 || Integer.parseInt(knnTextField.getText()) >= unit.getListSize() ) {
					knnTextField.setText("Enter an int between 1 and " + (unit.getListSize() -1));
				}
				
				else {
					// if inputs are all valid, analyze the result
					double price = unit.determinePrice(Double.parseDouble(coreClockTextField.getText()),
				    		Double.parseDouble(boostClockTextField.getText()),
				    		Integer.parseInt(memorySizeTextField.getText()),
				    		companyTextField.getText(), Integer.parseInt(knnTextField.getText()));
				    
				    resultTextField.setText(Double.toString(price));
				    
				    // Add new GPU to central unit list
				    unit.addToList(new GPU(Double.parseDouble(coreClockTextField.getText()),
				    		Double.parseDouble(boostClockTextField.getText()),
				    		Integer.parseInt(memorySizeTextField.getText()),
				    		companyTextField.getText(),price));
					 		
				}
				  
			    
			  } 
			} );
			
		//add content to layout
		contentPane.add(coreClockLabel);
	    contentPane.add(coreClockTextField);    
	    contentPane.add(boostClockLabel);
	    contentPane.add(boostClockTextField);
	    contentPane.add(memorySizeLabel);
	    contentPane.add(memorySizeTextField);
	    contentPane.add(companyLabel);
	    contentPane.add(companyTextField);
	    contentPane.add(knnLabel);
	    contentPane.add(knnTextField);
	    contentPane.add(analyzeButton);
	    contentPane.add(resultLabel);
	    contentPane.add(resultTextField);
	    
	    
	    //layout constraints
	    
	    
	    layout.putConstraint(SpringLayout.WEST, coreClockLabel, COMPONENT_LEFT_SIDE_CONSTRAINT, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, coreClockLabel, CORECLOCK_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);		
	    layout.putConstraint(SpringLayout.WEST, coreClockTextField, TEXTFIELD_LEFT_CONSTRAINT, SpringLayout.EAST, coreClockLabel);
	    layout.putConstraint(SpringLayout.NORTH, coreClockTextField, CORECLOCK_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);

	    layout.putConstraint(SpringLayout.WEST, boostClockLabel, COMPONENT_LEFT_SIDE_CONSTRAINT, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, boostClockLabel, BOOSTCLOCK_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);		
	    layout.putConstraint(SpringLayout.WEST, boostClockTextField, TEXTFIELD_LEFT_CONSTRAINT, SpringLayout.EAST, coreClockLabel);
	    layout.putConstraint(SpringLayout.NORTH, boostClockTextField, BOOSTCLOCK_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);
		
	    layout.putConstraint(SpringLayout.WEST, memorySizeLabel, COMPONENT_LEFT_SIDE_CONSTRAINT, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, memorySizeLabel, MEMORYSIZE_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);		
	    layout.putConstraint(SpringLayout.WEST, memorySizeTextField, TEXTFIELD_LEFT_CONSTRAINT, SpringLayout.EAST, coreClockLabel);
	    layout.putConstraint(SpringLayout.NORTH, memorySizeTextField, MEMORYSIZE_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);

	    layout.putConstraint(SpringLayout.WEST, companyLabel, COMPONENT_LEFT_SIDE_CONSTRAINT, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, companyLabel, COMPANY_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);		
	    layout.putConstraint(SpringLayout.WEST, companyTextField, TEXTFIELD_LEFT_CONSTRAINT, SpringLayout.EAST, coreClockLabel);
	    layout.putConstraint(SpringLayout.NORTH, companyTextField, COMPANY_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);
	    
	    layout.putConstraint(SpringLayout.WEST, knnLabel, COMPONENT_LEFT_SIDE_CONSTRAINT, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, knnLabel, KNN_TOP_CONSTRAINT, SpringLayout.NORTH, contentPane);		
	    layout.putConstraint(SpringLayout.WEST, knnTextField, TEXTFIELD_LEFT_CONSTRAINT, SpringLayout.EAST, coreClockLabel);
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
	
	boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
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
