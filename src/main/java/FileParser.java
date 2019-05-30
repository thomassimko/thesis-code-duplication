import ast.Program;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

    public static Program parseFiles(String directory) {
        try {
            List<File> files = new ArrayList<>();
            listf(directory, files);
            Program program = new Program();
            for (File file : files) {
                CharStream stream = CharStreams.fromFileName(file.getAbsolutePath());
                Driver.currentFileName = file.getPath();
                System.out.println(Driver.currentFileName);
                Java8Lexer lexer = new Java8Lexer(stream);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                Java8Parser parser = new Java8Parser(tokens);
                ParserRuleContext tree = parser.compilationUnit(); // parse

                MyVisitor visitor = new MyVisitor();
                program.addClasses(visitor.visit(tree).getClasses());
            }
            return program;
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return null;
    }

    private static void listf(String directoryName, List<File> files) {
        File directory = new File(directoryName);

        if (directory.isFile() && directory.getName().endsWith(".java")) {
            files.add(directory);
        } else {

            File[] fList = directory.listFiles();
            if (fList != null) {
                for (File file : fList) {
                    if (file.isFile() && file.getName().endsWith(".java")) {
                        files.add(file);
                    } else if (file.isDirectory()) {
                        listf(file.getPath(), files);
                    }
                }
            }
        }
    }
}

