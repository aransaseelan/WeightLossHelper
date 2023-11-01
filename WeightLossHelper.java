import javax.swing.*; // Import Java Swing library for creating GUI

public class WeightLossHelper{
    public static void main(String[] args) {
        JFrame frame = new JFrame("WeightLossHelper");
        LandingPage landingPage = new LandingPage(frame);
        frame.add(landingPage.getLandingPage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Makes the X button work
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Set the window to full screen of the monitor
        frame.setVisible(true); // Make the frame visible
    }

    public static double weight_To_Pounds(double weight_pounds){
        double conversion_kgs_to_pounds =  0.45359237;
        double weight_kgs = weight_pounds*conversion_kgs_to_pounds;
        return weight_kgs;
    }
}