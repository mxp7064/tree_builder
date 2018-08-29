package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class containing automated tests
 */
class AppTest {

    /**
     * If there is a cyclic relationship TreeUtils.checkCyclicRelationship method should throw an Exception
     * Simulate a simple situation where we have parent node A, child node B and then node A as
     * a child to node B creating a cyclic relationship A->B->A
     */
    @Test
    void cyclicExceptionTesting() {
        Throwable exception = assertThrows(Exception.class, () -> {
            Node A = new Node("A");
            Node B = new Node("B");
            A.addChildNode(B);
            TreeUtils.checkCyclicRelationship(B, "A");
        });
        assertEquals("Cyclic relationship not allowed!", exception.getMessage());
    }

    /**
     * Test TreeUtils.generateTreeStructureString method to see if it generates the correct tree string structure for a simple situation of 
     * parent node A and child node B
     */
    @Test
    void printOutputTesting(){
        Node A = new Node("A");
        Node B = new Node("B");
        A.addChildNode(B);
        StringBuilder sb = new StringBuilder();
        TreeUtils.generateTreeStructureString(A, 0, sb);
        assertEquals("A" + System.lineSeparator() + TreeUtils.INDENT_STRING + "B" + System.lineSeparator(), sb.toString());   
    }

    /**
     * Test the main program method with valid input, this will effectively test the whole program
     * It shouldn't throw any Exceptions since input is valid
     */
    @Test
    void testMainProgramMethodWithValidInput() {
        String output = "";
        try{
            output = App.mainProgramMethod("input.txt");
        }
        catch(Exception e){
            fail("Should not have thrown any exception!");
        }
        
        assertEquals( 
        "Ivan" + System.lineSeparator() 
        + TreeUtils.INDENT_STRING + "Adam" + System.lineSeparator() 
        + TreeUtils.INDENT_STRING + TreeUtils.INDENT_STRING + "Stjepan" + System.lineSeparator() 
        + TreeUtils.INDENT_STRING + TreeUtils.INDENT_STRING + TreeUtils.INDENT_STRING + "Marko" + System.lineSeparator() 
        + TreeUtils.INDENT_STRING + TreeUtils.INDENT_STRING + TreeUtils.INDENT_STRING + "Robert" + System.lineSeparator() 
        + TreeUtils.INDENT_STRING + "Fran" + System.lineSeparator() 
        + "Luka" + System.lineSeparator() 
        + TreeUtils.INDENT_STRING + "Leopold" + System.lineSeparator(), output);   
    }

    /**
     * Test main program method with a border case valid input of a child having multiple parents
     * It shouldn't throw any Exceptions
     */
    @Test
    void testMainProgramMethodWithValidInputChildMultipleParents() {
        String output = "";
        try{
            output = App.mainProgramMethod("childHasMoreThanOneParent.txt");
        }
        catch(Exception e){
            fail("Should not have thrown any exception");
        }
        
        assertEquals( 
        "Pero" + System.lineSeparator() 
        + TreeUtils.INDENT_STRING + "Ivan" + System.lineSeparator() 
        + "Luka" + System.lineSeparator() 
        + TreeUtils.INDENT_STRING + "Ivan" + System.lineSeparator(), output);   
    }

    /**
     * Test main program method with invalid input which contains a cyclic relationship
     * It should throw an Exception
     */
    @Test
    void testMainProgramMethodWithCyclicInvalidInput(){
        Throwable exception = assertThrows(Exception.class, () -> {
            App.mainProgramMethod("cyclicInput.txt");
        });
        assertEquals("Cyclic relationship not allowed!", exception.getMessage());
    }
}