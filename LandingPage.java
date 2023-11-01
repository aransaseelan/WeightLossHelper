import javax.swing.*; // Import Java Swing library for creating GUI
import java.awt.*; // Import Java AWT for GUI components
import java.awt.event.ActionEvent; // Import Java AWT event for GUI components
import java.awt.event.ActionListener; // Import Java AWT event listener for GUI components

public class LandingPage {
    private JPanel landingPage; //Private keeps the variables encapsulated and hidden from other classes making it less complex
    private JLabel welcomeLabel;
    private JButton proceedButton;
    private JFrame frame;

    public LandingPage(JFrame frame) {
        this.frame = frame;
        landingPage = new JPanel();
        landingPage.setLayout(new FlowLayout(FlowLayout.LEFT));
        landingPage.setBackground(Color.pink); // Set the background color to blue
        welcomeLabel = new JLabel("WeightLossHelper");
        landingPage.add(welcomeLabel);
        proceedButton = new JButton("Proceed");
        landingPage.add(proceedButton, BorderLayout.SOUTH);

        // Add action listener to proceed button
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //If the button is clicked, the following code will be executed
                // Remove landing page and add weight calculator panel
                frame.getContentPane().removeAll();
                frame.revalidate(); // Refresh the frame
                frame.repaint(); // Repaint the frame
            }
        });
    }

    public JPanel getLandingPage() {
        return landingPage;
    }
}