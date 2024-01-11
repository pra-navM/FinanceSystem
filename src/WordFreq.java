import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordFreq {
    // Intializing variables
    public String fileName;
    public String text;
    public String leaderboard;
    // Class WordFreq. Takes in a filename, reads it, and removes most non-alphanumerical values
    // Assumptions are numbers are included. Combinations of numbers and letters are unique.
    // One word connected by a dash will be separated. Contractions will be unique from the words that make it

    // A problem with the code is that any non-contraction with an apostrophe keeps it
    public WordFreq(String filename) throws IOException {
        // Intializes map to be used to track string occurances
        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();

        // Starts tracking time
        long start = System.currentTimeMillis();

        // Reads the entire text file at once
        String text = new String(Files.readAllBytes(Paths.get(filename)));

        // Creates a string of all words that occur
        String[] words = text.toLowerCase().replaceAll("[`\".,!?:;<>@+(){}\\[\\]]", " ").replaceAll("\\s+'|'\\s+|--|\\b-|-\\b", " ").split("\\s+");
        // Adds all words to the map
        for (String word : words) {
            if (word.length() > 0) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }

        // Converts the map to a list
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordMap.entrySet());

        // Sorts the list based on the integer in descending order
        list.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        // Stops tracking time as code has ended
        long stop = System.currentTimeMillis();

        // Creates the text for leaderboard
        StringBuffer leaderboard = new StringBuffer();
        leaderboard.append("Time Taken: " + (stop-start) + "milliseconds\n\n");
        leaderboard.append("Top 20 Words\n\n");
        leaderboard.append("          Words               Frequency\n");
        for (int i = 1; i <= 20 && i < list.size(); i++) {
            String rank = i + ".";
            leaderboard.append(String.format("%-10s%-20s%d\n", rank, list.get(i).getKey(), list.get(i).getValue()));
        }

        // Assigning the variables of WordFreq
        this.fileName = fileName;
        this.text = text;
        this.leaderboard = leaderboard.toString();
    }
    // Getters
    public String getLeaderboard(){
        return leaderboard;
    }
    public String getText(){
        return text;
    }
}
