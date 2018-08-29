package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * Tree Builder App
 *
 * This program creates and prints a tree structure from a list of child-parent pairs specified in src/main/resources/input.txt file
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
            String output = mainProgramMethod(inputFileName);

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
     * @return output string representing the tree structure extracted from the input file
     */
    public static String mainProgramMethod(String inputFileName){
        ArrayList<Pair> pairs = null;
        Map<String, Node> nodeHashMap = null;
        try {

            // Get pairs from input file
            pairs = Pair.getPairsFromInput(inputFileName);

            // Process pairs
            nodeHashMap = TreeUtils.processPairs(pairs);

        } catch (Exception e) {
            // If an exception is thrown then display a message to the user explaining what the problem was and exit the program
            System.out.println(e.getMessage());
            System.out.println("Program terminated");
            System.exit(1);
        }

        // Get first level nodes
        List<Node> firstLevelNodes = new ArrayList<Node>();
        for (Node node : nodeHashMap.values()){
            if(node.getParentNode() == null)
                firstLevelNodes.add(node);
        }

        // Output string builder is appended recursively - in the end it will contain properly formatted output
        StringBuilder outputStringBuilder = new StringBuilder();
        for (Node node : firstLevelNodes) {
            TreeUtils.printTree(node, 0, outputStringBuilder);
        }

        // Return output string
        return outputStringBuilder.toString();
    }
}
