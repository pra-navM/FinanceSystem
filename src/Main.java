// Alex S and Pranav - Final Project - 22/1/2024
// Read the read me

// Import statements
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;



public class Main extends JPanel implements ActionListener {

    // Creating all JComponents
    public static JFrame frame;
    public static JTextField TFname,TFsavingChange,TFcheckingChange , TFdebtChange,TFstockNum,TFstockValue,TFSSN,TFchecking,TFsavings,TFdebt,TFnewStockValue,TFnewStockName,TFnewStockCap,TFnumOfShares,TFstockCap,TFstockOwned,TFshortOwned;
    public static JComboBox<String> JCallStocks = new JComboBox<>();
    public static JComboBox<String> customerSort2 = new JComboBox<>();
    public static JComboBox<String> JCcustomerName = new JComboBox<>();
    public static JComboBox<String> JCstockChange = new JComboBox<>();
    public static JComboBox<String> stockName = new JComboBox<>();
    public static JComboBox<String> shareType = new JComboBox<>();
    public static JTextArea TAsharesAdd,TAmainwindow;
    public static JLabel JLnetAsset;
    public static Font f = new Font(Font.MONOSPACED, Font.BOLD, 12);
    // Variable to reset values
    public static double checking;
    public static double saving;
    public static double debt;
    public static double oldStockValue = 0;
    public static int oldStockCap = 0;
    // HashMaps and ArrayLists to track customers and stocks.
    public static ArrayList<CustomerShare>customerShares;
    public static HashMap<String,Stock>StockMap;
    public static HashMap<String,Customer>CustomerMap;
    public static ArrayList<Customer>customerArrayList;

