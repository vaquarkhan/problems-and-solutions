package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RoyAndTrendingTopic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstApproach();
	}

	private static void firstApproach() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			if (test > 0) {
				int loop = 0;
				Map<Long, Long> topicIdAndSD = new HashMap<Long, Long>();
				Map<Long, Long> topicIdAndNS = new LinkedHashMap<Long, Long>();
				while (test > loop) {
					// Topic ID, current z-score - Z, Posts - P, Likes - L,
					// Comments - C, Shares - S
					String str = br.readLine();
					String[] split = str.split(" ");
					long topicId = Long.parseLong(split[0]);
					long currentScore = Long.parseLong(split[1]);
					long post = Long.parseLong(split[2]);
					long like = Long.parseLong(split[3]);
					long comment = Long.parseLong(split[4]);
					long share = Long.parseLong(split[5]);

					long newScore = (50 * post) + (5 * like) + (10 * comment)
							+ (20 * share);
					long scoreDiff = newScore - currentScore;
					topicIdAndSD.put(topicId, scoreDiff);
					topicIdAndNS.put(topicId, newScore);

					loop++;
				}

				mapManuplations(topicIdAndSD, topicIdAndNS);
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void mapManuplations(Map<Long, Long> topicIdAndSD,
			Map<Long, Long> topicIdAndNS){
		ValueComparatorForRoyAndTrending bvc = new ValueComparatorForRoyAndTrending(
				topicIdAndSD);
		Map<Long, Long> sorted_map = new TreeMap<Long, Long>(bvc);
		sorted_map.putAll(topicIdAndSD);
		// System.out.println("New_Score unsorted Map" + topicIdAndNS);
		// System.out.println("sorted Map" + sorted_map);
		Map<Long, Long> resultMap = new LinkedHashMap<Long, Long>();
		Set<Long> keySet = sorted_map.keySet();
		List<Long> keyList = new ArrayList<Long>(keySet);
		for (Map.Entry<Long, Long> iterable_element : topicIdAndNS.entrySet()) {

			for (int i = 0; i < 5; i++) {
				// System.out.println("iterable_element.getKey() :"
				// +iterable_element.getKey());
				// System.out.println("keyList.get(i) :" +keyList.get(i));
				if (keyList.get(i).longValue() == iterable_element.getKey()) {
					resultMap.put(iterable_element.getKey(),
							iterable_element.getValue());
				}
			}
		}
		// System.out.println("Result : " + resultMap);
		for (Map.Entry<Long, Long> result : resultMap.entrySet()) {
			System.out.println(result.getKey() + " " + result.getValue());
		}
	}

}

class ValueComparatorForRoyAndTrending implements Comparator<Long> {

	public static void main(String args[]){
		
	}
	Map<Long, Long>	base;

	public ValueComparatorForRoyAndTrending(Map<Long, Long> base) {
		this.base = base;
	}

	// Note: this comparator imposes orderings that are inconsistent with
	// equals.
	public int compare(Long a, Long b) {
		if (base.get(a) >= base.get(b)) {
			return -1;
		} else {
			return 1;
		} // returning 0 would merge keys
	}
}
