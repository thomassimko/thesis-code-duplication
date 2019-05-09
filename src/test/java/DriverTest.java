import ast.Program;
import ast.expressions.Expression;
import cfg.CFGBlock;
import cfg.StartBlock;
import graph.GraphComparison;
import graph.Mapping;
import main.ArgumentHandler;
import main.OutputFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    @BeforeEach
    void setUp() {
        ArgumentHandler.verbose = true;
    }

    @Test
    void TestCase1() {
        List<Mapping> mappings = Driver.run("../test/inputs/TestCases/TestCase1");
        OutputFormatter.printFilesAndLines(mappings);
        assertNotEquals(0, mappings.size());
    }

    @Test
    void TestCase2() {
        List<Mapping> mappings = Driver.run("../test/inputs/TestCases/TestCase2");
        OutputFormatter.printFilesAndLines(mappings);
        assertNotEquals(0, mappings.size());
    }

    @Test
    void TestCase3() {
        List<Mapping> mappings = Driver.run("../test/inputs/TestCases/TestCase3");
        OutputFormatter.printFilesAndLines(mappings);
        assertNotEquals(0, mappings.size());
    }

    @Test
    void TestCase4() {
        List<Mapping> mappings = Driver.run("../test/inputs/TestCases/TestCase4");
        OutputFormatter.printFilesAndLines(mappings);
        assertNotEquals(0, mappings.size());
    }

    @Test
    void TestCase5() {
        List<Mapping> mappings = Driver.run("../test/inputs/TestCases/TestCase5");
        OutputFormatter.printFilesAndLines(mappings);
        assertNotEquals(0, mappings.size());
    }

    @Test
    void TestCase6() {
        List<Mapping> mappings = Driver.run("../test/inputs/TestCases/TestCase6");
        OutputFormatter.printFilesAndLines(mappings);
        assertNotEquals(0, mappings.size());
    }

    @Test
    void TestCase7() {
        List<Mapping> mappings = Driver.run("../test/inputs/TestCases/TestCase7");
        OutputFormatter.printFilesAndLines(mappings);
        assertNotEquals(0, mappings.size());
    }

    @Test
    void TestCase8() {
        List<Mapping> mappings = Driver.run("../test/inputs/TestCases/TestCase8");
        OutputFormatter.printFilesAndLines(mappings);
        assertNotEquals(0, mappings.size());
    }

    @Test
    void TestCase9() {
        List<Mapping> mappings = Driver.run("../test/inputs/TestCases/TestCase9");
        OutputFormatter.printFilesAndLines(mappings);
        assertNotEquals(0, mappings.size());
    }

    @Test
    void TestCase10() {
        List<Mapping> mappings = Driver.run("../test/inputs/TestCases/TestCase10");
        OutputFormatter.printFilesAndLines(mappings);
        assertNotEquals(0, mappings.size());
    }

    @Test
    void TestCase11() {
        List<Mapping> mappings = Driver.run("../test/inputs/TestCases/TestCase11");
        OutputFormatter.printFilesAndLines(mappings);
        assertNotEquals(0, mappings.size());
    }
}