import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Main extends JPanel{
    public static Font f = new Font("Arial", Font.BOLD, 12);
    public static Font bigf = new Font("Arial", Font.BOLD, 12);

    public static void main(String[] args)
    {
        Border line =  new LineBorder(Color.lightGray, 1);

        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1050,570);
        frame.setLayout(new FlowLayout());

        JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT));
        left.setPreferredSize(new Dimension(250,300));
        left.setFont(f);
        left.setBackground(Color.lightGray);
        left.setBorder(line);
        frame.add(left);

        JPanel center = new JPanel(new FlowLayout(FlowLayout.LEFT));
        center.setPreferredSize(new Dimension(500,300));
        center.setFont(f);
        center.setBackground(Color.lightGray);
        center.setBorder(line);
        frame.add(center);

        JPanel right = new JPanel();
        right.setPreferredSize(new Dimension(250,300));
        right.setBackground(Color.lightGray);
        right.setBorder(line);
        frame.add(right);

        JPanel bottomLeft = new JPanel();
        bottomLeft.setPreferredSize(new Dimension(250,200));
        bottomLeft.setBackground(Color.lightGray);
        bottomLeft.setBorder(line);
        frame.add(bottomLeft);

        JPanel bottomCenter = new JPanel();
        bottomCenter.setPreferredSize(new Dimension(500,200));
        bottomCenter.setBackground(Color.lightGray);
        bottomCenter.setBorder(line);
        frame.add(bottomCenter);

        JPanel bottomRight = new JPanel();
        bottomRight.setPreferredSize(new Dimension(250,200));
        bottomRight.setBackground(Color.lightGray);
        bottomRight.setBorder(line);
        frame.add(bottomRight);

        JLabel customerSort1 = new JLabel("Customer Sort:");
        customerSort1.setSize(120,25);
        customerSort1.setFont(f);
        left.add(customerSort1);

        JComboBox <String> customerSort2  = new JComboBox<>();
        customerSort2.setSize(120,25);
        customerSort2.setFont(f);
        customerSort2.addItem("Debt");
        customerSort2.addItem("Aaron");
        customerSort2.addItem("Kevin");// replace with data
        left.add(customerSort2);

        JButton addCustomer = new JButton();
        addCustomer.setMargin(new Insets(0,72,0,72));
        addCustomer.setText("Add Customer");
        addCustomer.setFont(f);
        left.add(addCustomer);

        JLabel JLSSN = new JLabel("SSN:");
        JLSSN.setFont(f);
        left.add(JLSSN);

        JTextField TFSSN = new JTextField();
        TFSSN.setColumns(17);
        TFSSN.setFont(f);
        left.add(TFSSN);

        
        JLabel JLname = new JLabel("Name:");
        JLname.setFont(f);
        left.add(JLname);

        JTextField TFname = new JTextField();
        TFname.setFont(f);
        TFname.setColumns(17);
        left.add(TFname);


        JLabel JLchecking = new JLabel("Checking:");
        JLchecking.setFont(f);
        left.add(JLchecking);

        JTextField TFchecking = new JTextField();
        TFchecking.setFont(f);
        TFchecking.setColumns(15);
        left.add(TFchecking);


        JLabel JLsavings = new JLabel("Savings:");
        JLsavings.setFont(f);
        left.add(JLsavings);

        JTextField TFsavings = new JTextField();
        TFsavings.setFont(f);
        TFsavings.setColumns(15);
        left.add(TFsavings);


        JLabel JLdebt = new JLabel("Debt:");
        JLdebt.setFont(f);
        left.add(JLdebt);

        JTextField TFdebt = new JTextField();
        TFdebt.setFont(f);
        TFdebt.setColumns(13);
        left.add(TFdebt);

        JButton addShares = new JButton();
        addShares.setMargin(new Insets(0,78,0,79));
        addShares.setText("Add Shares");
        addShares.setFont(f);
        left.add(addShares);

        JButton clearShares = new JButton();
        clearShares.setFont(f);
        clearShares.setMargin(new Insets(1,74,1,75));
        clearShares.setText("Clear Shares");
        left.add(clearShares);


        JLabel JLstockName = new JLabel("Name:");
        JLstockName.setFont(f);
        left.add(JLstockName);

        JComboBox <String> stockName  = new JComboBox<>();
        stockName.setFont(f);
        stockName.setSize(120,5);
        stockName.addItem("TSLA");
        stockName.addItem("AAPL");
        stockName.addItem("AMD");// replace with data
        left.add(stockName);


        JLabel JLshareType = new JLabel("Type:");
        JLshareType.setFont(f);
        left.add(JLshareType);

        JComboBox <String> shareType  = new JComboBox<>();
        shareType.setFont(f);
        shareType.setSize(120,5);
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
        
        JComboBox <String> JCcustomerName  = new JComboBox<>();
        JCcustomerName.setFont(f);
        JCcustomerName.addItem("Nancy Pelosi");
        JCcustomerName.addItem("Yu Jingyang");
        JCcustomerName.addItem("Pranav Manjunath");
        JCcustomerName.addItem("Hubert Blaine Wolfeschlegelsteinhausenbergerdorff Sr."); // replace with actual data
        center.add(JCcustomerName);


        JLabel stocksAndShorts = new JLabel("Stocks and Shorts:");
        stocksAndShorts.setFont(f);
        center.add(stocksAndShorts);

        JLabel headings = new JLabel("Name                              TypeShares                              Price                              Total value");
        headings.setFont(f);
        center.add(headings);






        frame.setVisible(true);


    }
    public void addCustomerSort()
    {

    }






}
