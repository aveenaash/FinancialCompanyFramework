package com.framework.finco;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.finco.framework.model.Customer;
import com.finco.framework.model.account.IAccount;
import com.framework.finco.controller.AccountController;
import com.framework.finco.controller.DepositController;
import com.framework.finco.controller.ExitController;
import com.framework.finco.controller.InterestController;
import com.framework.finco.controller.WithdrawController;
import com.framework.finco.manager.AbstractController;

/**
 * A basic JFC based application.
 */
public class ApplicationForm extends JFrame {

    static {
//        new FactoryProducer();
    }
    /**
     * **
     * init variables in the object **
     */
    public String accountnr, clientName, street, city, zip, state, accountType, clientType, amountDeposit;
    public boolean newaccount;
    protected static DefaultTableModel model;
    protected static JTable table;
    protected JScrollPane scrollPane1;

    ApplicationForm myframe = null;

    protected Object rowdata[];

    protected String selectedColumn = "acctNumber";

    public ApplicationForm() {

        myframe = this;
        setTitle("Account Application");

        setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        setSize(575, 310);
        setVisible(false);

        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0, 0, 575, 310);
        /*
         /Add five buttons on the pane 
         /for Adding personal account, Adding company account
         /Deposit, Withdraw and Exit from the system
         */
        scrollPane1 = new JScrollPane();
        model = setTableModel();
        table = new JTable(model);
        //model=table1
        rowdata = new Object[8];
        newaccount = false;

        JPanel1.add(scrollPane1);
        scrollPane1.setBounds(12, 92, 444, 160);
        scrollPane1.getViewport().add(table);
        table.setBounds(0, 0, 420, 0);

        rowdata = new Object[8];

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
        JButton_Deposit.setEnabled(false);
        JButton_Withdraw.setText("Withdraw");
        JPanel1.add(JButton_Withdraw);
        JButton_Withdraw.setEnabled(false);
        JButton_Addinterest.setBounds(448, 20, 106, 33);
        JButton_Addinterest.setText("Add interest");
        JButton_Addinterest.setEnabled(false);
        JPanel1.add(JButton_Addinterest);
        JButton_Withdraw.setBounds(468, 164, 96, 33);
        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468, 248, 96, 31);

        JButton_PerAC.setActionCommand("jbutton");

        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);

        JButton_Exit.addActionListener(new ExitController());
        JButton_PerAC.addActionListener(new AccountController());
        JButton_CompAC.addActionListener(new AccountController());
        JButton_Deposit.addActionListener(new DepositController());
        JButton_Withdraw.addActionListener(new WithdrawController());
        JButton_Addinterest.addActionListener(new InterestController());

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                try {
                    //model.send(new Message(AccountManager.ACCOUNT_SELECTED, true));
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });

        table.getTableHeader().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
//                Column index selected 0 AccountNr
//                Column index selected 1 Name
//                Column index selected 2 City
//                Column index selected 3 P/C
//                Column index selected 4 Ch/S
//                Column index selected 5 Amount
                int col = table.columnAtPoint(me.getPoint());
                if (col == 0) {
                    selectedColumn = "acctNumber";
                }else if (col == 1) {
                    selectedColumn = "name";
                }else if (col == 2) {
                    selectedColumn = "city";
                }else if (col == 3) {
                    selectedColumn = "partyType";
                } else if (col == 4) {
                    selectedColumn = "type";
                } else if (col == 5) {
                    selectedColumn = "balance";
                }
                loadTableWithData();
                String name = table.getColumnName(col);
                System.out.println("Column index selected " + col + " " + name);
            }

        });
    }

    /**
     * create Model for table
     *
     * @return
     */
    protected DefaultTableModel setTableModel() {
        model=new DefaultTableModel();
    	model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("P/C");
        model.addColumn("Ch/S");
        model.addColumn("Amount");
        return model;
    }

    public void loadTableWithData() {
        try {
            model.setRowCount(0);
            AbstractController accountManager = ApplicationFactory.getabstractControllerIntance();
            for (IAccount ia:accountManager.getAccountList()) {
                rowdata = new Object[8];
                rowdata[0] = ia.getAccountNumber();
                Customer cust = (Customer) ia.getCustomer();
                rowdata[1] = cust.getName();
                rowdata[2] = cust.getAddress().getCity();
                rowdata[3] = cust.getType();
                rowdata[4] = cust.getAccount().getType();
                rowdata[5] = ia.getBalance();
                model.addRow(rowdata);
                System.out.println("Data loaded");
            }
            //model.send(new Message(accountManager.ACCOUNT_SELECTED, false));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getAccountNo() {
        int selection = table.getSelectionModel().getMinSelectionIndex();
        String accnr = "0";
        try {
            accnr = (String) model.getValueAt(selection, 0);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return accnr;
    }

    /**
     * ***************************************************
     * The entry point for this application. Sets the Look and Feel to the
     * System Look and Feel. Creates a new JFrame1 and makes it visible.
     * ***************************************************
     */
    static public void main(String args[]) {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

            //Create a new instance of our application's frame, and make it visible.
            (ApplicationFactory.getFinancialAppFormIntance()).setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }

    protected JPanel JPanel1 = new JPanel();
    protected JButton JButton_PerAC = new JButton();
    protected JButton JButton_CompAC = new JButton();
    protected JButton JButton_Deposit = new JButton();
    protected JButton JButton_Withdraw = new JButton();
    protected JButton JButton_Addinterest = new JButton();
    protected JButton JButton_Exit = new JButton();

    protected void exitApplication() {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
        }
    }

    protected class SymWindow extends java.awt.event.WindowAdapter {

        public void windowClosing(java.awt.event.WindowEvent event) {
            Object object = event.getSource();
            if (object == ApplicationForm.this) {
                BankFrm_windowClosing(event);
            }
        }
    }

    protected void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
        // to do: code goes here.
        BankFrm_windowClosing_Interaction1(event);
    }

    protected void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }
}
