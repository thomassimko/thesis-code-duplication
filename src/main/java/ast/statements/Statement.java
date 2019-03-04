package ast.statements;

import ast.expressions.left.Left;
import ast.interfaces.BlockStatement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Statement implements BlockStatement {

    int line;
    String file;

    public Statement(String file, int line) {
        this.file = file;
        this.line = line;
    }

    public void pushScope(List<Map<String, Left>> scope) {
        Map<String, Left> newMap = new HashMap<String, Left>();
        scope.add(newMap);
    }

    public void popScope(List<Map<String, Left>> scope) {
        scope.remove(scope.size() - 1);
    }
}
