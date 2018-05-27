import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class removeAccount extends JPanel
{ 
	private ArrayList<BankAccount> accounts= new ArrayList<BankAccount>();
	public removeAccount ()
	{
		
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout gbl = new GridBagLayout();
		
		this.setLayout(gbl);
		JLabel titleL2 = new JLabel("Removing an Account");
		JButton backB2 = new JButton("Submit");
		JTextField nameTF2 = new JTextField(40);
		JTextField accountNumTF2 = new JTextField(40);
		JLabel nameL2 = new JLabel("Name:");
		JLabel accountNumL2 = new JLabel("Account Number:");
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0; 
		gbc.gridwidth = 4; 
		this.add(titleL2, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		this.add(nameL2, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2; 
		gbc.gridwidth = 1;
		this.add(accountNumL2, gbc);
		gbc.gridx = 1; 
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(nameTF2, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		this.add(accountNumTF2, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3; 
		gbc.gridwidth = 1; 
		gbc.anchor  = GridBagConstraints.CENTER;
		this.add(backB2, gbc);
		
		this.setVisible(true);
	
		backB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!nameTF2.getText().equals("") && isNumeric(accountNumTF2.getText())) {
					double accountNum = Double.parseDouble(accountNumTF2.getText());
					accounts.remove(accountNumTF2.getText()); 
						nameTF2.setText("");
						accountNumTF2.setText("");
						
					}
				
				else {
					JOptionPane.showMessageDialog(null, "Please enter a name/account number");
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

