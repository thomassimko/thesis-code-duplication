package pdg;

import ast.expressions.left.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Scope {

    private List<HashMap<String, Identifier>> scopeList;
    private HashMap<String, Identifier> globalScope;
    private List<Identifier> variables;

    public Scope() {
        scopeList = new ArrayList<HashMap<String, Identifier>>();
        globalScope = new HashMap<String, Identifier>();
        variables = new ArrayList<Identifier>();

        scopeList.add(globalScope);
    }

    public void push() {
        HashMap<String, Identifier> newScope = new HashMap<String, Identifier>();
        scopeList.add(newScope);
    }

    public void pop() {
        scopeList.remove(scopeList.size() - 1);
    }

    public void addUse(String id) {

        for(HashMap<String, Identifier> scope : scopeList) {



        }


    }

/*
Variable Use:

1. It is defined in that block so you use that previous definition -- data depend
2. It is defined in the predecessor block and you use that definition -- control and data
3. There are 2 predecessors. Check them both. And check that they don't look at the same block
    a. If both define the variable, add those to data dependency
    b. If neither has them, continue searching their predecessors (performing the same thing if they have more than one predecessor as well
    c. If one has it, add the one as a data dependency and keep searching up the other one
4. If it is not in any block, then it has to be defined in global scope (or method arg) which I can get from my Scope obj


Variable Define:

1. Add to block as latest define (each block will have hash map showing the variable and latest define expression)


How to add dependency:

The use will get a data dependency added to it (or do we want it to be reversed?)






List<Id>
Each id will have a declaration




*/

}
