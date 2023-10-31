import java.util.Scanner; // Import the Scanner class for input
import javax.swing.*; // Import Java Swing library for creating GUI
import java.awt.*; // Import Java AWT for GUI components
import java.awt.event.ActionEvent; // Import Java AWT event for GUI components
import java.awt.event.ActionListener; // Import Java AWT event listener for GUI components

public class WeightCalculator{
    private JFrame frame; // The main window frame
    private JTextField weightField; // Text field for entering weight
    private JTextField heightField; // Text field for entering height

    public WeightCalculator() {
        frame = new JFrame("Weight Calculator");  // Create the main window frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Set the close operation
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Set the window to full screen of the monitor

        landingPage(); // Call the landing page method
    }

    public void landingPage(){
        JPanel landingPage = new JPanel();
        landingPage.setLayout(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome to the Weight Calculator!", SwingConstants.CENTER);
        JButton proceedButton = new JButton("Proceed");
        landingPage.add(welcomeLabel, BorderLayout.CENTER);
        landingPage.add(proceedButton, BorderLayout.SOUTH);

        // Add action listener to proceed button
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //If the button is clicked, the following code will be executed
                // Remove landing page and add weight calculator panel
                frame.getContentPane().removeAll();
                addWeightCalculatorPanel();
                frame.revalidate(); // Refresh the frame
                frame.repaint(); // Repaint the frame
            }
        });

        // Add landing page to frame
        frame.getContentPane().add(landingPage);
        frame.setVisible(true); // Make the window visible
    }

    private void addWeightCalculatorPanel() {
        weightField = new JTextField(10); // 10 is the width of the text field
        heightField = new JTextField(10); // 10 is the width of the text field
    
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override // Override the actionPerformed method
            public void actionPerformed(ActionEvent e) {
                double weight = Double.parseDouble(weightField.getText());
                double height = Double.parseDouble(heightField.getText());
                // Call your weight and height calculation methods here
            }
        });
    
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("Weight (pounds):"));
        panel.add(weightField); // Add the text field Weight (pounds) to the panel
        panel.add(new JLabel("Height (meters):"));
        panel.add(heightField); // Add the text field Height (meters) to the panel
        panel.add(calculateButton);
        frame.getContentPane().add(panel, BorderLayout.CENTER); // Add the panel to the center of the window
    }

    public static void main(String[] args){ // Main method where the program starts
        new WeightCalculator(); //New is required to create an object of the class
    }

    public static double weight_To_Pounds(double weight_pounds){
        double conversion_kgs_to_pounds =  0.45359237;
        double weight_kgs = weight_pounds*conversion_kgs_to_pounds;
        return weight_kgs;
    }
}

class Person{
    public String name;
    private int age;
    public String gender;
    public double weight;

    public Person(String name, int age, String gender, double weight){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
    }

    public static double bmi_calculated(double weight_kgs, double height_meters){
        return weight_kgs / (height_meters * height_meters);
    }
}

class Child extends Person{
    private double previousHeight;
    private double currentHeight;

    public Child(String name, int age, String gender, double weight, double previousHeight, double currentHeight){
        super(name, age, gender, weight); /// super is used to call the constructor of the parent class (Person)
        this.previousHeight = previousHeight;
        this.currentHeight = currentHeight;
    }

    public double calculateGrowthRate(){
        return currentHeight - previousHeight;
    }
}