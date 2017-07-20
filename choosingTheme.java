import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.border.Border;

public class choosingTheme extends JWindow{


    public void setUpScreen() throws Exception {
    JPanel Screen = (JPanel) getContentPane();
    Screen.setBackground(new Color(255,245,204));
	Dimension sc = Toolkit.getDefaultToolkit().getScreenSize();//set to the center of the screen
	setBounds((sc.width-425)/2, (sc.height-500)/2, 425, 450);

Image welcomeimage = ImageIO.read(new File("choosetheme.png"));
    JLabel welcome = new JLabel(new ImageIcon(welcomeimage));
Screen.add(welcome, BorderLayout.NORTH);

    JPanel instruc = new JPanel(new GridLayout(2, 2));
	instruc.setBackground(new Color(255,245,204));

    Image image1 = ImageIO.read(new File("food/logo.png"));
    JLabel labelpng1 = new JLabel(new ImageIcon(image1));


    labelpng1.addMouseListener(new MouseAdapter()  
    {  
        public void mouseClicked(MouseEvent e)  
        {  
            setVisible(false);
            Letspop test = new Letspop();
            test.generatingBoard();
            test.setBoard();
        }  
            public void mouseExited(MouseEvent e) {
                labelpng1.setBackground(new Color(255,245,204));
                labelpng1.setOpaque(false);
            }

        public void mouseEntered(MouseEvent e) {
            labelpng1.setBackground(new Color(251,191,105));
            labelpng1.setOpaque(true);
            labelpng1.setToolTipText("Nom Nom");
            }
    });

    Image image2 = ImageIO.read(new File("animal/logo.png"));
    JLabel labelpng2 = new JLabel(new ImageIcon(image2));
    labelpng2.addMouseListener(new MouseAdapter()  
    {  
        public void mouseClicked(MouseEvent e)  
        {  
            setVisible(false);
            LetspopAnimal test2 = new LetspopAnimal();
            test2.generatingBoard();
            test2.setBoard();
        }  
            public void mouseExited(MouseEvent e) {
                labelpng2.setBackground(new Color(255,245,204));
                labelpng2.setOpaque(false);
            }

        public void mouseEntered(MouseEvent e) {
            labelpng2.setBackground(new Color(251,191,105));
            labelpng2.setOpaque(true);
            labelpng2.setToolTipText("Animal Kingdom");
            }
    });

    Image image3 = ImageIO.read(new File("transportation/logo.png"));
    JLabel labelpng3 = new JLabel(new ImageIcon(image3));
    labelpng3.addMouseListener(new MouseAdapter()  
    {  
        public void mouseClicked(MouseEvent e)  
        {  
            setVisible(false);
            LetspopCar test3 = new LetspopCar();
            test3.generatingBoard();
            test3.setBoard();
        }  
            public void mouseExited(MouseEvent e) {
                labelpng3.setBackground(new Color(255,245,204));
                labelpng3.setOpaque(false);
            }

        public void mouseEntered(MouseEvent e) {
            labelpng3.setBackground(new Color(251,191,105));
            labelpng3.setOpaque(true);
            labelpng3.setToolTipText("Roadtrip 2017");

            }
    });

    Image image4 = ImageIO.read(new File("sealife/logo.png"));
    JLabel labelpng4 = new JLabel(new ImageIcon(image4));
    labelpng4.addMouseListener(new MouseAdapter()  
    {  
        public void mouseClicked(MouseEvent e)  
        {  
            setVisible(false);
            LetspopSea test4 = new LetspopSea();
            test4.generatingBoard();
            test4.setBoard();
        }  
        public void mouseExited(MouseEvent e) {
            labelpng4.setBackground(new Color(255,245,204));
            labelpng4.setOpaque(false);
        }

        public void mouseEntered(MouseEvent e) {
            labelpng4.setBackground(new Color(251,191,105));
            labelpng4.setOpaque(true);
            labelpng4.setToolTipText("Under the Sea");
            }
    });

    instruc.add(labelpng1);
    instruc.add(labelpng2);
    instruc.add(labelpng3);
    instruc.add(labelpng4);
    Screen.add(instruc, BorderLayout.CENTER);
    setVisible(true);
    }
}