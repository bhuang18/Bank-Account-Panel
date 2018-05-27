import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class JFramePanel extends JFrame
{
	private JPanel createAccountVar;
	private JPanel removeAccountVar;
	private JPanel findAccountVar;
	
	private JPanel depositVar;
	private JPanel withdrawVar;
	private JPanel transferVar;
	private JPanel getBalanceVar;
	
	private JPanel homeVar;
	private ArrayList<BankAccount> accounts;
	
	public JFramePanel()
	{
		 accounts= new ArrayList<BankAccount>();
		JMenuBar mBar = new JMenuBar();
		JMenu account= new JMenu("Account");
		JMenu transactions= new JMenu("Transactions");
		JMenu home= new JMenu("Home");
		JMenuItem createAccount = new JMenuItem("Create Account");
		JMenuItem removeAccount = new JMenuItem("Remove Account");
		JMenuItem findAccount = new JMenuItem("Find Accounts");
		
		JMenuItem deposit = new JMenuItem("Deposit");
		JMenuItem withdraw= new JMenuItem("Withdraw");
		JMenuItem transfer = new JMenuItem("Transfer");
		JMenuItem getBalance = new JMenuItem("Get Balance");
		JMenuItem returnHome = new JMenuItem("Return Home");
		
		account.add(createAccount);
		account.add(removeAccount);
		account.add(findAccount);
		transactions.add(deposit);
		transactions.add(withdraw);
		transactions.add(transfer);
		transactions.add(getBalance);
		home.add(returnHome);
		mBar.add(account);
		mBar.add(transactions);
		mBar.add(home);
		this.setJMenuBar(mBar);
		
		CardLayout cl = new CardLayout();
		JPanel overall = new JPanel();
		overall.setLayout(cl);
		 createAccountVar = new createAccount();
		overall.add(createAccountVar, "createAccountVar");
		add(overall);
		setBounds(300,300,400,400);
		
		homeVar = new home();
		overall.add(homeVar, "homeVar");
		setBounds(300,300,400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		cl.show(overall, "homeVar");
		
		removeAccountVar = new removeAccount();
		overall.add(removeAccountVar, "removeAccountVar");
		setBounds(300,300,400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		findAccountVar = new findAccount();
		overall.add(findAccountVar, "findAccountVar");
		setBounds(300,300,400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		depositVar = new Deposit();
		overall.add(depositVar, "depositVar");
		setBounds(300,300,400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		withdrawVar = new Withdraw();
		overall.add(withdrawVar, "withdrawVar");
		setBounds(300,300,400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		transferVar = new Transfer();
		overall.add(transferVar, "transferVar");
		setBounds(300,300,400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getBalanceVar = new findBalance();
		overall.add(getBalanceVar, "getBalanceVar");
		setBounds(300,300,400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createAccount.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	            cl.show(overall, "createAccountVar");
	        }
	        });
		
		returnHome.addActionListener(new ActionListener(){ 
	        public void actionPerformed(ActionEvent e){
	            cl.show(overall, "homeVar");	
}
	 });
	
		
		removeAccount.addActionListener(new ActionListener(){ 
		        public void actionPerformed(ActionEvent e){
		            cl.show(overall, "removeAccountVar");	
	}
		 });
		
		findAccount.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent e){
		            cl.show(overall, "findAccountVar");
		        }
		        });
	
		deposit.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	            cl.show(overall, "depositVar");
	        }
	        });
		withdraw.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	            cl.show(overall, "withdrawVar");
	        }
	        });
		transfer.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	            cl.show(overall, "transferVar");
	        }
	        });
		getBalance.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	            cl.show(overall, "getBalanceVar");
	        }
	        });
			
	}

	public static void main(String[] args)
	{
		JFramePanel saari = new JFramePanel();
		

	}
	
}
