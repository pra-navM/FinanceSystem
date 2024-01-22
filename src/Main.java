import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main extends JPanel implements ActionListener {

    public static JTextField TFname,TFsavingChange,TFcheckingChange , TFdebtChange = new JTextField(),TFstockNum = new JTextField(),TFstockValue,TFSSN,TFchecking,TFsavings,TFdebt,TFnewStockValue,TFnewStockName,TFnewStockCap,TFnumOfShares,TFstockCap;
    public static JComboBox<String> customerSort2, JCcustomerName;
    public static JComboBox<String> JCallStocks = new JComboBox<>();
    public static JComboBox<String> JCstockChange = new JComboBox<>();
    public static JComboBox<String> stockName = new JComboBox<>();
    public static JComboBox<String> shareType = new JComboBox<>();
    //public HashSet <Customer> customerHashSet = new HashSet<>();
    public static HashMap<String,Customer>CustomerMap;
    public static JTextArea TAsharesAdd;
    public static JLabel JLnetAsset;
    public static Font f = new Font(Font.MONOSPACED, Font.BOLD, 12);
    public static double netAsset;
    public static double checking;
    public static double saving;
    public static double debt;
    public static double oldStockValue = 0;
    public static int oldStockCap = 0;
    public static ArrayList<CustomerShare>customerShares;
    public static HashMap<String,Stock>StockMap;
    public static ArrayList<Customer>customerArrayList;

    public Main(){
        customerShares = new ArrayList<>();
        StockMap = new HashMap<>();
        CustomerMap = new HashMap<>();
        customerArrayList = new ArrayList<>();
        Border line = new LineBorder(Color.lightGray, 1);

        JFrame frame = new JFrame("ANP Banking Services");
        frame.setResizable(false);
        frame.setSize(1050, 570);
        frame.setLayout(new FlowLayout());

        frame.addWindowListener(new WindowAdapter() {
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

        customerSort2 = new JComboBox<>();
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
        addCustomer.setMargin(new Insets(0, 72, 0, 72));
        addCustomer.setText("Add Customer");
        addCustomer.setFont(f);
        addCustomer.addActionListener(this);
        addCustomer.setActionCommand("addCustomer");
        left.add(addCustomer);

        JLabel JLSSN = new JLabel("SSN:");
        JLSSN.setFont(f);
        left.add(JLSSN);

        TFSSN = new JTextField();
        TFSSN.setColumns(23);
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

        JCcustomerName = new JComboBox<>();
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

        JTextArea TAmainwindow = new JTextArea();
        TAmainwindow.setLineWrap(true);
        TAmainwindow.setFont(f);
        TAmainwindow.setRows(10);
        TAmainwindow.setColumns(65);
        TAmainwindow.setEditable(false);
        //TAmainwindow.append(String.format("%-23s%-9s%-11s$%-10s$%s%n","AMZN","Short","100","$200","$20000"));

        center.add(TAmainwindow);

        JLabel editAllStocks = new JLabel("         Edit All Stocks         ");
        editAllStocks.setFont(f);
        right.add(editAllStocks);

        JLabel JLallStocks = new JLabel("Stocks:              ");
        JLallStocks.setFont(f);
        right.add(JLallStocks);

        JCallStocks.setFont(f);
        JCcustomerName.setRenderer(new CustomComboBoxRenderer());
        JCcustomerName.setPreferredSize(new Dimension(300,20));
        JCallStocks.addActionListener(this);
        JCallStocks.setActionCommand("stockChangeSetup");
        JCallStocks.addItem("Choose Stock");
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

        JTextField TFstockOwned = new JTextField();
        TFstockOwned.setColumns(24);
        right.add(TFstockOwned);

        JLabel JLshortOwned = new JLabel("# of Shorts Held:");
        JLstockCap.setFont(f);
        right.add(JLshortOwned);

        JTextField TFshortOwned = new JTextField();
        TFshortOwned.setColumns(24);
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
        JCstockChange.addItem("Choose Stock");
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
        JBaddFile.setMargin(new Insets(0,63,0,63));
        JBaddFile.setFont(f);
        JBaddFile.addActionListener(this);
        JBaddFile.setActionCommand("addFile");
        bottomRight.add(JBaddFile);

        //loadCustomers();
        StockMap.put("Choose Stock", new Stock("Invalid",0,0));

        frame.setVisible(true);
    }
    public static void main(String[] args)throws FileNotFoundException{
        new Main();
    }

    public void actionPerformed(ActionEvent e) {
        String in = e.getActionCommand();
        if(in.equals("SortChange")){
            //sortCustomers();
        }
        else if(in.equals("addCustomer")){addCustomer();}
        else if(in.equals("addShares")){addShares();}
        else if(in.equals("clearShares")){clearShares();}
        else if(in.equals("customerChoose")){updateCustomer();}
        else if(in.equals("stockChangeSetup")){stockChangeSetup();}
        else if(in.equals("changeValue")){changeValue();}
        else if(in.equals("changeCap")){changeCap();}
        else if(in.equals("resetValuesStock")){resetStockValues();}
        else if(in.equals("changeCheck")) {changeCheck();}
        else if(in.equals("changeSaving")){changeSaving();}
        else if(in.equals("changeDebt")){changeDebt();}
        else if(in.equals("changeShare")){}
        else if(in.equals("resetValuesCustomer")){}
        else if(in.equals("addStock")){addStock();}
        else if(in.equals("stockHist")){}
        else if(in.equals("addFile")){}
    }
    public static Boolean errorCheckDouble(String message,String value){
        try{
            double errorCheck = Double.parseDouble(value);
            if(errorCheck < 0)throw new Exception();
            else return true;
        }catch(Exception e){}
        JFrame errorFrame = new JFrame("Error");
        errorFrame.setResizable(false);
        errorFrame.setSize(400,75);
        JTextField errorText = new JTextField("Error: " + message);
        errorFrame.add(errorText);
        errorFrame.setVisible(true);
        return false;
    }
    public static Boolean errorCheckInt(String message, String value){
        try{
            int errorCheck = Integer.parseInt(value);
            if(errorCheck < 0)throw new Exception();
            else return true;
        }catch(Exception e){}
        JFrame errorFrame = new JFrame("Error");
        errorFrame.setResizable(false);
        errorFrame.setSize(400,75);
        JTextField text = new JTextField("Error: " + message);
        errorFrame.add(text);
        errorFrame.setVisible(true);
        return false;
    }
    public static void sortCustomers(){
        String selectedOption = (String) customerSort2.getSelectedItem();
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
            }}
        else if(selectedOption.equals("Checking")){
            Collections.sort(customerArrayList, new SortByChecking());
            JCcustomerName.removeAllItems();
            for(int i=0; i<customerArrayList.size(); i++)
            {
                JCcustomerName.addItem(customerArrayList.get(i).getName());
            }}
        else if(selectedOption.equals("Saving")){
            Collections.sort(customerArrayList, new SortBySaving());
            JCcustomerName.removeAllItems();
            for(int i=0; i<customerArrayList.size(); i++)
            {
                JCcustomerName.addItem(customerArrayList.get(i).getName());
            }}
        else if(selectedOption.equals("Debt")){
            Collections.sort(customerArrayList, new SortByDebt());
            JCcustomerName.removeAllItems();
            for(int i=0; i<customerArrayList.size(); i++)
            {
                JCcustomerName.addItem(customerArrayList.get(i).getName());
            }

        }
        //System.out.println("Selected Option: " + selectedOption);
    }
    public static void addCustomer()
    {
        Customer cust = new Customer(TFname.getText(),
                Integer.parseInt(TFSSN.getText()),
                Double.parseDouble(TFchecking.getText()),
                Double.parseDouble(TFsavings.getText()),
                Double.parseDouble(TFdebt.getText()),
                TAsharesAdd.getText());
        //customerHashSet.add(cust);
        CustomerMap.put(TFname.getText(),cust);
        customerArrayList.add(cust);
        JCcustomerName.addItem(TFname.getText());
    }
    public static void addShares(){
        if(errorCheckInt("Number of Shares is Invalid.", TFnumOfShares.getText())){
            TAsharesAdd.append(String.format("%-7s%-8s%-18d%n",stockName.getSelectedItem(),shareType.getSelectedItem(),Integer.parseInt(TFnumOfShares.getText())));
        }
    }
    public static void clearShares(){
        TAsharesAdd.setText("");
    }

    public static void addStock(){
        Stock stock = new Stock(TFnewStockName.getText(),Double.parseDouble(TFnewStockValue.getText()),Integer.parseInt(TFnewStockCap.getText()));
        StockMap.put(stock.getName(),stock);
        stockName.addItem(stock.getName());
        JCallStocks.addItem(stock.getName());
        JCstockChange.addItem(stock.getName());
        JCstockChange.setSelectedIndex(0);
    }
    public static void stockChangeSetup(){
        TFstockValue.setText(StockMap.get(JCstockChange.getSelectedItem()).getNewValue()+"");
        TFstockCap.setText(StockMap.get(JCstockChange.getItemAt(0)).getNewValue()+"");
        oldStockValue = StockMap.get(JCstockChange.getItemAt(0)).getNewValue();
        oldStockCap = StockMap.get(JCstockChange.getItemAt(0)).getCap();
    }
    public static void changeValue(){
        StockMap.get(JCstockChange.getSelectedItem()).setValue(Double.parseDouble(TFstockValue.getText()));
        oldStockValue = Double.parseDouble(TFstockValue.getText());
    }
    public static void changeCap(){
        StockMap.get(JCstockChange.getSelectedItem()).setCap(Integer.parseInt(TFstockCap.getText()));
        oldStockCap = Integer.parseInt(TFstockCap.getText());
    }
    public static void resetStockValues(){
        TFstockValue.setText(oldStockValue+"");
        TFstockCap.setText(oldStockCap+"");
    }
    public static void changeCheck(){
        CustomerMap.get(JCcustomerName.getSelectedItem()).setCheckAcc(Double.parseDouble(TFcheckingChange.getText()));
        updateCustomer();
    }
    public static void changeSaving(){
        CustomerMap.get(JCcustomerName.getSelectedItem()).setSavingAcc(Double.parseDouble(TFsavingChange.getText()));
        updateCustomer();
    }
    public static void changeDebt(){
        CustomerMap.get(JCcustomerName.getSelectedItem()).setDebtAcc(Double.parseDouble(TFdebtChange.getText()));
        updateCustomer();
    }
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

//    public void loadCustomers() {
//        try (FileInputStream fileIn = new FileInputStream("customerSave.txt");
//             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
//            customerArrayList.clear();
//            customerArrayList = (ArrayList<Customer>) objectIn.readObject();
//        }
//        catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        customerHashSet.clear();
//        customerHashSet.addAll(customerArrayList);
//        JCcustomerName.removeAllItems();
//        for (int i = 0; i < customerArrayList.size(); i++) {
//            JCcustomerName.addItem(customerArrayList.get(i));
//        }
//    }
    public static void removeCustomer(){
        Customer c = (Customer) JCcustomerName.getSelectedItem();
        if(c!=null)
        {
            customerArrayList.remove(c);
            CustomerMap.remove(c.getName());
            //customerHashSet.remove(c);
            JCcustomerName.removeItem(c);
        }
    }
    public static void updateCustomer(){
        Customer cust = (Customer)JCcustomerName.getSelectedItem();
        TFcheckingChange.setText(cust.getCheckAcc()+"");
        TFsavingChange.setText(cust.getSavingAcc()+"");
        TFdebtChange.setText(cust.getDebtAcc()+"");
        JLnetAsset.setText("Total Asset: $" + cust.getAsset());
        // add stock stuff
    }
}