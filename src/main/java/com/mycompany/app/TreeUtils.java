package com.mycompany.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Tree Utils is a class providing utility methods for working with trees
 */
public class TreeUtils {

    /** Indent string constant */
    public static final String INDENT_STRING = "    ";

    /**
     * Checks recursively if there is a cyclic relationship from the given node upwards passing through node's parents
     *
     * @param node node from which to start traversing the tree upwards
     * @param nodeName name of the node to be checked for cyclic relationship
     * @return false if traversing doesn't find a cyclic relationship
     * @throws Exception if traversing finds a cyclic relationship
     */
    public static boolean checkCyclicRelationship (Node node, String nodeName) throws Exception {
        if(node.getName().equals(nodeName))
            throw new Exception("Cyclic relationship not allowed!");
        if(node.getParentNode() == null)
            return false;
        else
            return checkCyclicRelationship(node.getParentNode(), nodeName);
    }

    /**
     * Prints recursively the tree structure from the given node downwards with indentation
     *
     * @param node node from which to start traversing the tree downwards
     * @param indentationLevel indentation level
     * @param stringBuilder string builder which will be appended in each recursive call to build the final ouput String
     */
    public static void printTree (Node node, int indentationLevel, StringBuilder stringBuilder) {
        for (int i = 0; i < indentationLevel; i++) {
            stringBuilder.append(INDENT_STRING);
        }

        stringBuilder.append(node.getName());
        stringBuilder.append(System.lineSeparator());

        for (Node n : node.getChildNodes()) {
            printTree(n, indentationLevel + 1, stringBuilder);
        }
    }

    /**
     * Generate a Map from a list of pairs with keys being node names (effectively ids) and values being the actual Nodes
     * 
     * @param pairs ArrayList of Pair objects representing child-parent pairs
     * @return Map of (node name, Node) pairs
     * @throws Exception if there is a cyclic relationship
     */
    public static Map<String, Node> processPairs(ArrayList<Pair> pairs) throws Exception {

        // A map that is used to keep track of Nodes
        Map<String, Node> nodeHashMap = new HashMap<>();

        // Process pairs
        for (Pair pair: pairs){

            // PROCESS PARENT = if a given parent already exists in the HashMap then just retrieve it
            Node parentNode;
            if (nodeHashMap.containsKey(pair.getParentName())){
                parentNode = nodeHashMap.get(pair.getParentName());
            }
            else {
                // if it doesn't exist in the HashMap then create a new parent node and store it in the HashMap
                parentNode = new Node(pair.getParentName());
                nodeHashMap.put(pair.getParentName(), parentNode);

                // first level nodes have a null parent
                parentNode.setParentNode(null);
            }

            //  PROCESS CHILD - if a given child already exists in the HashMap then just retrieve it
            Node childNode;
            if (nodeHashMap.containsKey(pair.getChildName())){
                childNode = nodeHashMap.get(pair.getChildName());
            }
            else {
                // if it doesn't exist in the HashMap then create a new child node and store it in the HashMap
                childNode = new Node(pair.getChildName());
                nodeHashMap.put(pair.getChildName(), childNode);
            }

            // Check if there is a cyclic relationship before adding a child node to a parent
            // If it is, an exception will be raised
            if(!TreeUtils.checkCyclicRelationship(parentNode, childNode.getName())) {
                parentNode.addChildNode(childNode);
            }
        }

        return nodeHashMap;
    }
}
