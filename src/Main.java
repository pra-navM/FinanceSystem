import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Main extends JPanel{
    private final Font ARIAL_30 = new Font("Arial", Font.PLAIN, 30);

    public static void main(String[] args)
    {
        Border line =  new LineBorder(Color.lightGray, 4);

        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1050,570);
        frame.setLayout(new FlowLayout());

        JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(250,300));
        left.setBackground(Color.lightGray);
        left.setBorder(line);
        frame.add(left);

        JPanel center = new JPanel();
        center.setPreferredSize(new Dimension(500,300));
        center.setBackground(Color.lightGray);
        center.setBorder(line);
        center.setLayout(new GridLayout(4,1));
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
        left.add(customerSort1);

        JComboBox <String> customerSort2  = new JComboBox<>();
        customerSort2.setSize(120,25);
        customerSort2.addItem("Debt");
        customerSort2.addItem("Aaron");
        customerSort2.addItem("Kevin");// replace with data
        left.add(customerSort2);

        JButton Alex = new JButton();
        Alex.setMargin(new Insets(5,100,5,100));
        Alex.setText("Add Customer");
        left.add(Alex);

        JLabel JLSSN = new JLabel("SSN:");
        left.add(JLSSN);

        JTextField TFSSN = new JTextField();
        TFSSN.setColumns(15);
        left.add(TFSSN);

        
        JLabel JLname = new JLabel("Name:");
        left.add(JLname);

        JTextField TFname = new JTextField();
        TFname.setColumns(14);
        left.add(TFname);


        JLabel JLchecking = new JLabel("Checking:");
        left.add(JLchecking);

        JTextField TFchecking = new JTextField();
        TFchecking.setColumns(13);
        left.add(TFchecking);









        frame.setVisible(true);


    }
    public void addCustomerSort()
    {

    }






}
