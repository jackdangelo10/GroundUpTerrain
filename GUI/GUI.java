package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI
{
    private JFrame f = null;
    private JPanel leftArea;
    private JPanel rightArea;
    private JPanel rankingArea;
    private ImagePanel imageArea;

    GUI()
    {

        //initialize the frame
        f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("");
		f.setBackground(Color.WHITE);
        f.setVisible(true);
        f.setSize(500,500);
        f.setResizable(false);

        //set up buttons and add Button action listeners
        leftArea = new JPanel();
        leftArea.setBackground(Color.GRAY);
        rightArea = new JPanel();
        rightArea.setBackground(Color.GRAY);


        ButtonListener b = new ButtonListener();
        JButton leftButton = new JButton("<");
        JButton rightButton = new JButton(">");
        leftButton.addActionListener(b);
        rightButton.addActionListener(b);
        leftButton.setActionCommand("l");
        rightButton.setActionCommand("r");



        //formatting buttons in button area
        rightArea.add(rightButton);
        leftArea.add(leftButton);

        f.add(rightArea, BorderLayout.EAST);
        f.add(leftArea, BorderLayout.WEST);

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



        imageArea = new ImagePanel(null);
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
        }

        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            if(img != null)
            {
                g.drawImage(img, 0, 0, this);
            }
        }
    }

    public class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            
        }
    }
}
