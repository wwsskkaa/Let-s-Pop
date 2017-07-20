import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class HelperScreen extends JWindow{
    public void setHelperScreen() throws Exception {
    JPanel Screen = (JPanel) getContentPane();
    Screen.setBackground(new Color(208,251,204));
	Dimension sc = Toolkit.getDefaultToolkit().getScreenSize();//set to the center of the screen
	setBounds((sc.width-425)/2, (sc.height-740)/2, 425, 740);

    Image welcomeimage = ImageIO.read(new File("helper.png"));
    JLabel welcome = new JLabel(new ImageIcon(welcomeimage));
    Screen.add(welcome,"Center");

    JButton close=new JButton("I see");
    close.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    });
    Screen.add(close,"South");
    }
}