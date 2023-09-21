package GUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import GeneticAlgorithm.Candidate;
import GeneticAlgorithm.UpdateScript;

public class ImageRankingGUI extends JFrame implements ActionListener 
{
    private JButton updateButton, checkoutButton;
    private JPanel imagePanel, buttonPanel;
    private ImageIcon[] candidates;
    private JButton[] imageButtons = new JButton[10];

    public ImageRankingGUI(List<Candidate> c) 
    {
        imagePanel = new JPanel();
        buttonPanel = new JPanel();

        // Initialize candidates array with placeholder images
        candidates = new ImageIcon[10];
        for (int i = 0; i < c.size(); i++) {
            BufferedImage image = c.get(i).getImg();
            candidates[i] = new ImageIcon(image);
            imageButtons[i] = new JButton(candidates[i]);
            imageButtons[i].addActionListener(this);
            imagePanel.add(imageButtons[i]);
        }


        // Initialize imageButtons array
        imageButtons = new JButton[10];

        // Create JFrame
        setTitle("Image Ranking GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create image panel
        imagePanel = new JPanel(new GridLayout(10, 1));

        // Create and add image buttons
        for (int i = 0; i < 10; i++) {
            imageButtons[i] = new JButton(candidates[i]);
            imageButtons[i].addActionListener(this);
            imagePanel.add(imageButtons[i]);
        }

        // Create button panel
        buttonPanel = new JPanel();
        updateButton = new JButton("Update");
        checkoutButton = new JButton("Checkout");
        buttonPanel.add(updateButton);
        buttonPanel.add(checkoutButton);
        updateButton.addActionListener(this);
        checkoutButton.addActionListener(this);

        // Add panels to the frame
        add(imagePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.NORTH);

        pack();
        setVisible(true);
    }

    @Override
public void actionPerformed(ActionEvent e) 
{
    if (e.getSource() == updateButton) 
    {
        //have to fix incogruency of list

    } 
    else if (e.getSource() == checkoutButton) 
    {
        // Code for checkout button action (e.g., processing rankings)
    } 
    else 
    {
        // If an image button is clicked, prompt for ranking
        for (int i = 0; i < imageButtons.length; i++) 
        {
            if (e.getSource() == imageButtons[i]) {
                String rankingInput = JOptionPane.showInputDialog("Enter ranking for image " + i + ":");
                try {
                    int ranking = Integer.parseInt(rankingInput);

                    if (ranking >= 1 && ranking < candidates.length + 1) {
                        ranking--;
                        JButton tempButton = imageButtons[i];
                        ImageIcon tempIcon = candidates[i];

                        imageButtons[i] = imageButtons[ranking];
                        candidates[i] = candidates[ranking];

                        imageButtons[ranking] = tempButton;
                        candidates[ranking] = tempIcon;

                        // Update the GUI
                        imagePanel.removeAll();
                        for (int j = 0; j < imageButtons.length; j++) {
                            imagePanel.add(imageButtons[j]);
                        }
                        imagePanel.revalidate();
                        imagePanel.repaint();
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid ranking. Please enter a number between 0 and " + (candidates.length - 1) + ".");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
                }
            }
        }
    }
}
}