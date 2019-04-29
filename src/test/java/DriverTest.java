import ast.Program;
import ast.expressions.Expression;
import cfg.CFGBlock;
import cfg.StartBlock;
import graph.GraphComparison;
import graph.Mapping;
import main.OutputFormatter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    @Test
    void TestCase1() {
        List<Mapping> mappings = Driver.run("testFiles/TestCases/TestCase1");
        assertNotEquals(0, mappings.size());
    }

    @Test
    void TestCase2() {
        List<Mapping> mappings = Driver.run("testFiles/TestCases/TestCase2");
        assertNotEquals(0, mappings.size());
    }

    @Test
    void TestCase3() {
        List<Mapping> mappings = Driver.run("testFiles/TestCases/TestCase3");
        assertNotEquals(0, mappings.size());
    }

    @Test
    void TestCase4() {
        List<Mapping> mappings = Driver.run("testFiles/TestCases/TestCase4");
        assertNotEquals(0, mappings.size());
    }

    @Test
    void TestCase5() {
        List<Mapping> mappings = Driver.run("testFiles/TestCases/TestCase5");
        assertNotEquals(0, mappings.size());
    }

    @Test
    void TestCase6() {
        List<Mapping> mappings = Driver.run("testFiles/TestCases/TestCase6");
        assertNotEquals(0, mappings.size());
    }

    @Test
    void TestCase7() {
        List<Mapping> mappings = Driver.run("testFiles/TestCases/TestCase7");
        assertNotEquals(0, mappings.size());
    }

    @Test
    void TestCase8() {
        List<Mapping> mappings = Driver.run("testFiles/TestCases/TestCase8");
        assertNotEquals(0, mappings.size());
    }

    @Test
    void TestCase9() {
        List<Mapping> mappings = Driver.run("testFiles/TestCases/TestCase9");
        assertNotEquals(0, mappings.size());
    }

    @Test
    void TestCase10() {
        List<Mapping> mappings = Driver.run("testFiles/TestCases/TestCase10");
        assertNotEquals(0, mappings.size());
    }

    @Test
    void TestCase11() {
        List<Mapping> mappings = Driver.run("testFiles/TestCases/TestCase11");
        assertNotEquals(0, mappings.size());
    }
}