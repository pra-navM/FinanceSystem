import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Main extends JPanel{
    JFrame mainFrame;
    JPanel mainName, sort, SSN1, SSN2, Name1, Name2, Checking1, Checking2, Savings1, Savings2,
    Debt1, Debt2, rightStockName, stockType, numOfShares,textPreview,
    customerName, stocksAndShorts, mainBox, checking1, checking2,  savings1, savings2, changesavings, debt1, debt2,
    changeDebt, resetAccountValues, netValue, updatePositions, changeStockShort, stock, changeShare1, changeShare2,
    editStocks, leftStockName, value1, value2, changeValue, cap1, cap2, changeCap, resetStockValues, numOfStocksBought,
    numOfShortsHeld, addStock, stockName1, stockName2, stockValue1, stockValue2, stockCap1, stockCap2, viewStockHistory;

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
