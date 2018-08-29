package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JUnit5Tests {
 
    @Test
    void justAnExample() {
        System.out.println("This test method should be run");
    }

    @Test
    void cyclicExceptionTesting() {
        Throwable exception = assertThrows(Exception.class, () -> {
            Node A = new Node("A");
            Node B = new Node("B");
            B.setParentNode(A);
            TreeUtils.checkCyclicRelationship(B, "A");
        });
        assertEquals(exception.getMessage(), "Cyclic relationship not allowed!");
    }
}