package hackerearth.java.com.vaquar.zooplus.LocationVisit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
	Solution solution = new Solution();
	System.out.println(solution.solution(new int[] { 7, 3, 7, 7, 1, 3, 4, 1, 5 }));
    }

    public int solution(int[] A) {

	Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();

	Set<Integer> set = new HashSet<Integer>();
	for (int i = 0; i <= A.length - 1; i++) {

	    set.add(A[i]);

	}
	resetMap(set, map);

	int count = 0;
	int length = 0;
	int lessSize = 9999999;
	for (int i = 0; i <= A.length - 1; i++) {
	    for (int j = i; j <= A.length - 1; j++) {
		if (map.containsKey(A[j]) && map.get(A[j]) == false) {
		    map.put(A[j], true);
		    count++;
		    length++;

		    if (count == set.size()) {
			resetMap(set, map);
			count = 0;
			if (length < lessSize) {
			    lessSize = length;
			    length = 0;

			}
			break;
		    }
		} else {
		    length++;
		}
	    }
	}

	return lessSize;
    }

    private void resetMap(Set<Integer> set, Map<Integer, Boolean> map) {
	for (int i : set) {
	    map.put(i, false);
	}
    }

}
