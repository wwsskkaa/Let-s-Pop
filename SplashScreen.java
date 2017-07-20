

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SplashScreen extends JWindow {
	private int showtime;
	private static Timer timer;
	private static int counter = 0;
	private static JProgressBar progress = new JProgressBar();

	public SplashScreen(int d) 
	{
		showtime = d;
	}

	public void exhibitSplash() throws Exception {
		JPanel Screen = (JPanel) getContentPane();
		Screen.setBackground(new Color(255,245,204));
		Dimension sc = Toolkit.getDefaultToolkit().getScreenSize();//set to the center of the screen
		setBounds((sc.width-425)/2, (sc.height-300)/2, 425, 250);
		JLabel welcome = new JLabel(new ImageIcon("newlogo.png"));
		EmptyBorder border = new EmptyBorder(15, 0, 0, 0);
		welcome.setBorder(border);


		Image image = ImageIO.read(new File("loading.png"));
		Image scaledImage = image.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		JLabel labelpng = new JLabel(new ImageIcon(scaledImage));

		progress.setMaximum(50);
		Screen.add(progress, BorderLayout.SOUTH);
		LoadSplash();
		Screen.add(welcome, BorderLayout.NORTH);
		Screen.add(labelpng, BorderLayout.CENTER);
		Screen.setBorder(BorderFactory.createLineBorder(new Color(251,191,105), 5));
		setVisible(true);
		try {
			Thread.sleep(showtime);
		} catch (Exception e) {
		}

		setVisible(false);
	}

	public void LoadSplash() {
		ActionListener al = new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				progress.setValue(++counter);
				if (counter == 600) {
					timer.stop();
					setVisible(false);
					return;
				}
			}
		};
		timer = new Timer(100, al);
		timer.start();
	}

	public void VisiblethenDisappear() throws Exception {
		exhibitSplash();
	}
}