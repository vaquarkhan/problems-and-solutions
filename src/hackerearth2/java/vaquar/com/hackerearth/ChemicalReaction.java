package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ChemicalReaction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// firstApproach();
		finalApproach();
	}

	private static void finalApproach() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			Map<Integer, List<String>> resultMap = new LinkedHashMap<Integer, List<String>>();
			if (test > 0 && test <= 10) {
				int loop = 0;
				while (test > loop) {
					int n = Integer.parseInt(br.readLine().trim());

					String[] nameArray = br.readLine().trim().split(" ");
					String[] timeArray = br.readLine().trim().split(" ");
					String[] orderArray = br.readLine().trim().split(" ");

					List<String> resultList = new ArrayList<String>();
					List<String> nameList = new ArrayList<String>();
					List<Integer> timeList = new ArrayList<Integer>();
					for (int i = 0; i < n; i++) {
						nameList.add(nameArray[i]);
						timeList.add(Integer.parseInt(timeArray[i]));
					}
					int resultTime = 0;
					for (int i = 0; i < orderArray.length; i++) {
						int order = Integer.parseInt(orderArray[i]) - 1;
						String resultName = nameList.get(order);
						Integer tempTime = timeList.get(order);
						if (tempTime > resultTime) {
							resultTime = tempTime;
						}
						resultList.add(resultName + " " + resultTime);
						nameList.remove(order);
						timeList.remove(order);
						if (i == nameArray.length - 2) {
							if (resultTime > timeList.get(0)) {
								resultList.add(nameList.get(0) + " "
										+ resultTime);
							} else {
								resultList.add(nameList.get(0) + " "
										+ timeList.get(0));
							}
							break;
						}

					}
					resultMap.put(loop, resultList);
					loop++;
				}
				for (Map.Entry<Integer, List<String>> res : resultMap
						.entrySet()) {
					for (int j = 0; j < res.getValue().size(); j++) {
						System.out.println(res.getValue().get(j));
					}
				}
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void firstApproach() {
		String cName = "zinc titanium barium lithium potassium sodium";
		String cTime = "999 799 600 140 7 100";
		String cOrder = "2 2 1 2 2";

		String[] nameArray = cName.split(" ");
		String[] timeArray = cTime.split(" ");
		String[] orderArray = cOrder.split(" ");

		List<String> nameList = new ArrayList<String>();
		List<Integer> timeList = new ArrayList<Integer>();
		for (int i = 0; i < nameArray.length; i++) {
			nameList.add(nameArray[i]);
			timeList.add(Integer.parseInt(timeArray[i]));
		}
		int resultTime = 0;
		for (int i = 0; i < orderArray.length; i++) {
			int order = Integer.parseInt(orderArray[i]) - 1;
			String resultName = nameList.get(order);
			Integer tempTime = timeList.get(order);
			if (tempTime > resultTime) {
				resultTime = tempTime;
			}
			System.out.println(resultName + " " + resultTime);
			nameList.remove(order);
			timeList.remove(order);
			if (i == nameArray.length - 2) {
				if (resultTime > timeList.get(0)) {
					System.out.println(nameList.get(0) + " " + resultTime);
				} else {
					System.out.println(nameList.get(0) + " " + timeList.get(0));
				}
				break;
			}

		}

	}

}
