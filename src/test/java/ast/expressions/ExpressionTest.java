package ast.expressions;

import ast.expressions.left.Identifier;
import ast.expressions.left.LeftIdDot;
import ast.literal.IntLiteral;
import main.ArgumentHandler;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionTest {

    @Test
    public void equals() {

        Identifier id1 = new Identifier("Test", 0, "var1");
        Identifier id2 = new Identifier("Test", 0, "var2");

        LeftIdDot dot1 = new LeftIdDot("Test", 0, "id", id1);


        IntLiteral int1 = new IntLiteral("Test", 0, 5);
        IntLiteral int2 = new IntLiteral("Test", 0, 6);
        IntLiteral int3 = new IntLiteral("Test", 0, 10);
        IntLiteral int4 = new IntLiteral("Test", 0, 5);

        BinaryExpression binaryExpression1 = new BinaryExpression("Test", 0, "+", int1, int2);
        BinaryExpression binaryExpression2 = new BinaryExpression("Test", 0, "+", int1, int2);
        BinaryExpression binaryExpression3 = new BinaryExpression("Test", 0, "+", int2, int3);
        BinaryExpression binaryExpression4 = new BinaryExpression("Test", 0, "-", int2, int3);

        AssignmentExpression asgn1 = new AssignmentExpression("Test", 0, id1, "=", binaryExpression1);
        AssignmentExpression asgn2 = new AssignmentExpression("Test", 0, id2, "=", binaryExpression1);
        AssignmentExpression asgn3 = new AssignmentExpression("Test", 0, id1, "=", binaryExpression3);

        assertEquals(0, id1.graphicalCompareTo(id2));
        assertEquals(-1, id1.graphicalCompareTo(dot1));

        ArgumentHandler.checkLeft = false;

        assertEquals(0, id1.graphicalCompareTo(id2));
        assertEquals(0, id1.graphicalCompareTo(dot1));

        ArgumentHandler.checkLeft = true;

        assertEquals(0, int1.graphicalCompareTo(int2));
        assertEquals(0, int1.graphicalCompareTo(int3));
        assertEquals(0, int3.graphicalCompareTo(int2));
        ArgumentHandler.checkLiterals = true;

        assertEquals(-1, int1.graphicalCompareTo(int2));
        assertEquals(-1, int1.graphicalCompareTo(int3));
        assertEquals(-1, int3.graphicalCompareTo(int2));
        assertEquals(0, int1.graphicalCompareTo(int4));

        ArgumentHandler.checkLiterals = false;

        assertEquals(0, binaryExpression1.graphicalCompareTo(binaryExpression2));
        assertEquals(0, binaryExpression2.graphicalCompareTo(binaryExpression3));
        assertEquals(-1, binaryExpression3.graphicalCompareTo(binaryExpression4));

        assertEquals(0, asgn1.graphicalCompareTo(asgn2));
        assertEquals(0, asgn2.graphicalCompareTo(asgn3));

    }


}