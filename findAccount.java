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

public class findAccount extends JPanel
{private ArrayList<BankAccount> accounts= new ArrayList<BankAccount>();
	public findAccount ()
	{

		
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout gbl = new GridBagLayout();
		
		this.setLayout(gbl);
		JLabel titleL2 = new JLabel("Finding an Account");
		JButton backB2 = new JButton("Submit");
		JTextField nameTF2 = new JTextField(40);
		JTextField numberTF2 = new JTextField(40);
		JLabel nameL2 = new JLabel("Name:");
		JLabel numberL2 = new JLabel("Account Number:");
		
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
		this.add(numberL2, gbc);
		gbc.gridx = 1; 
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(nameTF2, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		this.add(numberTF2, gbc);
		gbc.gridx = 3;
		gbc.gridy = 3; 
		gbc.gridwidth = 1;
		this.add(backB2, gbc);
		
		this.setVisible(true);
	
		backB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(!nameTF2.getText().equals("") )
				{
				
					for (int i= 0; i<accounts.size(); i++)
					{
						if (nameTF2.getText().equals(accounts.get(i).getName()))
						{int accountNumb = i;
						JOptionPane.showMessageDialog(null, "Your account number is" + accountNumb);
						}
				}
				}
					else if(isNumeric(numberTF2.getText())) 
					{
						double accountNumber = Double.parseDouble(numberTF2.getText());
						for (int i= 0; i<accounts.size(); i++)
						{ if (i==accountNumber)
							{
								JOptionPane.showMessageDialog(null, "Your account name is" + accounts.get(i).getName());
							}
						}
					}
				else 
				{
					JOptionPane.showMessageDialog(null, "Please enter the name of your account");
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

