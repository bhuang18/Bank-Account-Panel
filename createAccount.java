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

public class createAccount extends JPanel
{ private ArrayList<BankAccount> accounts= new ArrayList<BankAccount>();
	public createAccount ()
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
		JLabel titleL2 = new JLabel("Creating an Account");
		JButton checkingB2 = new JButton("Create Checking Account");
		JButton savingB2 = new JButton("Create Saving Account");
		JCheckBox checkingCB2 = new JCheckBox("Checking Account");
		JCheckBox savingCB2 = new JCheckBox("Saving Account");
		JButton backB2 = new JButton("Submit");
		JTextField nameTF2 = new JTextField(40);
		JTextField moneyTF2 = new JTextField(40);
		JLabel nameL2 = new JLabel("Name:");
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
		this.add(nameL2, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2; 
		gbc.gridwidth = 1;
		this.add(moneyL2, gbc);
		gbc.gridx = 1; 
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(nameTF2, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		this.add(moneyTF2, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3; 
		gbc.gridwidth = 1; 
		gbc.anchor  = GridBagConstraints.CENTER;
		this.add(checkingCB2, gbc);
		gbc.gridx = 2; 
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		this.add(savingCB2, gbc);
		gbc.gridx = 3;
		gbc.gridy = 3; 
		gbc.gridwidth = 1;
		this.add(backB2, gbc);
		
		this.setVisible(true);
	
		backB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!nameTF2.getText().equals("") && isNumeric(moneyTF2.getText())) {
					double money = Double.parseDouble(moneyTF2.getText());
					if(checkingCB2.isSelected()) {
						CheckingAccount ca = new CheckingAccount(nameTF2.getText().trim(), money, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTION);
						accounts.add(ca); 
						nameTF2.setText("");
						moneyTF2.setText("");
						checkingCB2.setSelected(false);
					}
					else if(savingCB2.isSelected()) {
						SavingsAccount sa = new SavingsAccount(nameTF2.getText().trim(), money, rate, MIN_BAL, MIN_BAL_FEE);
						accounts.add(sa); 
						nameTF2.setText("");
						moneyTF2.setText("");
						savingCB2.setSelected(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Please choose type of account");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Please enter a name/amount of money");
				}
			
		}
		
		});
		
		checkingCB2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(savingCB2.isSelected()) {
					savingCB2.setSelected(false);
				}
				
			}
			
		});
		
		savingCB2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(checkingCB2.isSelected()) {
					checkingCB2.setSelected(false);
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

