package com.mycompany.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Pair is a class representing a pair of child and parent names
 */
public class Pair {

    /** child name */
    private String childName;

    /** parent name */
    private String parentName;

    /**
     * Pair constructor
     *
     * @param childName child name
     * @param parentName parent name
     */
    public Pair(String childName, String parentName) {
        this.childName = childName;
        this.parentName = parentName;
    }

    /**
     * Get child name
     *
     * @return child name
     */
    public String getChildName() {
        return childName;
    }

    /**
     * Get parent name
     *
     * @return parent name
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * Generate an ArrayList of Pair objects from the given input file which contains child-parent pairs
     * 
     * @param fileName name of the input file containing child-parent pairs
     * @return ArrayList of Pair objects extracted from the input file
     * @throws Exception if input file can not be read
     */
    public static ArrayList<Pair> getPairsFromInput(String fileName) throws Exception {

        // Read input.txt file
        FileReader fileReader = null;

        try {
            ClassLoader classLoader = App.class.getClassLoader();
            File file = new File(classLoader.getResource(fileName).getFile());
            fileReader = new FileReader(file);
        } 
        catch (NullPointerException e) {
            throw new Exception("File " + fileName + " not found!");
        } catch (FileNotFoundException e) {
            throw new Exception("File " + fileName + " not found!");
        }

        // Instantiate a list for storing child-parent pairs
        ArrayList<Pair> pairs = new ArrayList<Pair>();

        // Read the file contents and extract child and parent names from each line
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] lineSplit = line.trim().split(" ");

                if(lineSplit.length == 2){

                    String childName = lineSplit[0].trim();
                    String parentName = lineSplit[1].trim();
                    pairs.add(new Pair(childName , parentName));
                }
            }

        } catch (IOException e) {
            throw new Exception("File reading went wrong!");
        } catch (Exception e) {
            throw new Exception("Something went wrong!");
        }

        return pairs;
    }
}
