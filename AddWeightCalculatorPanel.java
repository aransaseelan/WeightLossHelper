import java.util.Scanner; // Import the Scanner class for input
import javax.swing.*; // Import Java Swing library for creating GUI
import java.awt.*; // Import Java AWT for GUI components
import java.awt.event.ActionEvent; // Import Java AWT event for GUI components
import java.awt.event.ActionListener; // Import Java AWT event listener for GUI components

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddWeightCalculatorPanel {
    private JTextField weightField;
    private JTextField heightField;
    private JFrame frame;

    public AddWeightCalculatorPanel() {
        weightField = new JTextField(10); // 10 is the width of the text field
        heightField = new JTextField(10); // 10 is the width of the text field

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override // Override the actionPerformed method
            public void actionPerformed(ActionEvent e) {
                double weight = Double.parseDouble(weightField.getText());
                double height = Double.parseDouble(heightField.getText());
                // Call your weight and height calculation methods here
                double weightInKgs = WeightCalculator.weight_To_Pounds(weight);
                double bmi = Person.bmi_calculated(weightInKgs, height);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2)); //Makes a grid layout on the panel 
        panel.add(new JLabel("Weight (pounds):"));
        panel.add(weightField); // Add the text field Weight (pounds) to the panel
        panel.add(new JLabel("Height (meters):"));
        panel.add(heightField); // Add the text field Height (meters) to the panel
        panel.add(calculateButton);
        panel.add(new JLabel("Your BMI is " )); // Add the label Your BMI is to the panel

        frame = new JFrame();
        frame.getContentPane().add(panel, BorderLayout.CENTER); // Add the panel to the center of the window
    }
}