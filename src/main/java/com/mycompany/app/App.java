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
     * Main method
     *
     * @param args main method arguments
     */
    public static void main(String[] args) {

        if(args.length > 0){

            // Get argument - name of the input file
            String inputFileName = args[0];

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
                return;
            }

            // Get first level nodes
            List<Node> firstLevelNodes = new ArrayList<Node>();
            for (Node node : nodeHashMap.values()){
                if(node.getParentNode() == null)
                    firstLevelNodes.add(node);
            }

            // Print the tree
            for (Node node : firstLevelNodes) {
                TreeUtils.printTree(node, 0);
            }
          

        } else {
            System.out.println("Please provide input file name");
        }
    }
}