    // Main class, Initializes and sets up all JComponent features.
    public Main(){
        customerShares = new ArrayList<>();
        StockMap = new HashMap<>();
        CustomerMap = new HashMap<>();
        customerArrayList = new ArrayList<>();
        Border line = new LineBorder(Color.lightGray, 1);

        frame = new JFrame("ANP Banking Services");
        frame.setResizable(false);
        frame.setSize(1050, 570);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

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

        customerSort2.setSize(120, 25);
        customerSort2.setFont(f);
        customerSort2.addItem("Name");
        customerSort2.addItem("Net Asset");
        customerSort2.addItem("Checking");
        customerSort2.addItem("Saving");
        customerSort2.addItem("Debt");
        customerSort2.setActionCommand("SortChange");
        customerSort2.addActionListener(this);
        left.add(customerSort2);

        JButton addCustomer = new JButton();
        addCustomer.setMargin(new Insets(0, 80, 0, 80));
        addCustomer.setText("Add Customer");
        addCustomer.setFont(f);
        addCustomer.addActionListener(this);
        addCustomer.setActionCommand("addCustomer");
        left.add(addCustomer);

        JLabel JLSSN = new JLabel("SSN:");
        JLSSN.setFont(f);
        left.add(JLSSN);

        TFSSN = new JTextField();
        TFSSN.setColumns(24);
        TFSSN.setFont(f);
        left.add(TFSSN);


        JLabel JLname = new JLabel("Name:");
        JLname.setFont(f);
        left.add(JLname);

        TFname = new JTextField();
        TFname.setFont(f);
        TFname.setColumns(23);
        left.add(TFname);


        JLabel JLchecking = new JLabel("Checking:");
        JLchecking.setFont(f);
        left.add(JLchecking);

        TFchecking = new JTextField();
        TFchecking.setFont(f);
        TFchecking.setColumns(19);
        left.add(TFchecking);


        JLabel JLsavings = new JLabel("Savings:");
        JLsavings.setFont(f);
        left.add(JLsavings);

        TFsavings = new JTextField();
        TFsavings.setFont(f);
        TFsavings.setColumns(20);
        left.add(TFsavings);


        JLabel JLdebt = new JLabel("Debt:");
        JLdebt.setFont(f);
        left.add(JLdebt);

        TFdebt = new JTextField();
        TFdebt.setFont(f);
        TFdebt.setColumns(23);
        left.add(TFdebt);

        JButton addShares = new JButton();
        addShares.setMargin(new Insets(0, 78, 0, 79));
        addShares.setText("Add Shares");
        addShares.setFont(f);
        addShares.addActionListener(this);
        addShares.setActionCommand("addShares");
        left.add(addShares);

        JButton clearShares = new JButton();
        clearShares.setFont(f);
        clearShares.setMargin(new Insets(1, 74, 1, 75));
        clearShares.setText("Clear Shares");
        clearShares.addActionListener(this);
        clearShares.setActionCommand("clearShares");
        left.add(clearShares);


        JLabel JLstockName = new JLabel("Name:");
        JLstockName.setFont(f);
        left.add(JLstockName);

        stockName.setFont(f);
        stockName.setSize(120, 5);
        left.add(stockName);


        JLabel JLshareType = new JLabel("Type:");
        JLshareType.setFont(f);
        left.add(JLshareType);

        shareType.setFont(f);
        shareType.setSize(120, 5);
        shareType.addItem("Short");
        shareType.addItem("Stock");
        left.add(shareType);


        JLabel JLnumOfShares = new JLabel("# of Shares:");
        JLnumOfShares.setFont(f);
        left.add(JLnumOfShares);

        TFnumOfShares = new JTextField();
        TFnumOfShares.setFont(f);
        TFnumOfShares.setColumns(13);
        left.add(TFnumOfShares);

        JLabel JLcustomerName = new JLabel("Customer Name:");
        //loadCustomers();
        JLcustomerName.setFont(f);
        center.add(JLcustomerName);

        JCcustomerName.setFont(f);
        JCcustomerName.setRenderer(new CustomComboBoxRenderer());
        JCcustomerName.setPreferredSize(new Dimension(300,20));
        JCcustomerName.addActionListener(this);
        JCcustomerName.setActionCommand("customerChoose");
        center.add(JCcustomerName);


        JLabel stocksAndShorts = new JLabel("Stocks and Shorts:");
        stocksAndShorts.setFont(f);
        center.add(stocksAndShorts);

        JLabel headings = new JLabel("Name                   Type     Shares     Price     Total Value");
        headings.setFont(f);
        center.add(headings);

        TAmainwindow = new JTextArea();
        TAmainwindow.setLineWrap(true);
        TAmainwindow.setFont(f);
        TAmainwindow.setRows(10);
        TAmainwindow.setColumns(65);
        TAmainwindow.setEditable(false);

        center.add(TAmainwindow);

        JLabel editAllStocks = new JLabel("         Edit All Stocks         ");
        editAllStocks.setFont(f);
        right.add(editAllStocks);

        JLabel JLallStocks = new JLabel("Stocks:               ");
        JLallStocks.setFont(f);
        right.add(JLallStocks);

        JCallStocks.setFont(f);
        JCallStocks.setRenderer(new CustomComboBoxRenderer());
        JCallStocks.addActionListener(this);
        JCallStocks.setActionCommand("stockChangeSetup");
        right.add(JCallStocks);

        JLabel JLstockValue = new JLabel("Value: $");
        JLstockValue.setFont(f);
        right.add(JLstockValue);

        TFstockValue = new JTextField();
        TFstockValue.setColumns(15);
        right.add(TFstockValue);

        JButton JBstockValue = new JButton("Change Value");
        JBstockValue.setFont(f);
        JBstockValue.setMargin(new Insets(0,70,0,70));
        JBstockValue.addActionListener(this);
        JBstockValue.setActionCommand("changeValue");

        right.add(JBstockValue);

        JLabel JLstockCap = new JLabel("Cap:");
        JLstockCap.setFont(f);
        right.add(JLstockCap);

        TFstockCap = new JTextField();
        TFstockCap.setColumns(19);
        right.add(TFstockCap);

        JButton JBstockCap = new JButton("Change Cap");
        JBstockCap.setFont(f);
        JBstockCap.setMargin(new Insets(0,70,0,70));
        JBstockCap.addActionListener(this);
        JBstockCap.setActionCommand("changeCap");
        right.add(JBstockCap);

        JButton JBstockReset = new JButton("Reset Values");
        JBstockReset.setFont(f);
        JBstockReset.setMargin(new Insets(0,63,0,63));
        JBstockReset.addActionListener(this);
        JBstockReset.setActionCommand("resetValuesStock");
        right.add(JBstockReset);

        JLabel JLstockOwned = new JLabel("# of Stocks Bought:");
        JLstockCap.setFont(f);
        right.add(JLstockOwned);

        TFstockOwned = new JTextField();
        TFstockOwned.setColumns(10);
        TFstockOwned.setEditable(false);
        right.add(TFstockOwned);

        JLabel JLshortOwned = new JLabel("# of Shorts Held:");
        JLstockCap.setFont(f);
        right.add(JLshortOwned);

        TFshortOwned = new JTextField();
        TFshortOwned.setColumns(10);
        TFshortOwned.setEditable(false);
        right.add(TFshortOwned);

        JLabel JLsharesAdd = new JLabel("Shares to Add      ");
        JLsharesAdd.setFont(f);
        bottomLeft.add(JLsharesAdd);

        JLabel JLsharesTitles = new JLabel("Name   Type    Number           ");
        JLsharesTitles.setFont(f);
        bottomLeft.add(JLsharesTitles);

        TAsharesAdd = new JTextArea();
        TAsharesAdd.setColumns(33);
        TAsharesAdd.setFont(f);
        TAsharesAdd.setEditable(false);
        JScrollPane SPsharesAdd = new JScrollPane(TAsharesAdd);
        bottomLeft.add(SPsharesAdd);

        JLabel JLcheckingChange = new JLabel("Checking:");
        JLcheckingChange.setFont(f);
        bottomCenter.add(JLcheckingChange);

        TFcheckingChange = new JTextField(checking+"");
        TFcheckingChange.setColumns(16);
        bottomCenter.add(TFcheckingChange);

        JButton JBcheckingChange = new JButton("Change Checking");
        JBcheckingChange.setFont(f);
        JBcheckingChange.setMargin(new Insets(0,63,0,63));
        JBcheckingChange.addActionListener(this);
        JBcheckingChange.setActionCommand("changeCheck");
        bottomCenter.add(JBcheckingChange);

        JLabel JLsavingChange = new JLabel("Saving");
        JLsavingChange.setFont(f);
        bottomCenter.add(JLsavingChange);

        TFsavingChange = new JTextField(saving+"");
        TFsavingChange.setColumns(20);
        bottomCenter.add(TFsavingChange);

        JButton JBsavingChange = new JButton("Change Saving");
        JBsavingChange.setFont(f);
        JBsavingChange.setMargin(new Insets(0,63,0,63));
        JBsavingChange.addActionListener(this);
        JBsavingChange.setActionCommand("changeSaving");
        bottomCenter.add(JBsavingChange);

        JLabel JLdebtChange = new JLabel("Debt: ");
        JLdebtChange.setFont(f);
        bottomCenter.add(JLdebtChange);

        TFdebtChange = new JTextField(debt+"");
        TFdebtChange.setColumns(20);
        bottomCenter.add(TFdebtChange);

        JButton JBdebtChange = new JButton("Change Debt");
        JBdebtChange.setMargin(new Insets(0,63,0,63));
        JBdebtChange.setFont(f);
        JBdebtChange.addActionListener(this);
        JBdebtChange.setActionCommand("changeDebt");
        bottomCenter.add(JBdebtChange);

        JLabel JLstockChange = new JLabel("Stock: ");
        JLstockChange.setFont(f);
        bottomCenter.add(JLstockChange);

        JCstockChange.setFont(f);
        JCstockChange.setSize(120, 5);
        bottomCenter.add(JCstockChange);

        JLabel JLstockNum = new JLabel("Share Number: ");
        JLstockNum.setFont(f);
        bottomCenter.add(JLstockNum);

        TFstockNum = new JTextField();
        TFstockNum.setColumns(8);
        bottomCenter.add(TFstockNum);

        JButton JBstockNum = new JButton ("Change Share Number");
        JBstockNum.setFont(f);
        JBstockNum.addActionListener(this);
        JBstockNum.setActionCommand("changeShare");
        bottomCenter.add(JBstockNum);

        JButton JBcustReset = new JButton("Reset Values");
        JBcustReset.setFont(f);
        JBcustReset.setMargin(new Insets(10,100,10,100));
        JBcustReset.addActionListener(this);
        JBcustReset.setActionCommand("resetValuesCustomer");
        bottomCenter.add(JBcustReset);

        JLnetAsset = new JLabel("Total Asset: $");
        JLnetAsset.setFont(f);
        bottomCenter.add(JLnetAsset);

        JButton JBaddStock = new JButton("Add New Stock");
        JBaddStock.setMargin(new Insets(0,63,0,63));
        JBaddStock.setFont(f);
        JBaddStock.addActionListener(this);
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
        JBstockHistory.addActionListener(this);
        JBstockHistory.setActionCommand("stockHist");
        bottomRight.add(JBstockHistory);

        JButton JBaddFile = new JButton("Add File");
        JBaddFile.setMargin(new Insets(0,4,0,4));
        JBaddFile.setFont(f);
        JBaddFile.addActionListener(this);
        JBaddFile.setActionCommand("addFile");
        bottomRight.add(JBaddFile);

//        JButton JBsaveFile = new JButton("Save to File");
//        JBsaveFile.setMargin(new Insets(0,4,0,4));
//        JBsaveFile.setFont(f);
//        JBsaveFile.addActionListener(this);
//        JBsaveFile.setActionCommand("saveFile");
//        bottomRight.add(JBsaveFile);

        frame.setVisible(true);
    }
    // Main method, runs the main class.
    public static void main(String[] args){
        new Main();
    }

