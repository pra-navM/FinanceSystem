// Alexander Shen - Assignment 6 - 2023/12/19
// A program that reads a file, removes unnecessary text, and finds the top 20 words that occur the most
// It displays the file itself, time taken, and the leaderboard for words that occurred most often.
// There is the option to add new files from the directory, as well as being able to choose from all existing files.

// The main file handles JFrame and images, while the class WordFreq handles reading the text file creating all the information.

// Imports
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Font;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class delete implements ActionListener{
    // Creating all JFrame components
    JFrame frame;
    JPanel mainPanel;
    JPanel buttonPanel;
    JPanel choicePanel;
    JPanel textPanel;
    JPanel leaderPanel;
    JScrollPane textScroll;
    JTextArea leaderText;
    JButton addFileButton;
    JTextArea fileText;
    JComboBox<String> filesAdded;
    // HashMap to store what files are in
    HashMap<String, WordFreq> fileMap;

    public delete() {
        // Intializing the map, frame, and main panel
        fileMap = new HashMap<>();
        frame = new JFrame("Word Frequency Tracker");
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Sets up the button to add new files
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        addFileButton = new JButton("Add File");
        addFileButton.addActionListener(this);
        addFileButton.setActionCommand("addFile");
        buttonPanel.add(addFileButton);

        // Sets up the list of files to be chosen from
        choicePanel = new JPanel();
        choicePanel.setLayout(new GridLayout(0, 1));
        filesAdded = new JComboBox<>();
        filesAdded.addActionListener(this);
        filesAdded.setActionCommand("selectFile");
        choicePanel.add(filesAdded);

        // Sets up the file text panel
        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.X_AXIS));
        textScroll = new JScrollPane(textPanel);
        textScroll.setHorizontalScrollBar(null);
        fileText = new JTextArea();
        fileText.setLineWrap(true);
        fileText.setEditable(false);
        fileText.setFont(new Font(Font.MONOSPACED, Font.PLAIN,12));
        textPanel.add(fileText);

        // Sets up the leaderboard panel
        leaderPanel = new JPanel();
        leaderPanel.setLayout(new GridLayout(1, 1));
        leaderText = new JTextArea();
        leaderText.setLineWrap(true);
        leaderText.setEditable(false);
        leaderText.setFont(new Font(Font.MONOSPACED, Font.PLAIN,12));
        leaderPanel.add(leaderText);

        // Sets up the main panel
        mainPanel.add(buttonPanel);
        mainPanel.add(choicePanel);
        mainPanel.add(textScroll);

        JPanel finalPanel = new JPanel();
        finalPanel.setLayout(new GridLayout(0, 2));
        finalPanel.add(mainPanel);
        finalPanel.add(leaderPanel);
        finalPanel.setPreferredSize(new Dimension(1200, 800));

        // Sets up the frame
        frame.add(finalPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Adds Alice and Moby
        try {
            WordFreq stat = new WordFreq("ALICE.TXT");
            fileMap.put("ALICE.TXT", stat);
            filesAdded.addItem("ALICE.TXT");
            stat = new WordFreq("MOBY.TXT");
            fileMap.put("MOBY.TXT", stat);
            filesAdded.addItem("MOBY.TXT");
            filesAdded.setSelectedIndex(0);
        } catch (Exception e) {}

    }
    // Checks that the file is not already in the list of files
    private boolean fileIn(String filename) {
        for (int i = 0; i < filesAdded.getItemCount(); i++) {
            if (filesAdded.getItemAt(i).equals(filename)) {
                return false;
            }
        }
        return true;
    }

    // Action listener for adding files and choosing list of files
    public void actionPerformed(ActionEvent event) {
        // Button to open system directory to add new files
        if(event.getActionCommand()=="addFile") {
            FileDialog dialog = new FileDialog(frame, "Add File", FileDialog.LOAD);
            dialog.setVisible(true);
            String fileName = dialog.getFile();
            String directory = dialog.getDirectory();
            if (fileName != null && fileIn(fileName)) {
                try {
                    WordFreq newFile = new WordFreq(directory + fileName);
                    fileMap.put(fileName, newFile);
                    filesAdded.addItem(fileName);
                    filesAdded.setSelectedItem(fileName);
                } catch (IOException e1) {
                }
            }
        }
        // Chooses a file from the list to get the information of
        else {
            String filename = (String) filesAdded.getSelectedItem();
            WordFreq stat = fileMap.get(filename);
            fileText.setText(stat.getText());
            fileText.setCaretPosition(0);
            leaderText.setText(stat.getLeaderboard());
        }
    }
    public static void main(String[] args) {
        new Main();
    }
}