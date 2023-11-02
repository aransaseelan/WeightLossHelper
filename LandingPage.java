import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

public class LandingPage {
    private JPanel landingPage;
    private JLabel welcomeLabel;
    private JButton proceedButton;
    private JFrame frame;

    public LandingPage(JFrame frame) {
        

        this.frame = frame;
        landingPage = new JPanel();
        landingPage.setBackground(Color.PINK); 

        // Set layout for the panel
        GridBagLayout layout = new GridBagLayout();
        landingPage.setLayout(layout);

        // Create constraints for the layout
        GridBagConstraints gbc = new GridBagConstraints();

        // Load the image and create a label with the image
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Aran Saseelan\\Desktop\\VsCode Projects\\WeightCalculator\\Figma Icons\\iphone.png"); 
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(400, 500, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(imageIcon); 

        // Load the second image and create a label with the image
        ImageIcon imageIcon2 = new ImageIcon("C:\\Users\\Aran Saseelan\\Desktop\\VsCode Projects\\WeightCalculator\\Figma Icons\\StartToday.jpg"); 
        Image image2 = imageIcon2.getImage();
        Image scaledImage2 = image2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIcon2 = new ImageIcon(scaledImage2);
        JLabel imageLabel2 = new JLabel(imageIcon2);

        // Create and customize welcomeLabel
        welcomeLabel = new JLabel("WeightLossHelper");
        welcomeLabel.setFont(new Font("Monospaced", Font.BOLD, 30)); 
        welcomeLabel.setForeground(Color.WHITE); 

        // Create and customize goalsLabel
        JLabel goalsLabel = new JLabel("Reach your goals");
        goalsLabel.setFont(new Font("Monospaced", Font.BOLD, 70)); 
        goalsLabel.setForeground(Color.WHITE); 

        // Create and customize withWeightLossHelper
        JLabel withWeightLossHelper = new JLabel("with WeightLossHelper");
        withWeightLossHelper.setFont(new Font("Monospaced", Font.BOLD, 40)); 
        withWeightLossHelper.setForeground(Color.WHITE); 

        // Set constraints for the layout
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(0, 50, 0, 0); 
        gbc.weightx = 1; 
        gbc.weighty = 1; 
        gbc.gridx = 0; 
        gbc.gridy = 0; 

        // Add components to the panel with the constraints
        landingPage.add(welcomeLabel, gbc); 

        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 0, 0, 10);
        landingPage.add(imageLabel, gbc); 

        gbc.anchor = GridBagConstraints.CENTER;
        landingPage.add(imageLabel2, gbc); 
        gbc.insets = new Insets(200, 0, 0, 200);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 20, 200, 0); 
        landingPage.add(goalsLabel, gbc); 
        
        gbc.insets = new Insets(0, 20, 85, 0); 
        landingPage.add(withWeightLossHelper, gbc); 
        
        gbc.insets = new Insets(100, 0, 0, 0); 
        proceedButton = new JButton("Proceed");
        landingPage.add(proceedButton, gbc);

        // Add action listener to proceed button
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                // Remove landing page and add weight calculator panel
                frame.getContentPane().removeAll();
                frame.revalidate(); 
                frame.repaint(); 
            }
        });
    }

    public JPanel getLandingPage() {
        return landingPage;
    }
}