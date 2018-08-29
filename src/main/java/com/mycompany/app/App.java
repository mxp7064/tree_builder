package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * Tree Builder App
 *
 * This program creates and prints a tree structure from a list of child-parent pairs specified in a text file
 *
 * App is a class containing the main method of the program
 *
 * @author Marko Pancirov
 */
public class App {

    /**
     * Main method - takes the input file name as an argument, calls the main program method to process it and 
     * prints the output
     *
     * @param args main method arguments
     */
    public static void main(String[] args) {

        if(args.length > 0){

            // Get argument - name of the input file
            String inputFileName = args[0];

            // Run main program method
            String output = "";
            try {
                output = mainProgramMethod(inputFileName);
            } catch (Exception e) {
                // If an exception is thrown then display a message to the user explaining what the problem was and exit the program
                System.out.println(e.getMessage());
                System.out.println("Program terminated");
                System.exit(1);
            }

            // Print the output
            System.out.println(output);

        } else {
            System.out.println("Please provide input file name");
        }
    }

    /**
     * Main program method which takes the input file name as input, calls all of the neccessary program
     * methods to process the input and returns the string output representing the tree structure extracted
     * from the input file. Output string is formatted with indentation and line separators to represent the
     * tree structure.
     * 
     * @param inputFileName input file name
     * @return String representing the tree structure extracted from the input file
     */
    public static String mainProgramMethod(String inputFileName) throws Exception{

        ArrayList<Pair> pairs = null;// ArrayList of Pairs representing child-parent pairs
        Map<String, Node> nodeHashMap = null;// Map which is used to map Node names to Nodes

        // Get child-parent pairs from the input file
        pairs = Pair.getPairsFromInput(inputFileName);

        // Process pairs - generate Node Map with relationships set between the Nodes
        nodeHashMap = TreeUtils.processPairs(pairs);

        // Get first level nodes
        List<Node> firstLevelNodes = new ArrayList<Node>();
        for (Node node : nodeHashMap.values()){
            if(node.getParentNode() == null)
                firstLevelNodes.add(node);
        }

        // Generate output String using StringBuilder
        // Output string builder is appended recursively and it contains formatted output
        StringBuilder outputStringBuilder = new StringBuilder();
        for (Node node : firstLevelNodes) {
            TreeUtils.generateTreeStructureString(node, 0, outputStringBuilder);
        }

        // Return output string
        return outputStringBuilder.toString();
    }
}
