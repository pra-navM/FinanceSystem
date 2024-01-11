import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.util.*;
import java.io.*;

public class Main extends JPanel{
    private static ArrayList<String>stocksAdded;
    private final Font ARIAL_30 = new Font("Arial", Font.PLAIN, 30);
    private final Font MonoSpace = new Font(Font.MONOSPACED, Font.PLAIN,14);

    public static void main(String[] args)
    {
        stocksAdded = new ArrayList<>();
        Border line =  new LineBorder(Color.white, 4);

        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1050,625);
        frame.setLayout(new FlowLayout());

        JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(250,600));
        left.setBackground(Color.white);
        left.setBorder(line);
        frame.add(left);

        JPanel center = new JPanel();
        center.setPreferredSize(new Dimension(500,600));
        center.setBackground(Color.white);
        center.setBorder(line);
        center.setLayout(new GridLayout(4,1));
        frame.add(center);

        JPanel right = new JPanel();
        right.setPreferredSize(new Dimension(250,600));
        right.setBackground(Color.white);
        right.setBorder(line);
        frame.add(right);

        JLabel customerSort1 = new JLabel("Customer Sort:");
        customerSort1.setFont(new Font(Font.MONOSPACED, Font.PLAIN,13));
        left.add(customerSort1);

        JComboBox <String> customerSort2  = new JComboBox<>();
        customerSort2.setSize(120,20);
        customerSort2.addItem("Net Assets");
        customerSort2.addItem("Checking");
        customerSort2.addItem("Saving");
        customerSort2.addItem("Debt");
        customerSort2.setFont(new Font(Font.MONOSPACED, Font.PLAIN,13));
        left.add(customerSort2);

        JButton addCustomer = new JButton();
        addCustomer.setMargin(new Insets(5,100,5,100));
        addCustomer.setText("Add Customer");
        addCustomer.setFont(MonoSpace);
        left.add(addCustomer);

        JLabel JLSSN = new JLabel("SSN: ");
        JLSSN.setFont(MonoSpace);
        left.add(JLSSN);

        JTextField TFSSN = new JTextField();
        TFSSN.setColumns(18);
        left.add(TFSSN);

        JLabel JLname = new JLabel("Name: ");
        JLname.setFont(MonoSpace);
        left.add(JLname);

        JTextField TFname = new JTextField();
        TFname.setColumns(17);
        left.add(TFname);

        JLabel JLchecking = new JLabel("Checking: $");
        JLchecking.setFont(MonoSpace);
        left.add(JLchecking);

        JTextField TFchecking = new JTextField();
        TFchecking.setColumns(13);
        left.add(TFchecking);


        JLabel JLsaving = new JLabel("Saving: $");
        JLsaving.setFont(MonoSpace);
        left.add(JLsaving);

        JTextField TFsaving = new JTextField();
        TFsaving.setColumns(14);
        left.add(TFsaving);

        JLabel JLdebt = new JLabel("Debt: $");
        JLdebt.setFont(MonoSpace);
        left.add(JLdebt);

        JTextField TFdebt = new JTextField();
        TFdebt.setColumns(16);
        left.add(TFdebt);

        JButton addShare = new JButton();
        addShare.setMargin(new Insets(5,100,5,100));
        addShare.setText("Add Share");
        addShare.setFont(MonoSpace);
        left.add(addShare);

        JButton clearShare = new JButton();
        clearShare.setMargin(new Insets(5,100,5,100));
        clearShare.setText("Add Share");
        clearShare.setFont(MonoSpace);
        left.add(clearShare);

        JLabel stockName1 = new JLabel("Stock Names:");
        stockName1.setSize(120,25);
        stockName1.setFont(new Font)
        left.add(stockName1);

        JComboBox <String> stockName2  = new JComboBox<>();
        stockName2.setSize(120,25);
        for(String stock:stocksAdded){
            stockName2.addItem(stock);
        }
        stockName2.setFont(MonoSpace);
        left.add(stockName2);

        frame.setVisible(true);


    }
    public void addCustomerSort()
    {

    }






}
