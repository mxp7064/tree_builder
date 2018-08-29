package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JUnit5Tests {

    @Test
    void cyclicExceptionTesting() {
        Throwable exception = assertThrows(Exception.class, () -> {
            Node A = new Node("A");
            Node B = new Node("B");
            A.addChildNode(B);
            TreeUtils.checkCyclicRelationship(B, "A");
        });
        assertEquals(exception.getMessage(), "Cyclic relationship not allowed!");
    }

    @Test
    void printOutputTesting(){
        Node A = new Node("A");
        Node B = new Node("B");
        A.addChildNode(B);
        StringBuilder sb = new StringBuilder();
        TreeUtils.printTree(A, 0, sb);
        assertEquals(sb.toString(), "A" + System.lineSeparator() + TreeUtils.INDENT_STRING + "B" + System.lineSeparator());   
    }

    @Test
    void testMainProgramMethod(){
        String output = App.mainProgramMethod("input.txt");
        assertEquals(output, 
        "Ivan" + System.lineSeparator() 
        + TreeUtils.INDENT_STRING + "Adam" + System.lineSeparator() 
        + TreeUtils.INDENT_STRING + TreeUtils.INDENT_STRING + "Stjepan" + System.lineSeparator() 
        + TreeUtils.INDENT_STRING + TreeUtils.INDENT_STRING + TreeUtils.INDENT_STRING + "Marko" + System.lineSeparator() 
        + TreeUtils.INDENT_STRING + TreeUtils.INDENT_STRING + TreeUtils.INDENT_STRING + "Robert" + System.lineSeparator() 
        + TreeUtils.INDENT_STRING + "Fran" + System.lineSeparator() 
        + "Luka" + System.lineSeparator() 
        + TreeUtils.INDENT_STRING + "Leopold" + System.lineSeparator());   
    }
}