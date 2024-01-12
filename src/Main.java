import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Main extends JPanel {
    public static Font f = new Font(Font.MONOSPACED, Font.BOLD, 12);
    public static Font bigf = new Font("Arial", Font.BOLD, 12);

    public static void main(String[] args) {
        Border line = new LineBorder(Color.lightGray, 1);

        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1050, 570);
        frame.setLayout(new FlowLayout());

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
        addCustomer.setMargin(new Insets(0, 72, 0, 72));
        addCustomer.setText("Add Customer");
        addCustomer.setFont(f);
        left.add(addCustomer);

        JLabel JLSSN = new JLabel("SSN:");
        JLSSN.setFont(f);
        left.add(JLSSN);

        JTextField TFSSN = new JTextField();
        TFSSN.setColumns(24);
        TFSSN.setFont(f);
        left.add(TFSSN);


        JLabel JLname = new JLabel("Name:");
        JLname.setFont(f);
        left.add(JLname);

        JTextField TFname = new JTextField();
        TFname.setFont(f);
        TFname.setColumns(23);
        left.add(TFname);


        JLabel JLchecking = new JLabel("Checking:");
        JLchecking.setFont(f);
        left.add(JLchecking);

        JTextField TFchecking = new JTextField();
        TFchecking.setFont(f);
        TFchecking.setColumns(19);
        left.add(TFchecking);


        JLabel JLsavings = new JLabel("Savings:");
        JLsavings.setFont(f);
        left.add(JLsavings);

        JTextField TFsavings = new JTextField();
        TFsavings.setFont(f);
        TFsavings.setColumns(20);
        left.add(TFsavings);


        JLabel JLdebt = new JLabel("Debt:");
        JLdebt.setFont(f);
        left.add(JLdebt);

        JTextField TFdebt = new JTextField();
        TFdebt.setFont(f);
        TFdebt.setColumns(23);
        left.add(TFdebt);

        JButton addShares = new JButton();
        addShares.setMargin(new Insets(0, 78, 0, 79));
        addShares.setText("Add Shares");
        addShares.setFont(f);
        left.add(addShares);

        JButton clearShares = new JButton();
        clearShares.setFont(f);
        clearShares.setMargin(new Insets(1, 74, 1, 75));
        clearShares.setText("Clear Shares");
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
        JLcustomerName.setFont(f);
        center.add(JLcustomerName);

        JComboBox<String> JCcustomerName = new JComboBox<>();
        JCcustomerName.setFont(f);
        JCcustomerName.addItem("Nancy Pelosi");
        JCcustomerName.addItem("Yu Jingyang");
        JCcustomerName.addItem("Pranav Manjunath");
        JCcustomerName.addItem("Hubert Blaine Wolfeschlegelsteinhausenbergerdorff Sr."); // replace with actual data
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
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","TSLA","Short","300","$3000","$900000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMZN","Short","100","$200","$20000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMD","Short","1","$3000","$3000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","TSLA","Short","300","$3000","$900000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMZN","Short","100","$200","$20000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMD","Short","1","$3000","$3000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","TSLA","Short","300","$3000","$900000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMZN","Short","100","$200","$20000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMD","Short","1","$3000","$3000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","TSLA","Short","300","$3000","$900000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMZN","Short","100","$200","$20000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMD","Short","1","$3000","$3000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","TSLA","Short","300","$3000","$900000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMZN","Short","100","$200","$20000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMD","Short","1","$3000","$3000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","TSLA","Short","300","$3000","$900000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMZN","Short","100","$200","$20000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMD","Short","1","$3000","$3000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","TSLA","Short","300","$3000","$900000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMZN","Short","100","$200","$20000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMD","Short","1","$3000","$3000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","TSLA","Short","300","$3000","$900000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMZN","Short","100","$200","$20000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMD","Short","1","$3000","$3000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","TSLA","Short","300","$3000","$900000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMZN","Short","100","$200","$20000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMD","Short","1","$3000","$3000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","TSLA","Short","300","$3000","$900000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMZN","Short","100","$200","$20000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMD","Short","1","$3000","$3000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","TSLA","Short","300","$3000","$900000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMZN","Short","100","$200","$20000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMD","Short","1","$3000","$3000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","TSLA","Short","300","$3000","$900000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMZN","Short","100","$200","$20000"));
        TAmainwindow.append(String.format("%-23s%-9s%-11s%-10s%s%n","AMD","Short","1","$3000","$3000"));

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

        JTextField TFstockValue = new JTextField();
        TFstockValue.setColumns(17);
        right.add(TFstockValue);

        JButton JBstockValue = new JButton("Change Value");
        JBstockValue.setFont(f);
        JBstockValue.setMargin(new Insets(0,70,0,70));
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
        right.add(JBstockCap);

        JButton JBstockReset = new JButton("Reset Values");
        JBstockReset.setFont(f);
        JBstockReset.setMargin(new Insets(0,63,0,63));
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

        JTextArea TAsharesAdd = new JTextArea();
        TAsharesAdd.setColumns(23);
        TAsharesAdd.setFont(f);
        TAsharesAdd.append("TSLA   Short   300               \n");
        TAsharesAdd.append("TSLA   Short   300\n");
        TAsharesAdd.append("TSLA   Short   300\n");
        TAsharesAdd.append("TSLA   Short   300\n");
        TAsharesAdd.append("AMD    Short   300\n");
        TAsharesAdd.append("TSLA   Short   300\n");
        TAsharesAdd.append("AMD    Short   300\n");
        TAsharesAdd.append("TSLA   Short   300\n");
        TAsharesAdd.append("AMD    Short   300\n");
        TAsharesAdd.append("TSLA   Short   300\n");
        bottomLeft.add(TAsharesAdd);

        JLabel JLcheckingChange = new JLabel("Checking:");
        JLcheckingChange.setFont(f);
        bottomCenter.add(JLcheckingChange);

        JTextField TFcheckingChange = new JTextField("1000000");
        TFcheckingChange.setColumns(16);
        bottomCenter.add(TFcheckingChange);

        JButton JBcheckingChange = new JButton("Change Checking");
        JBcheckingChange.setFont(f);
        JBcheckingChange.setMargin(new Insets(0,63,0,63));
        bottomCenter.add(JBcheckingChange);

        JLabel JLsavingChange = new JLabel("Saving");
        JLsavingChange.setFont(f);
        bottomCenter.add(JLsavingChange);

        JTextField TFsavingChange = new JTextField("1000000");
        TFsavingChange.setColumns(20);
        bottomCenter.add(TFsavingChange);

        JButton JBsavingChange = new JButton("Change Saving");
        JBsavingChange.setFont(f);
        JBsavingChange.setMargin(new Insets(0,63,0,63));
        bottomCenter.add(JBsavingChange);

        JLabel JLdebtChange = new JLabel("Debt");
        JLdebtChange.setFont(f);
        bottomCenter.add(JLdebtChange);

        JTextField TFdebtChange = new JTextField("1000000");
        TFdebtChange.setColumns(23);
        bottomCenter.add(TFdebtChange);

        JButton JBdebtChange = new JButton("Change Debt");
        JBdebtChange.setMargin(new Insets(0,63,0,63));
        JBdebtChange.setFont(f);
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
        frame.setVisible(true);

        JLabel JLstockNum = new JLabel("Change Share Number: ");
        JLstockNum.setFont(f);
        bottomCenter.add(JLstockNum);

        JTextField TFstockNum = new JTextField();
        TFstockNum.setColumns(10);
        bottomCenter.add(TFstockNum);


        JButton JBcustReset = new JButton("Reset Values");
        JBcustReset.setFont(f);
        JBcustReset.setMargin(new Insets(10,100,10,100));
        bottomCenter.add(JBcustReset);

        

    }
}