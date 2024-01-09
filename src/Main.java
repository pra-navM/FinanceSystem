import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Main extends JPanel{
    JFrame mainFrame;
    JPanel left, middle, right;
    JButton addCustomer, addShares, clearShares, addFile,changeChecking, changeSavings, changeDebt, resetValues1,
    updatePositions, changeStocksShorts, editStocks, changeValue,changeCap, resetValues2, addStock, viewStockHistory;
    JTextField SSNTextField, nameTextField, checkingTextField, savingsTextField, debtTextField, numOfSharesTextField,
    checking2TextField, savings2TextField, debt2TextField, changeShareTextField, valueTextField, capTextField, name2TextField, value2TextField, cap2TextField;
    JLabel SSNLabel, nameLabel, checkingLabel, savingsLabel, debtLabel, numofSharesLabel, stocksAndShortsLabel, typeLabel, checkingLabel2, savingsLabel2, debtLabel2,
    changeShareLabel, valueLabel, capLabel, nameLabel2, valueLabel2, capLabel2;

    private final Font ARIAL_30 = new Font("Arial", Font.PLAIN, 30);
    public Main()
    {
        setPreferredSize(new Dimension(600, 480));
        setBackground(new Color(200, 200, 200));
        setFont(ARIAL_30);
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
// Will draw in the set colour until the colour is changed
        g.setColor(Color.BLUE);
// Draws a title in the top centre of the screen
        String title = "Text in the Window";
        int xPos = (int) ((this.getWidth() - this.getFontMetrics(ARIAL_30)

                .getStringBounds(title, g).getWidth()) / 2);

        g.drawString(title, xPos, 100);
// Draws some shapes in different colours
        g.setColor(Color.RED);
        g.drawRect(150, 125, 200, 100);
        g.fillRect(50, 150, 50, 100);
        g.setColor(Color.GREEN);
        g.fillOval(300,250, 100, 75);
    }
    public static void main(String[] args)
    {
// Create a simple JFrame to hold the GraphicsWindow panel
        JFrame frame = new JFrame("Simple Graphics Window");
// Create and add this panel to the frame and then launch the frame
        Main myPanel = new Main();
        frame.add(myPanel);
        frame.pack();
        frame.setVisible(true);
    }






}
