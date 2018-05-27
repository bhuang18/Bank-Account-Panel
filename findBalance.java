import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class findBalance extends JPanel
{private ArrayList<BankAccount> accounts= new ArrayList<BankAccount>();
	public findBalance ()
	{

		
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout gbl = new GridBagLayout();
		
		this.setLayout(gbl);
		JLabel titleL2 = new JLabel("Finding your Balance");
		JButton backB2 = new JButton("Submit");
		JTextField numTF2 = new JTextField(40);
		JTextField moneyTF2 = new JTextField(40);
		JLabel numL2 = new JLabel("Account Number:");
		JLabel moneyL2 = new JLabel("Balance:");
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0; 
		gbc.gridwidth = 4; 
		this.add(titleL2, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		this.add(numL2, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2; 
		gbc.gridwidth = 1;
		this.add(moneyL2, gbc);
		gbc.gridx = 1; 
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(numTF2, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		this.add(moneyTF2, gbc);
		gbc.gridx = 3;
		gbc.gridy = 3; 
		gbc.gridwidth = 1;
		this.add(backB2, gbc);
		
		this.setVisible(true);
		backB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(!isNumeric(numTF2.getText()))
				{
					double accountNumber = Double.parseDouble(numTF2.getText());
					for (int i= 0; i<accounts.size(); i++)
					{
						
						if (i==accountNumber)
							JOptionPane.showMessageDialog(null, "Your Balance is" + accounts.get(i).getBalance());
							moneyTF2.setText(""+accounts.get(i).getBalance());
						}
				}
				
				else 
				{
					JOptionPane.showMessageDialog(null, "Please enter your account Number");
				}
			
			}
		});	
		
		
		
		
		
	}



	private static boolean isNumeric(String str) {
		try {
			double number = Double.parseDouble(str);
			if (number >= 0) {
				return true;
			}
			return false;
		} catch (IllegalArgumentException ex) {
			return false;
		}
	}



	}

