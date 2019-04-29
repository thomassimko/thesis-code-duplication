package graph;

import ast.expressions.Expression;

import java.util.*;
import java.util.stream.Collectors;

public class Mapping {

    private Map<Expression, Expression> map;

    private final String keyFile;
    private final int keyMin;
    private final int keyMax;

    private final String valueFile;
    private final int valueMin;
    private final int valueMax;

    public Mapping(Map<Expression, Expression> initial) {
        int[] keyRange = getRange(initial.keySet());
        keyMin = keyRange[0];
        keyMax = keyRange[1];

        int[] valueRange = getRange(initial.values());
        valueMin = valueRange[0];
        valueMax = valueRange[1];

        keyFile = initial.keySet().iterator().next().getFile();
        valueFile = initial.values().iterator().next().getFile();

        map = new TreeMap<>(new LineOrderingComparator());
        for(Expression key : initial.keySet()) {
            map.put(key, initial.get(key));
        }

    }

    private int[] getRange(Collection<Expression> set) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(Expression exp : set) {
            min = Math.min(exp.getLine(), min);
            max = Math.max(exp.getLine(), max);
        }

        return new int[]{min, max};
    }

    public int getSize() {
        return map.size();
    }

    public Map<Expression, Expression> getMap() {
        return map;
    }

    public boolean isSubMapping(Mapping subMapping) {

        //if they are the same files
        if(keyFile.equals(subMapping.keyFile) && valueFile.equals(subMapping.valueFile)) {

            //if one is a subset range of the other
            return (keyMin <= subMapping.keyMin && keyMax >= subMapping.keyMax &&
                valueMin <= subMapping.valueMin && valueMax >= subMapping.valueMax);
        }
        return false;

        //return subMapping.getMap().entrySet().containsAll(map.entrySet());
    }

    public String getKeyFile() {
        return keyFile;
    }

    public int getKeyMin() {
        return keyMin;
    }

    public int getKeyMax() {
        return keyMax;
    }

    public String getValueFile() {
        return valueFile;
    }

    public int getValueMin() {
        return valueMin;
    }

    public int getValueMax() {
        return valueMax;
    }

    public Mapping getReverse() {
        return new Mapping(map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey)));
    }

    public String toString() {
        return (keyFile + " lines [" + keyMin + ", " + keyMax + "] and "
                + valueFile + " lines [" + valueMin + ", " + valueMax + "]");
    }


}
