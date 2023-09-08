package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import GeneticAlgorithm.Candidate;
import GeneticAlgorithm.UpdateScript;

public class GUI
{
    private JFrame f = null;
    private JPanel leftArea;
    private JPanel rightArea;
    private JPanel rankingArea;
    private JPanel updateArea;
    private ImagePanel imageArea;
    private int currentIndex = 0;

    private List<Candidate> candidates = null;
    private List<Boolean> ranked = null;

    //update button will make images "die", or be removed from list
    //will also have a reproduction chance between higher ranked candidates

    public GUI(List<Candidate> c)
    {

        //initialize the frame
        candidates = c;
        System.out.println(c.size());
        ranked = new ArrayList<Boolean>();
        for(int i = 0; i < c.size(); i++)
        {
            ranked.add(false);
        }

        f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBackground(Color.WHITE);
        f.setSize(500,500);
        f.setResizable(false);

        //set up buttons and add Button action listeners
        leftArea = new JPanel();
        leftArea.setBackground(Color.GRAY);
        rightArea = new JPanel();
        rightArea.setBackground(Color.GRAY);
        updateArea = new JPanel();
        updateArea.setBackground(Color.GRAY);


        ButtonListener b = new ButtonListener();
        JButton leftButton = new JButton("<");
        JButton rightButton = new JButton(">");
        leftButton.addActionListener(b);
        rightButton.addActionListener(b);
        leftButton.setActionCommand("<");
        rightButton.setActionCommand(">");

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(b);
        updateButton.setActionCommand("u");


        //formatting buttons in button area
        rightArea.add(rightButton);
        leftArea.add(leftButton);
        updateArea.add(updateButton);

        f.add(rightArea, BorderLayout.EAST);
        f.add(leftArea, BorderLayout.WEST);
        f.add(updateArea, BorderLayout.NORTH);

        //create area for displaying ranking choices
        rankingArea = new JPanel();
        rankingArea.setBackground(Color.GRAY);
        rankingArea.setLayout(new GridLayout(1,10));
        for(int i = 0; i < 10; i++)
        {
            JButton ranking = new JButton("" + (i + 1));
            ranking.addActionListener(b);
            ranking.setActionCommand("" + (i + 1));
            rankingArea.add(ranking);
        }


        f.add(rankingArea, BorderLayout.SOUTH);
        f.setVisible(true);



        imageArea = new ImagePanel(candidates.get(0).getImg());
        imageArea.repaint();
        f.add(imageArea, BorderLayout.CENTER);
    
    }

    /**
     * @return imageDisplay panel object
     */
    public ImagePanel getImageDisplay()
    {
        return imageArea;
    }

    //class is meant to manage and update the view of the central play area
    public class ImagePanel extends JPanel
    {
        private BufferedImage img;

        public ImagePanel(BufferedImage image)
        {
            img = image;
            this.repaint();
        }

        public void setImage(BufferedImage image)
        {
            img = image;
            this.repaint();
        }

        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            if(img != null)
            {
                g.drawImage(img, 0, 0, this);
                g.setColor(Color.PINK);
                g.drawString("Ranked: " + ranked.get(currentIndex), 10, 
                    candidates.get(currentIndex).getParameters().getHeight() + 20);
                g.drawString("Ranking: " + candidates.get(currentIndex).getFitness(), 10, 
                    candidates.get(currentIndex).getParameters().getHeight() + 40);
            }
            else
            {
                System.out.println("no image?");
            }
            
        }
    }

    public class ButtonListener implements ActionListener
    {

        int rankedCount = 0;
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String command = e.getActionCommand();
            switch(command)
            {
                case "<":
                    currentIndex = (currentIndex - 1 + candidates.size()) % candidates.size();
                    break;
                case ">":
                    currentIndex = (currentIndex + 1) % candidates.size();
                    break;
                case "u":
                    if(rankedCount >= 10)
                    {
                        candidates = UpdateScript.update(candidates);
                        for(int i = 0; i < ranked.size(); i++)
                        {
                            ranked.set(i, false);
                        }
                        rankedCount = 0;
                        imageArea.repaint();
                    }
                    else
                    {
                        System.out.println("Not all images have been ranked");
                    }
                    
                    break;
                default:
                    try
                    {
                        int rank = Integer.parseInt(command);
                        candidates.get(currentIndex).setFitness(rank);
                        ranked.set(currentIndex, true);
                        rankedCount++;
                    }
                    catch(NumberFormatException exception)
                    {
                        System.out.println("Command not recognized");
                    }
                    break;
            }

            BufferedImage img = candidates.get(currentIndex).getImg();
            imageArea.setImage(img);
            imageArea.repaint();
        }
    }
}
