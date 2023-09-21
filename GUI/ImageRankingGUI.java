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
    private ImageIcon[] candidateImages;
    private JButton[] imageButtons = new JButton[10];
    private List<Candidate> candidateList = new ArrayList<Candidate>(10);

    public ImageRankingGUI(List<Candidate> c) 
    {
        candidateList = c;
        imagePanel = new JPanel();
        buttonPanel = new JPanel();

        // Initialize candidateImages array with placeholder images
        candidateImages = new ImageIcon[10];
        /* 
        for (int i = 0; i < c.size(); i++) {
            BufferedImage image = c.get(i).getImg();
            candidateImages[i] = new ImageIcon(image);
            imageButtons[i] = new JButton(candidateImages[i]);
            imageButtons[i].addActionListener(this);
            imagePanel.add(imageButtons[i]);
        }
        */

        // Initialize imageButtons array
        imageButtons = new JButton[10];

        // Create JFrame
        setTitle("Image Ranking GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create image panel
        imagePanel = new JPanel(new GridLayout(10, 1));

        /* 
        // Create and add image buttons
        for (int i = 0; i < 10; i++) {
            imageButtons[i] = new JButton(candidateImages[i]);
            imageButtons[i].addActionListener(this);
            imagePanel.add(imageButtons[i]);
        }
        */
        updateImages();
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
            candidateList = UpdateScript.update(candidateList);
            updateImages();
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

                        if (ranking >= 1 && ranking < candidateImages.length + 1) {
                            ranking--;
                            JButton tempButton = imageButtons[i];
                            ImageIcon tempIcon = candidateImages[i];

                            imageButtons[i] = imageButtons[ranking];
                            candidateImages[i] = candidateImages[ranking];

                            imageButtons[ranking] = tempButton;
                            candidateImages[ranking] = tempIcon;

                            // Update the GUI
                            imagePanel.removeAll();
                            for (int j = 0; j < imageButtons.length; j++) {
                                imagePanel.add(imageButtons[j]);
                            }
                            imagePanel.revalidate();
                            imagePanel.repaint();
                        } else {
                            JOptionPane.showMessageDialog(this, "Invalid ranking. Please enter a number between 0 and " + (candidateImages.length - 1) + ".");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
                    }
                }
            }
        }
    }

    public void updateImages()
    {
        imagePanel.removeAll();
        for (int i = 0; i < candidateList.size(); i++) 
        {
            BufferedImage image = candidateList.get(i).getImg();
            candidateImages[i] = new ImageIcon(image);
            imageButtons[i] = new JButton(candidateImages[i]);
            imageButtons[i].addActionListener(this);
            imagePanel.add(imageButtons[i]);
        }
        imagePanel.revalidate();
        imagePanel.repaint();
    }
}