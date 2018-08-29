package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Node is a class representing a node within a non-binary tree
 */
public class Node {

    /** Name (data) of the node */
    private String name;

    /** Parent node */
    private Node parentNode;

    /** Child nodes */
    private List<Node> childNodes;

    /**
     * Default Node constructor
     * 
     * @param name node name
     */
    public Node(String name) {
        this.name = name;
        this.childNodes = new ArrayList<Node>();
    }

    /**
     * Get parent node
     *
     * @return parent node
     */
    public Node getParentNode() {
        return parentNode;
    }

    /**
     * Set parent node
     *
     * @param parentNode parent node
     */
    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    /**
     * Get node name
     *
     * @return node name
     */
    public String getName() {
        return name;
    }

    /**
     * Set node name
     *
     * @param name node name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get child nodes
     *
     * @return child nodes
     */
    public List<Node> getChildNodes() {
        return childNodes;
    }

    /**
     * Add child node
     *
     * @param childNode child node to be added
     */
    public void addChildNode(Node childNode){
        if(!this.childNodes.contains(childNode))
            this.childNodes.add(childNode);
    }
}