    // Action method, detects button presses as well as JCombobox changes.
    public void actionPerformed(ActionEvent e) {
        String in = e.getActionCommand();
        // All values are in a large if-else statement, with individual checks to ensure that all values being read are valid.
        if(in.equals("SortChange")){sortCustomers();}
        else if(in.equals("addCustomer")){
            if(errorCheckInt("SSN",TFSSN.getText(),false) &&
                    errorCheckDouble("Checking",TFchecking.getText(),true) &&
                    errorCheckDouble("Savings",TFsavings.getText(),true) &&
                    errorCheckDouble("Debt",TFdebt.getText(),true)){
                for(Customer cust: customerArrayList){
                    if(cust.getSSN() == Integer.parseInt(TFSSN.getText()))error("Error: Cannot have repeat SSN.");
                    else addCustomer();
                }
                if(customerArrayList.isEmpty())addCustomer();
            }

        }
        else if(in.equals("addShares")){
            if(errorCheckInt("# of Shares",TFnumOfShares.getText(),false)){
                Stock stock = StockMap.get(stockName.getSelectedItem());
                if(shareType.getSelectedItem().equals("Short")){
                    if(stock.getCurrentShorts()+Integer.parseInt(TFnumOfShares.getText())>stock.getCap()){
                        error("Error: Surpassed Stock Cap (" + stock.getCurrentShorts() + "/" + stock.getCap() + ")");
                    }
                    else{
                        addShares();
                        StockMap.get(stockName.getSelectedItem()).addShort(Integer.parseInt(TFnumOfShares.getText()));
                    }
                }
                else{
                    if(stock.getCurrentShares()+Integer.parseInt(TFnumOfShares.getText())>stock.getCap()){
                        error("Error: Surpassed Stock Cap (" + stock.getCurrentShares() + "/" + stock.getCap() + ")");
                    }
                    else{
                        addShares();
                        StockMap.get(stockName.getSelectedItem()).addStock(Integer.parseInt(TFnumOfShares.getText()));
                    }
                }
            }
            addShares();
        }
        else if(in.equals("clearShares")){clearShares();}
        else if(in.equals("customerChoose")){updateCustomer();}
        else if(in.equals("stockChangeSetup")){stockChangeSetup();}
        else if(in.equals("changeValue")){
            if(errorCheckDouble("Stock Value",TFstockValue.getText(),true))changeValue();
        }
        else if(in.equals("changeCap")){
            if(errorCheckInt("Stock Cap",TFstockCap.getText(),false)){
                Stock stock = StockMap.get(stockName.getSelectedItem());
                if(stock.getCurrentShorts()<Integer.parseInt(TFstockCap.getText())&&stock.getCurrentShares()<Integer.parseInt(TFstockCap.getText()))changeCap();
                else error("Error: Number of Shares/Shorts Exceed Change. (" + stock.getCurrentShares() + "," + stock.getCurrentShorts() + ")");
            }
        }
        else if(in.equals("resetValuesStock")){resetStockValues();}
        else if(in.equals("changeCheck")) {
            if(errorCheckDouble("Checking",TFcheckingChange.getText(),true))changeCheck();
        }
        else if(in.equals("changeSaving")){
            if(errorCheckDouble("Saving",TFsavingChange.getText(),true))changeSaving();
        }
        else if(in.equals("changeDebt")){
            if(errorCheckDouble("Debt",TFdebtChange.getText(),true))changeDebt();
        }
        // Unlike the others as we want to allow negative values.
        else if(in.equals("changeShare")){
            try{
                Integer.parseInt(TFstockNum.getText());
                changeShareNum();
            }catch(Exception f){error("Error: Share Number must be an Integer.");}
        }
        else if(in.equals("resetValuesCustomer")){resetValuesCustomer();}
        else if(in.equals("addStock")){
            if(errorCheckDouble("Stock Value",TFnewStockValue.getText(),true) &&
                    errorCheckInt("Stock Cap", TFnewStockCap.getText(),false))addStock();
        }
        else if(in.equals("stockHist")){stockHist();}
        else if(in.equals("addFile")){readFile();}
        //else if(in.equals("saveFile")){saveFile();}
    }
    // Checks if an input of a double is valid, used due to frequency of use. Will create a JFrame
    // stating the problem if invalid. Can include zero or not depending on the boolean.
    public static Boolean errorCheckDouble(String message,String value, Boolean includeZero){
        message = "Error: " + message + " must be a Double " ;
        try{
            if(value.isBlank())throw new Exception();
            double errorCheck = Double.parseDouble(value);
            if(includeZero && errorCheck < 0){
                message += "equal to or ";
                throw new Exception();
            }
            else if (errorCheck<=0){
                throw new Exception();
            }
            else return true;
        }catch(Exception e){}
        message += "greater than 0.";
        JFrame errorFrame = new JFrame("Error");
        errorFrame.setResizable(false);
        errorFrame.setSize(400,75);
        JTextField errorText = new JTextField(message);
        errorText.setEditable(false);
        errorFrame.add(errorText);
        errorFrame.setVisible(true);
        return false;
    }
    // Checks if an input of an integer is valid, used due to frequency of use. Will create a JFrame
    // stating the problem if invalid. Can include zero or not depending on the boolean.
    public static Boolean errorCheckInt(String message, String value, Boolean includeZero){
        message = "Error: " + message + " must be an Integer ";
        try{
            if(value.isBlank())throw new Exception();
            int errorCheck = Integer.parseInt(value);
            if(includeZero && errorCheck < 0){
                message += "equal to or ";
                throw new Exception();
            }
            else if (errorCheck<=0){
                throw new Exception();
            }
            else return true;
        }catch(Exception e){}
        message += "greater than 0.";
        JFrame errorFrame = new JFrame("Error");
        errorFrame.setResizable(false);
        errorFrame.setSize(400,75);
        JTextField errorText = new JTextField(message);
        errorText.setEditable(false);
        errorFrame.add(errorText);
        errorFrame.setVisible(true);
        return false;
    }
    // Customizable error message creation for non-numerical exceptions.
    public static void error(String message){
        JFrame errorFrame = new JFrame("Error");
        errorFrame.setResizable(false);
        errorFrame.setSize(400,75);
        JTextField errorText = new JTextField(message);
        errorText.setEditable(false);
        errorFrame.add(errorText);
        errorFrame.setVisible(true);
    }
    // Sorts the customer. Able to choose between different sorting types (Name, Asset, Checking, Saving, Debt).
    // Removes action listener to avoid triggering it when changing the sorting.
    public void sortCustomers(){
        String selectedOption = (String) customerSort2.getSelectedItem();
        JCcustomerName.removeActionListener(this);
        if(selectedOption.equals("Name")){
            Collections.sort(customerArrayList, new SortByName());
            JCcustomerName.removeAllItems();
            for(int i=0; i<customerArrayList.size(); i++)
            {
                JCcustomerName.addItem(customerArrayList.get(i).getName());
            }
        }
        else if(selectedOption.equals("Net Asset")){
            Collections.sort(customerArrayList, new SortByNetAsset());
            JCcustomerName.removeAllItems();
            for(int i=0; i<customerArrayList.size(); i++)
            {
                JCcustomerName.addItem(customerArrayList.get(i).getName());
            }
        }
        else if(selectedOption.equals("Checking")){
            Collections.sort(customerArrayList, new SortByChecking());
            JCcustomerName.removeAllItems();
            for(int i=0; i<customerArrayList.size(); i++)
            {
                JCcustomerName.addItem(customerArrayList.get(i).getName());
            }
        }
        else if(selectedOption.equals("Saving")){
            Collections.sort(customerArrayList, new SortBySaving());
            JCcustomerName.removeAllItems();
            for(int i=0; i<customerArrayList.size(); i++)
            {
                JCcustomerName.addItem(customerArrayList.get(i).getName());
            }
        }
        else if(selectedOption.equals("Debt")){
            Collections.sort(customerArrayList, new SortByDebt());
            JCcustomerName.removeAllItems();
            for(int i=0; i<customerArrayList.size(); i++)
            {
                JCcustomerName.addItem(customerArrayList.get(i).getName());
            }
        }
        JCcustomerName.addActionListener(this);
    }
    // Adds a new customer. Puts the customer into a map and arraylist for accessing.
    public static void addCustomer()
    {
        Customer cust = new Customer(TFname.getText(),
                Integer.parseInt(TFSSN.getText()),
                Double.parseDouble(TFchecking.getText()),
                Double.parseDouble(TFsavings.getText()),
                Double.parseDouble(TFdebt.getText()),
                TAsharesAdd.getText());
        CustomerMap.put(TFname.getText(),cust);
        customerArrayList.add(cust);
        JCcustomerName.addItem(TFname.getText());
        TFname.setText("");
        TFSSN.setText("");
        TFchecking.setText("");
        TFsavings.setText("");
        TFdebt.setText("");
        TAsharesAdd.setText("");
        customerShares.clear();
    }
    // Adds shares. Tracks customer shares for stock cap.
    public static void addShares(){
        TAsharesAdd.append(String.format("%-7s%-8s%-18d%n",stockName.getSelectedItem(),shareType.getSelectedItem(),Integer.parseInt(TFnumOfShares.getText())));
        customerShares.add(new CustomerShare((String)stockName.getSelectedItem(),(String)shareType.getSelectedItem(),Integer.parseInt(TFnumOfShares.getText())));
    }
    // Clears all shares that would have been added, to be able to add new shares. Clears the stock cap taken up.
    public static void clearShares(){
        TAsharesAdd.setText("");
        for(CustomerShare share:customerShares){
            if(share.getType().equals("Short")){
                StockMap.get(share.getStockName()).addShort(-share.getShares());
            }
            else{
                StockMap.get(share.getStockName()).addStock(-share.getShares());
            }
        }
        customerShares.clear();
    }
    // Adds a new stock into the stockmap. JComboBoxes are able to now access the stock.
    public static void addStock(){
        Stock stock = new Stock(TFnewStockName.getText(),Double.parseDouble(TFnewStockValue.getText()),Integer.parseInt(TFnewStockCap.getText()));
        StockMap.put(stock.getName(),stock);
        stockName.addItem(stock.getName());
        JCallStocks.addItem(stock.getName());
        JCstockChange.addItem(stock.getName());
        TFnewStockName.setText("");
        TFnewStockValue.setText("");
        TFnewStockCap.setText("");
    }
    // Sets up when the JComboBox for stocks gets a new value chosen, assigns all corresponding values and saves old values for reverting changes.
    public static void stockChangeSetup(){
        TFstockValue.setText(StockMap.get(JCallStocks.getSelectedItem()).getNewValue()+"");
        TFstockCap.setText(StockMap.get(JCallStocks.getSelectedItem()).getCap()+"");
        TFstockOwned.setText(StockMap.get(JCallStocks.getSelectedItem()).getCurrentShares()+"");
        TFshortOwned.setText(StockMap.get(JCallStocks.getSelectedItem()).getCurrentShorts()+"");
        oldStockValue = StockMap.get(JCallStocks.getItemAt(0)).getNewValue();
        oldStockCap = StockMap.get(JCallStocks.getItemAt(0)).getCap();
    }
    // Saves changes to the value of a stock.
    public static void changeValue(){
        StockMap.get(JCallStocks.getSelectedItem()).setValue(Double.parseDouble(TFstockValue.getText()));
        oldStockValue = Double.parseDouble(TFstockValue.getText());
    }
    // Saves changes to the cap of a stock.
    public static void changeCap(){
        StockMap.get(JCallStocks.getSelectedItem()).setCap(Integer.parseInt(TFstockCap.getText()));
        oldStockCap = Integer.parseInt(TFstockCap.getText());
    }
    // Reverts unsaved changes to stock value and cap.
    public static void resetStockValues(){
        TFstockValue.setText(oldStockValue+"");
        TFstockCap.setText(oldStockCap+"");
    }
    // Saves changes to the selected customer checking account.
    public static void changeCheck(){
        CustomerMap.get(JCcustomerName.getSelectedItem()).setCheckAcc(Double.parseDouble(TFcheckingChange.getText()));
        checking = Double.parseDouble(TFcheckingChange.getText());
        updateCustomer();
    }
    // Saves changes to the selected customer saving account.
    public static void changeSaving(){
        CustomerMap.get(JCcustomerName.getSelectedItem()).setSavingAcc(Double.parseDouble(TFsavingChange.getText()));
        saving = Double.parseDouble(TFsavingChange.getText());
        updateCustomer();
    }
    // Saves changes to the selected customer debt account.
    public static void changeDebt(){
        CustomerMap.get(JCcustomerName.getSelectedItem()).setDebtAcc(Double.parseDouble(TFdebtChange.getText()));
        debt = Double.parseDouble(TFdebtChange.getText());
        updateCustomer();
    }
    // Changes the number of shares owned in the selected stock. Able to change type as well.
    public static void changeShareNum(){
        CustomerMap.get(JCcustomerName.getSelectedItem()).changeShare(Integer.parseInt(TFstockNum.getText()),JCstockChange.getSelectedItem()+"");
    }
    // Resets the unsaved values of a customer.
    public static void resetValuesCustomer(){
        TFcheckingChange.setText(checking+"");
        TFsavingChange.setText(saving+"");
        TFdebtChange.setText(debt+"");
    }
    // Creates the graph displaying the history of a stock.
    public static void stockHist(){
        GraphPanel graphPanel = new GraphPanel(StockMap.get(JCallStocks.getSelectedItem()).getValue(),(String)JCallStocks.getSelectedItem());
        graphPanel.Graph();
    }
    // Updates the information of a customer, accounting for unintentional negative values, to display.
    public static void updateCustomer(){
        Customer cust = CustomerMap.get(JCcustomerName.getSelectedItem());
        TFcheckingChange.setText(cust.getCheckAcc()+"");
        TFsavingChange.setText(cust.getSavingAcc()+"");
        TFdebtChange.setText(cust.getDebtAcc()+"");
        JLnetAsset.setText("Total Asset: $" + cust.getAsset());
        TAmainwindow.setText(cust.getSharesBought());
        checking = cust.getCheckAcc();
        saving = cust.getSavingAcc();
        debt = cust.getDebtAcc();
    }
    // Reads a given file. Instructions on file formatting are below.
    public static void readFile(){
        FileDialog dialog = new FileDialog(frame, "Add File", FileDialog.LOAD);
        dialog.setVisible(true);
        String fileName = dialog.getFile();
        String directory = dialog.getDirectory();
        if (fileName != null) {
            try {
                Scanner input = new Scanner(new File(directory + fileName));
                int num = Integer.parseInt(input.nextLine());
                for(int i = 0; i< num;i++){
                    String stockAdd = input.nextLine();
                    int stockCap = Integer.parseInt(input.nextLine());
                    StringTokenizer token = new StringTokenizer(input.nextLine());
                    ArrayList<Double>stockValue = new ArrayList<>();
                    while(token.hasMoreTokens()){
                        stockValue.add(Double.parseDouble(token.nextToken()));
                    }
                    Stock addStock = new Stock(stockAdd, stockValue.get(0),stockCap);
                    for(int j = 1; j < stockValue.size();j++){
                        addStock.setValue(stockValue.get(j));
                    }
                    StockMap.put(stockAdd,addStock);
                    stockName.addItem(stockAdd);
                    JCallStocks.addItem(stockAdd);
                    JCstockChange.addItem(stockAdd);
                }
                num = Integer.parseInt(input.nextLine());
                for(int i = 0; i< num;i++){
                    String Name = input.nextLine();
                    int SSN = Integer.parseInt(input.nextLine());
                    double checking = Double.parseDouble(input.nextLine());
                    double saving = Double.parseDouble(input.nextLine());
                    double debt = Double.parseDouble(input.nextLine());
                    String shares = "";
                    int num2 =Integer.parseInt(input.nextLine());
                    for(int j = 0; j<num2;j++){
                        shares += input.nextLine() + " ";
                    }
                    Customer cust = new Customer(Name, SSN, checking, saving ,debt, shares);
                    CustomerMap.put(Name,cust);
                    customerArrayList.add(cust);
                    JCcustomerName.addItem(Name);
                }
            } catch (Exception e) {error("Error: File must be of format: # of stocks to add" +
                    ", stock name, stock cap, stock prices (Separated by spaces),# of people, Name, SSN, " +
                    "Checking Account, Saving Account, Debt Account, # of shares, share name + share type + share num. Commas signify a line break. Pluses mean spaces.");}
        }
    }
//    public static void saveFile() //save ArrayList to a file
//    {
//        try{
//            PrintWriter output = new PrintWriter(new FileWriter("fileSave.txt"));
//            output.println(StockMap.size());
//            ArrayList<Stock>stockArr = new ArrayList<>(StockMap.values());
//            for(Stock stockPrint:stockArr){
//                output.println(stockPrint.getName());
//                output.println(stockPrint.getCap());
//                for(double i: stockPrint.getValue()){
//                    output.print(i+" ");
//                }
//                output.println();
//            }
//            output.println(CustomerMap.size());
//            ArrayList<Customer>customerArr = new ArrayList<>(CustomerMap.values());
//            for(Customer customerPrint:customerArr){
//                output.println(customerPrint.getName());
//                output.println(customerPrint.getSSN());
//                output.println(customerPrint.getCheckAcc());
//                output.println(customerPrint.getSavingAcc());
//                output.println(customerPrint.getDebtAcc());
//                output.println(customerPrint.getMap().size());
//                ArrayList<CustomerShare>customerShareArr = new ArrayList<>(customerPrint.getMap().values());
//                for(CustomerShare share: customerShareArr){
//                    output.println(share);
//                }
//                output.println();
//            }
//        }catch(Exception e){error("Error: File unable to be created");}
//    }


}