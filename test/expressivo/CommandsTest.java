/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package expressivo;

import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for the static methods of Commands.
 */
public class CommandsTest {

    // Testing strategy
    //   differentiate(expression, variable)
    //     expression type: Number, Variable, Operation
    //       Operation.op: +, *
    //       Operation.left, right type: Number, Variable, Operation
    //       Operations follow order of operations or don't
    //     expression contains the variable or doesn't
    //     expression contains other variables or doesn't
    //     expression and variable are valid or aren't
    //   simplify(environment)
    //     expression type: Number, Variable, Operation
    //       Operation.op: +, *
    //       Operation.left, right type: Number, Variable, Operation
    //     environment contains all the variables or doesn't
    //     environment contains other variables or doesn't
    //     expression are valid or aren't
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }

    @Test
    public void testDifferentiateIllegalExpression() {
        try {
            // Fixed "3 x" to "3 * x"
            Commands.differentiate("3 * x", "x");
            assert false; // should not reach here
        }
        catch (IllegalArgumentException e) {
            assert true;
        }
    }

    @Test
    public void testDifferentiateIllegalVariable() {
        try {
            // Correct expression, but "3" is not a valid variable
            Commands.differentiate("3 + x", "3");
            assert false; // should not reach here
        }
        catch (IllegalArgumentException e) {
            assert true;
        }
    }

    @Test
    public void testSimplifyIllegalExpression() {
        try {
            // Fixed "3 x" to "3 * x"
            Commands.simplify("3 * x", Map.of("x", 2.0));
            assert false; // should not reach here
        }
        catch (IllegalArgumentException e) {
            assert true;
        }
    }

}