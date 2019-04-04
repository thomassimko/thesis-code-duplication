package cfg;

import ast.expressions.Expression;
import ast.expressions.left.Left;

import java.util.*;

public class LiveOutComparator implements Comparator<HashMap<Left, Set<Expression>>> {

    @Override
    public int compare(HashMap<Left, Set<Expression>> o1, HashMap<Left, Set<Expression>> o2) {

        Set<Expression> key1 = new HashSet<>(o1.keySet());
        Set<Expression> key2 = new HashSet<>(o2.keySet());

        if(key1.size() != key2.size() || !compareSets(key1, key2)) {
            return 1;
        }

        Left[] keyArr1 = key1.stream().toArray(Left[]::new);
        Left[] keyArr2 = key2.stream().toArray(Left[]::new);
        Arrays.sort(keyArr1);
        Arrays.sort(keyArr2);

        for(int i = 0; i < keyArr1.length; i++) {

            if(!compareSets(o1.get(keyArr1[i]), o2.get(keyArr2[i]))) {
                return 1;
            }
        }





        return 0;
    }

    private boolean compareSets(Set<Expression> set1, Set<Expression> set2) {

        if(set1 == null && set2 == null) {
            return true;
        } else if (set1 == null || set2 == null) {
            return false;
        }

        if(set1.size() != set2.size()) {
            return false;
        }

        String[] liveOutArr = set1.stream().map(Expression::toString).toArray(String[]::new);
        String[] newLiveOutArr = set2.stream().map(Expression::toString).toArray(String[]::new);
        Arrays.sort(liveOutArr);
        Arrays.sort(newLiveOutArr);

        for(int i = 0; i < liveOutArr.length; i++) {

            if(!liveOutArr[i].equals(newLiveOutArr[i])) {
                return false;
            }
        }
        return true;
    }
}
