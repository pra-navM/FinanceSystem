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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1050,570);
        frame.setLayout(new FlowLayout());

        JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(250,300));
        left.setBackground(Color.lightGray);
        left.setBorder(line);
        left.setLayout(new GridLayout(12,1));
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
        right.setLayout(new GridLayout(12,1));
        frame.add(right);

        JPanel bottomLeft = new JPanel();
        bottomLeft.setPreferredSize(new Dimension(250,200));
        bottomLeft.setBackground(Color.lightGray);
        bottomLeft.setBorder(line);
        bottomLeft.setLayout(new GridLayout(2,1));
        frame.add(bottomLeft);

        JPanel bottomCenter = new JPanel();
        bottomCenter.setPreferredSize(new Dimension(500,200));
        bottomCenter.setBackground(Color.lightGray);
        bottomCenter.setBorder(line);
        bottomCenter.setLayout(new GridLayout(7,1));
        frame.add(bottomCenter);

        JPanel bottomRight = new JPanel();
        bottomRight.setPreferredSize(new Dimension(250,200));
        bottomRight.setBackground(Color.lightGray);
        bottomRight.setBorder(line);
        bottomRight.setLayout(new GridLayout(7,1));
        frame.add(bottomRight);



        JComboBox <String> customerSort  = new JComboBox();
        customerSort.setSize(250,16);
        customerSort.set
        customerSort.addItem("Aaron");
        customerSort.addItem("Kevin");// replace with data
        left.add(customerSort);


        JButton Alex = new JButton();
        Alex.setSize(250,16);
        Alex.setText("Add Customer");
        left.add(Alex);







        frame.setVisible(true);


    }
    public void addCustomerSort()
    {

    }






}
