import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class home extends JPanel {

	public home()  {
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout gbl = new GridBagLayout();
		
		this.setLayout(gbl);
		ImageIcon image = new ImageIcon("checking-easy-illustration.png");
		JLabel pictureL1 = new JLabel(image);
		JLabel titleL2 = new JLabel("Welcome to the Bank Account Management system");

		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0; 
		gbc.gridwidth = 4; 
		this.add(titleL2, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(pictureL1, gbc);
		
	}

}
