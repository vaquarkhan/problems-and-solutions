package hackerearth2.java.vaquar.com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BestInternetBrowser {

	public static void main(String args[]) throws Exception {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String a = br.readLine();
			if (Integer.valueOf(a) > 0 && Integer.valueOf(a) <= 100) {
				int count = 0;
				String result[] = new String[Integer.valueOf(a)];
				while (count < Integer.valueOf(a)) {
					String webSite = br.readLine();
					String sub = webSite.substring(webSite.indexOf(".") + 1,
							webSite.lastIndexOf("."));
					String[] array = new String[sub.length()];
					for (int i = 0; i < array.length; i++) {
						String substring = sub.substring(i, i + 1);
						if (substring.equalsIgnoreCase("a")
								|| substring.equalsIgnoreCase("e")
								|| substring.equalsIgnoreCase("i")
								|| substring.equalsIgnoreCase("o")
								|| substring.equalsIgnoreCase("u")) {
							substring = "";
						}
						array[i] = substring;
					}
					String res = "";
					for (String string : array) {
						res = res + string;
					}
					result[count] = (res.length() + 4 + "/" + webSite.length());
					count++;
				}
				for (int i = 0; i < result.length; i++) {
					System.out.println(result[i]);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
