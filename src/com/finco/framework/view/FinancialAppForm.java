package com.finco.framework.view;

import java.awt.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import com.finco.framework.controller.DepositController;
import com.finco.framework.support.AppCreator;

/**
 * A basic JFC based application.
 */
public class FinancialAppForm extends javax.swing.JFrame {
	/****
	 * init variables in the object
	 ****/
	public String accountnr;
	public String clientName;
	public String street;
	public String city;
	public String zip;
	public String state;
	public String accountType;
	public String clientType;

	public String amountDeposit;
	public boolean newaccount;
	private DefaultTableModel model;
	private JTable JTable1;
	private JScrollPane JScrollPane1;
	static FinancialAppForm myframe;
	private Object rowdata[];

	public FinancialAppForm() {
		myframe = this;

		setTitle("Financial Application.");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(575, 310);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0, 0, 575, 310);
		/*
		 * /Add five buttons on the pane /for Adding personal account, Adding
		 * company account /Deposit, Withdraw and Exit from the system
		 */
		JScrollPane1 = new JScrollPane();

		model = setTableModel();
		JTable1 = new JTable(model);
		newaccount = false;

		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12, 92, 444, 160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);

		createButtons();
		JButton_PerAC.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		
		JButton_Exit.addActionListener(new ExitController());
		JButton_PerAC.addActionListener(new PersonalAccountController());
		JButton_CompAC.addActionListener(new DepositController());
		JButton_Deposit.addActionListener(new DepositController());
		JButton_Withdraw.addActionListener(new DepositController());

	}
	

	public String getAccountnr() {
		return accountnr;
	}


	public void setAccountnr(String accountnr) {
		this.accountnr = accountnr;
	}


	public void createButtons() {
		JButton_PerAC.setText("Add personal account");
		JPanel1.add(JButton_PerAC);
		JButton_PerAC.setBounds(24, 20, 192, 33);
		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		JPanel1.add(JButton_CompAC);
		JButton_CompAC.setBounds(240, 20, 192, 33);
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468, 104, 96, 33);
		JButton_Withdraw.setText("Withdraw");
		JPanel1.add(JButton_Withdraw);
		JButton_Withdraw.setBounds(468, 164, 96, 33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468, 248, 96, 31);
	}

	public static FinancialAppForm getInstance() {
        if (myframe == null) {
        	myframe = new FinancialAppForm();
            AppCreator.setFinancialAppForm(myframe);
        }
        return myframe;
    }
	
	public DefaultTableModel setTableModel() {
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		model.addColumn("AccountNr");
		model.addColumn("Name");
		model.addColumn("City");
		model.addColumn("P/C");
		model.addColumn("Ch/S");
		model.addColumn("Amount");
		rowdata = new Object[8];
		return model;
	}
	
	public void loadTableWithData() {
//        try {
//            model.setRowCount(0);
//            AccountManager accountManager = ClassicSingleton.getInstanceAccountManager();
//            for (Iterator<AAccount> it = accountManager.getAccountList().getSortedIterator(new AccountComparator(selectedColumn)); it.hasNext();) {
//                IAccount iAccount = it.next();
//                rowdata = new Object[8];
//                rowdata[0] = iAccount.getAcctNumber();
//                AParty aParty = (AParty) iAccount.getParty();
//                rowdata[1] = aParty.getName();
//                rowdata[2] = aParty.getCity();
//                rowdata[3] = aParty.getType();
//                rowdata[4] = iAccount.getType();
//                rowdata[5] = iAccount.getCurrentBalance();
//                model.addRow(rowdata);
//            }
//            model.send(new Message(accountManager.ACCOUNT_SELECTED, false));
//        } catch (Exception ex) {
//            Logger.getLogger(AccountFrm.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

	/*****************************************************
	 * The entry point for this application. Sets the Look and Feel to the
	 * System Look and Feel. Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	static public void main(String args[]) {
		try {
			// Add the following code if you want the Look and Feel
			// to be set to the Look and Feel of the native system.

			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}

			// Create a new instance of our application's frame, and make it
			// visible.
			(new FinancialAppForm()).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	protected javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	protected javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	protected javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Exit = new javax.swing.JButton();

	void exitApplication() {
		try {
			this.setVisible(false); // hide the Frame
			this.dispose(); // free the system resources
			System.exit(0); // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object == FinancialAppForm.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
		// to do: code goes here.

		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	// When the Exit button is pressed this code gets executed
	// this will exit from the system
	void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}



}
