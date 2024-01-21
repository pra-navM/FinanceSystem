import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;


public class Main extends JPanel implements ActionListener {

    public static JTextField TFname = new JTextField();
    public JTextField TFsavingChange = new JTextField();
    public JTextField TFcheckingChange = new JTextField();
    public JTextField TFdebtChange = new JTextField();
    public JTextField TFstockNum = new JTextField();
    public JTextField TFstockValue = new JTextField();
    public static JTextField TFSSN = new JTextField();
    public static JTextField TFchecking = new JTextField();
    public static JTextField TFsavings = new JTextField();
    public static JTextField TFdebt = new JTextField();

    public static HashSet <Customer> customerHashSet = new HashSet<>();
    public static JComboBox<Customer> JCcustomerName = new JComboBox<>();


    public JTextField TFnewStockValue,TFnewStockName,TFnewStockCap;
    public static JTextArea TAsharesAdd;
    public static Font f = new Font(Font.MONOSPACED, Font.BOLD, 12);
    public int netAsset=123000;
    public int checking=10000;
    public int saving=10000;
    public int debt=10000;
    public static ArrayList<Customer>customerArrayList = new ArrayList<>();


    public Main() throws FileNotFoundException {
        ArrayList<Customer>customerArrayList = new ArrayList<>();

        Border line = new LineBorder(Color.lightGray, 1);

        JFrame frame = new JFrame("ANP Banking Services");
        frame.setResizable(false);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1050, 570);
        frame.setLayout(new FlowLayout());
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveToFile();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

        JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT));
        left.setPreferredSize(new Dimension(250, 325));
        left.setFont(f);
        left.setBackground(Color.lightGray);
        left.setBorder(line);
        frame.add(left);

        JPanel center = new JPanel(new FlowLayout(FlowLayout.LEFT));
        center.setPreferredSize(new Dimension(500, 325));
        center.setFont(f);
        center.setBackground(Color.lightGray);
        center.setBorder(line);
        frame.add(center);

        JPanel right = new JPanel();
        right.setPreferredSize(new Dimension(250, 325));
        right.setBackground(Color.lightGray);
        right.setBorder(line);
        frame.add(right);

        JPanel bottomLeft = new JPanel();
        bottomLeft.setPreferredSize(new Dimension(250, 175));
        bottomLeft.setBackground(Color.lightGray);
        bottomLeft.setBorder(line);
        frame.add(bottomLeft);

        JPanel bottomCenter = new JPanel();
        bottomCenter.setPreferredSize(new Dimension(500, 175));
        bottomCenter.setBackground(Color.lightGray);
        bottomCenter.setBorder(line);
        frame.add(bottomCenter);

        JPanel bottomRight = new JPanel();
        bottomRight.setPreferredSize(new Dimension(250, 175));
        bottomRight.setBackground(Color.lightGray);
        bottomRight.setBorder(line);
        frame.add(bottomRight);

        JLabel customerSort1 = new JLabel("Customer Sort:");
        customerSort1.setSize(120, 25);
        customerSort1.setFont(f);
        left.add(customerSort1);

        JComboBox<String> customerSort2 = new JComboBox<>();
        customerSort2.setSize(120, 25);
        customerSort2.setFont(f);
        customerSort2.addItem("Name");
        customerSort2.addItem("Net Asset");
        customerSort2.addItem("Checking");
        customerSort2.addItem("Saving");
        customerSort2.addItem("Debt");
        left.add(customerSort2);

        JButton addCustomer = new JButton();
        addCustomer.setMargin(new Insets(0, 10, 0, 10));
        addCustomer.setText("Add Customer");
        addCustomer.setFont(f);
        addCustomer.setActionCommand("addCustomer");
        left.add(addCustomer);


        JButton removeCustomer = new JButton();
        removeCustomer.setMargin(new Insets(0, 4, 0, 4));
        removeCustomer.setText("Remove Customer");
        removeCustomer.setFont(f);
        //removeCustomer.setActionCommand("removeCustomer");
        left.add(removeCustomer);
        
        
        
        JLabel JLSSN = new JLabel("SSN:");
        JLSSN.setFont(f);
        left.add(JLSSN);

        TFSSN.setColumns(24);
        TFSSN.setFont(f);
        left.add(TFSSN);


        JLabel JLname = new JLabel("Name:");
        JLname.setFont(f);
        left.add(JLname);

        TFname.setFont(f);
        TFname.setColumns(23);
        left.add(TFname);


        JLabel JLchecking = new JLabel("Checking:");
        JLchecking.setFont(f);
        left.add(JLchecking);

        TFchecking.setFont(f);
        TFchecking.setColumns(19);
        left.add(TFchecking);


        JLabel JLsavings = new JLabel("Savings:");
        JLsavings.setFont(f);
        left.add(JLsavings);

        TFsavings.setFont(f);
        TFsavings.setColumns(20);
        left.add(TFsavings);


        JLabel JLdebt = new JLabel("Debt:");
        JLdebt.setFont(f);
        left.add(JLdebt);

        TFdebt.setFont(f);
        TFdebt.setColumns(23);
        left.add(TFdebt);

        JButton addShares = new JButton();
        addShares.setMargin(new Insets(0, 78, 0, 79));
        addShares.setText("Add Shares");
        addShares.setFont(f);
        addShares.setActionCommand("addShares");
        left.add(addShares);

        JButton clearShares = new JButton();
        clearShares.setFont(f);
        clearShares.setMargin(new Insets(1, 74, 1, 75));
        clearShares.setText("Clear Shares");
        clearShares.setActionCommand("clearShares");
        left.add(clearShares);


        JLabel JLstockName = new JLabel("Name:");
        JLstockName.setFont(f);
        left.add(JLstockName);

        JComboBox<String> stockName = new JComboBox<>();
        stockName.setFont(f);
        stockName.setSize(120, 5);
        stockName.addItem("TSLA");
        stockName.addItem("AAPL");
        stockName.addItem("AMD");// replace with data
        left.add(stockName);


        JLabel JLshareType = new JLabel("Type:");
        JLshareType.setFont(f);
        left.add(JLshareType);

        JComboBox<String> shareType = new JComboBox<>();
        shareType.setFont(f);
        shareType.setSize(120, 5);
        shareType.addItem("Short");
        shareType.addItem("Stock");
        left.add(shareType);


        JLabel JLnumOfShares = new JLabel("# of Shares:");
        JLnumOfShares.setFont(f);
        left.add(JLnumOfShares);

        JTextField TFnumOfShares = new JTextField();
        TFnumOfShares.setFont(f);
        TFnumOfShares.setColumns(13);
        left.add(TFnumOfShares);

        JLabel JLcustomerName = new JLabel("Customer Name:");
        loadCustomers();
        JLcustomerName.setFont(f);
        center.add(JLcustomerName);


        JCcustomerName.setFont(f);
        JCcustomerName.setRenderer(new CustomComboBoxRenderer());
        JCcustomerName.setPreferredSize(new Dimension(300,20));

        center.add(JCcustomerName);


        JLabel stocksAndShorts = new JLabel("Stocks and Shorts:");
        stocksAndShorts.setFont(f);
        center.add(stocksAndShorts);

        JLabel headings = new JLabel("Name                   Type     Shares     Price     Total Value");
        headings.setFont(f);
        center.add(headings);

        JTextArea TAmainwindow = new JTextArea();
        TAmainwindow.setLineWrap(true);
        TAmainwindow.setFont(f);
        TAmainwindow.setRows(10);
        TAmainwindow.setColumns(65);
        TAmainwindow.setEditable(false);
        TAmainwindow.append(String.format("%-23s%-9s%-11s$%-10s$%s%n","AMZN","Short","100","$200","$20000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s$%-10s$%s%n","AMD","Stock","1","$3000","$3000"));

        center.add(TAmainwindow);

        JLabel editAllStocks = new JLabel("         Edit All Stocks         ");
        editAllStocks.setFont(f);
        right.add(editAllStocks);

        JLabel JLallStocks = new JLabel("Stocks:           ");
        JLallStocks.setFont(f);
        right.add(JLallStocks);

        JComboBox<String> JCallStocks = new JComboBox<>();
        JCallStocks.setFont(f);
        JCallStocks.addItem("TSLA");
        JCallStocks.addItem("AMZN");
        JCallStocks.addItem("AMD");
        right.add(JCallStocks);

        JLabel JLstockValue = new JLabel("Value: $");
        JLstockValue.setFont(f);
        right.add(JLstockValue);

        TFstockValue = new JTextField();
        TFstockValue.setColumns(17);
        right.add(TFstockValue);

        JButton JBstockValue = new JButton("Change Value");
        JBstockValue.setFont(f);
        JBstockValue.setMargin(new Insets(0,70,0,70));
        JBstockValue.setActionCommand("changeValue");
        right.add(JBstockValue);

        JLabel JLstockCap = new JLabel("Cap:");
        JLstockCap.setFont(f);
        right.add(JLstockCap);

        JTextField TFstockCap = new JTextField("1000");
        TFstockCap.setColumns(19);
        right.add(TFstockCap);

        JButton JBstockCap = new JButton("Change Cap");
        JBstockCap.setFont(f);
        JBstockCap.setMargin(new Insets(0,70,0,70));
        JBstockCap.setActionCommand("changeCap");
        right.add(JBstockCap);

        JButton JBstockReset = new JButton("Reset Values");
        JBstockReset.setFont(f);
        JBstockReset.setMargin(new Insets(0,63,0,63));
        JBstockReset.setActionCommand("resetStock");
        right.add(JBstockReset);

        JLabel JLstockOwned = new JLabel("# of Stocks Bought:");
        JLstockCap.setFont(f);
        right.add(JLstockOwned);

        JTextField TFstockOwned = new JTextField("             300");
        right.add(TFstockOwned);

        JLabel JLshortOwned = new JLabel("# of Shorts Held:");
        JLstockCap.setFont(f);
        right.add(JLshortOwned);

        JTextField TFshortOwned = new JTextField("              300");
        right.add(TFshortOwned);

        JLabel JLsharesAdd = new JLabel("Shares to Add      ");
        JLsharesAdd.setFont(f);
        bottomLeft.add(JLsharesAdd);

        JLabel JLsharesTitles = new JLabel("Name   Type    Number           ");
        JLsharesTitles.setFont(f);
        bottomLeft.add(JLsharesTitles);

        TAsharesAdd = new JTextArea();
        TAsharesAdd.setColumns(23);
        TAsharesAdd.setFont(f);
        TAsharesAdd.append("TSLA   Stock   300               \n");
        TAsharesAdd.append("AMD    Short   300\n");
        bottomLeft.add(TAsharesAdd);

        JLabel JLcheckingChange = new JLabel("Checking:");
        JLcheckingChange.setFont(f);
        bottomCenter.add(JLcheckingChange);

        TFcheckingChange = new JTextField(checking);
        TFcheckingChange.setColumns(16);
        bottomCenter.add(TFcheckingChange);

        JButton JBcheckingChange = new JButton("Change Checking");
        JBcheckingChange.setFont(f);
        JBcheckingChange.setMargin(new Insets(0,63,0,63));
        JBcheckingChange.setActionCommand("changeCheck");
        bottomCenter.add(JBcheckingChange);

        JLabel JLsavingChange = new JLabel("Saving: ");
        JLsavingChange.setFont(f);
        bottomCenter.add(JLsavingChange);

        TFsavingChange = new JTextField(saving);
        TFsavingChange.setColumns(18);
        bottomCenter.add(TFsavingChange);

        JButton JBsavingChange = new JButton("Change Saving");
        JBsavingChange.setFont(f);
        JBsavingChange.setMargin(new Insets(0,63,0,63));
        JBsavingChange.setActionCommand("changeSaving");
        bottomCenter.add(JBsavingChange);

        JLabel JLdebtChange = new JLabel("Debt");
        JLdebtChange.setFont(f);
        bottomCenter.add(JLdebtChange);

        TFdebtChange = new JTextField(debt);
        TFdebtChange.setColumns(23);
        bottomCenter.add(TFdebtChange);

        JButton JBdebtChange = new JButton("Change Debt");
        JBdebtChange.setMargin(new Insets(0,63,0,63));
        JBdebtChange.setFont(f);
        JBdebtChange.setActionCommand("changeDebt");
        bottomCenter.add(JBdebtChange);

        JLabel JLstockChange = new JLabel("Stock: ");
        JLstockChange.setFont(f);
        bottomCenter.add(JLstockChange);

        JComboBox<String> JCstockChange = new JComboBox<>();
        JCstockChange.setFont(f);
        JCstockChange.setSize(120, 5);
        JCstockChange.addItem("TSLA");
        JCstockChange.addItem("AAPL");
        JCstockChange.addItem("AMD");// replace with data
        bottomCenter.add(JCstockChange);

        JLabel JLstockNum = new JLabel("Share Number: ");
        JLstockNum.setFont(f);
        bottomCenter.add(JLstockNum);

        TFstockNum = new JTextField();
        TFstockNum.setColumns(8);
        bottomCenter.add(TFstockNum);

        JButton JBstockNum = new JButton ("Change Share Number");
        JBstockNum.setFont(f);
        JBstockNum.setActionCommand("changeShare");
        bottomCenter.add(JBstockNum);

        JButton JBcustReset = new JButton("Reset Values");
        JBcustReset.setFont(f);
        JBcustReset.setMargin(new Insets(10,100,10,100));
        JBcustReset.setActionCommand("resetCust");
        bottomCenter.add(JBcustReset);

        JLabel JLnetAsset = new JLabel("Total Asset: $" + netAsset);
        JLnetAsset.setFont(f);
        bottomCenter.add(JLnetAsset);

        JButton JBaddStock = new JButton("Add New Stock");
        JBaddStock.setMargin(new Insets(0,63,0,63));
        JBaddStock.setFont(f);
        JBaddStock.setActionCommand("addStock");
        bottomRight.add(JBaddStock);

        JLabel JLnewStockName = new JLabel("Name: ");
        JLnewStockName.setFont(f);
        bottomRight.add(JLnewStockName);

        TFnewStockName = new JTextField();
        TFnewStockName.setColumns(15);
        bottomRight.add(TFnewStockName);

        JLabel JLnewStockValue = new JLabel("Value: ");
        JLnewStockValue.setFont(f);
        bottomRight.add(JLnewStockValue);

        TFnewStockValue = new JTextField();
        TFnewStockValue.setColumns(15);
        bottomRight.add(TFnewStockValue);

        JLabel JLnewStockCap = new JLabel("Cap: ");
        JLnewStockCap.setFont(f);
        bottomRight.add(JLnewStockCap);

        TFnewStockCap = new JTextField();
        TFnewStockCap.setColumns(15);
        bottomRight.add(TFnewStockCap);

        JButton JBstockHistory = new JButton("View Stock History");
        JBstockHistory.setMargin(new Insets(0,63,0,63));
        JBstockHistory.setFont(f);
        JBstockHistory.setActionCommand("Stock History");
        bottomRight.add(JBstockHistory);

        JButton JBaddFile = new JButton("Add File");
        JBaddFile.setMargin(new Insets(0,63,0,63));
        JBaddFile.setFont(f);
        JBaddFile.setActionCommand("addFile");
        bottomRight.add(JBaddFile);


        addCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCustomer();
            }
        });

        removeCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeCustomer();
            }
        });

        loadCustomers();

        frame.setVisible(true);
    }
    public static void main(String[] args) throws FileNotFoundException {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String in = e.getActionCommand();
        if(in.equals("changeChecking")) {
            checking =Integer.parseInt(TFcheckingChange.getText());
        }
        if(in.equals("changeDebt")){
            debt = Integer.parseInt(TFdebtChange.getText());
        }
        if(in.equals("addCustomer"))
        {
        }
        netAsset = saving + checking + 23000 - debt;
        try {
            new Main();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void addStock(JComboBox C)
    {}

    public static void saveToFile() //save ArrayList to a file
    {
        try {
            FileOutputStream fileOut = new FileOutputStream("serCustomerSave.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(customerArrayList);
            out.close();
            fileOut.close();

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

    public static void addCustomer()
    {
        customerHashSet.add(new Customer(TFname.getText(),
                Integer.parseInt(TFSSN.getText()),
                Double.parseDouble(TFchecking.getText()),
                Double.parseDouble(TFsavings.getText()),
                Double.parseDouble(TFdebt.getText()),
                TAsharesAdd.getText()));
        customerArrayList.clear();
        customerArrayList.addAll(customerHashSet);
        JCcustomerName.removeAllItems();
        for(int i=0; i<customerArrayList.size(); i++)
        {
            JCcustomerName.addItem(customerArrayList.get(i));
        }
    }

    public static void loadCustomers() {
        try (FileInputStream fileIn = new FileInputStream("serCustomerSave.ser");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            customerArrayList.clear();
            customerArrayList = (ArrayList<Customer>) objectIn.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        customerHashSet.clear();
        customerHashSet.addAll(customerArrayList);
        JCcustomerName.removeAllItems();
        for(int i=0; i<customerArrayList.size(); i++)
        {
            JCcustomerName.addItem(customerArrayList.get(i));
        }

    }

    public static void removeCustomer(){
        Customer c = (Customer) JCcustomerName.getSelectedItem();
        if(c!=null)
        {
            customerArrayList.remove(c);
            customerHashSet.remove(c);
            JCcustomerName.removeItem(c);
        }
    }





}