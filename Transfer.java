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

public class Transfer extends JPanel
{ private ArrayList<BankAccount> accounts= new ArrayList<BankAccount>();
	public Transfer ()
	{
		
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout gbl = new GridBagLayout();
		
		this.setLayout(gbl);
		JLabel titleL2 = new JLabel("Transfer");
		JButton backB2 = new JButton("Transfer");
		JTextField accountNumTF2 = new JTextField(40);
		JTextField moneyTF2 = new JTextField(40);
		JTextField accountNumTF3 = new JTextField(40);
		JLabel AccountNumL2 = new JLabel("Account Number (From):");
		JLabel AccountNumL3 = new JLabel("Account Number(To):");
		JLabel moneyL2 = new JLabel("Money:");
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0; 
		gbc.gridwidth = 4; 
		this.add(titleL2, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		this.add(AccountNumL2, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		this.add(AccountNumL3, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2; 
		gbc.gridwidth = 1;
		this.add(moneyL2, gbc);
		gbc.gridx = 1; 
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(accountNumTF2, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3; 
		gbc.gridwidth = 1; 
		gbc.anchor  = GridBagConstraints.WEST;
		this.add(accountNumTF3, gbc);
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
			public void actionPerformed(ActionEvent arg0) {
				if(!accountNumTF2.getText().equals("") && isNumeric(moneyTF2.getText())&&isNumeric(accountNumTF3.getText())) {
					double money = Double.parseDouble(moneyTF2.getText());
					double accountNum = Double.parseDouble(accountNumTF2.getText());
					double accountNum2 = Double.parseDouble(accountNumTF3.getText());
					accounts.get((int)accountNum).transfer(accounts.get((int)accountNum2),money);
					}
					
				else {
					JOptionPane.showMessageDialog(null, "Please enter an account number/amount of money");
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
