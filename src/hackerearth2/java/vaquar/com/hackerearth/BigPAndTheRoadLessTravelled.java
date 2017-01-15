package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BigPAndTheRoadLessTravelled {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstApproach();
	}

	private static void firstApproach() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			String xAndY = null;
			List<String> list = new ArrayList<String>();
			while (true) {
				xAndY = br.readLine();
				if (!xAndY.equals("0 0")) {
					list.add(xAndY);
				} else {
					break;
				}

			}
			int oneCount = 0;
			for (String str : list) {
				String[] split = str.split(" ");
				int x = Integer.parseInt(split[0]);
				int y = Integer.parseInt(split[1]);
				if (x == 1) {
					
					oneCount++;
				}
			}
			
			for (int i = 0; i < oneCount; i++) {
				String oneStr = list.get(i);
				String[] sp = oneStr .split(" ");
				int start = Integer.parseInt(sp[0]);
				int end = Integer.parseInt(sp[1]);
				for (int j = oneCount; j < list.size(); j++) {
					String othrStr = list.get(j);
					String[] othSp = othrStr .split(" ");
					int otherStart = Integer.parseInt(othSp[0]);
					int otherEnd = Integer.parseInt(othSp[1]);
				}
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
