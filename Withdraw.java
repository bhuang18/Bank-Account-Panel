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

public class Withdraw extends JPanel
{ private ArrayList<BankAccount> accounts= new ArrayList<BankAccount>();
	public Withdraw ()
	{
		double OVER_DRAFT_FEE = 15; 
		double rate = 0.0025; 
		double TRANSACTION_FEE = 1.5; 
		double MIN_BAL = 300;
		double MIN_BAL_FEE = 10;
		int FREE_TRANSACTION = 10;
		
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout gbl = new GridBagLayout();
		
		this.setLayout(gbl);
		JLabel titleL2 = new JLabel("Withdraw");
		JButton backB2 = new JButton("Withdraw");
		JTextField accountNumTF2 = new JTextField(40);
		JTextField moneyTF2 = new JTextField(40);
		JLabel AccountNumL2 = new JLabel("Account Number:");
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
		gbc.gridy = 2; 
		gbc.gridwidth = 1;
		this.add(moneyL2, gbc);
		gbc.gridx = 1; 
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(accountNumTF2, gbc);
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
				if(!accountNumTF2.getText().equals("") && isNumeric(moneyTF2.getText())) {
					double money = Double.parseDouble(moneyTF2.getText());
					double accountNum = Double.parseDouble(accountNumTF2.getText());
					accounts.get((int)accountNum).withdraw(money);
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

