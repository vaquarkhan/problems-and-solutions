package hackerearth.java.com.vaquar.art.of.verification;

import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TestClass {
    public static void main(String args[]) throws Exception {
	Scanner sc = new Scanner(System.in);

	Map<String, String> passedParamenters = new LinkedHashMap<String, String>();
	String query = sc.next();

	if (query == null || query.trim().isEmpty()) {
	    return;
	}

	String[] parts = query.split("\\?");
	String[] pairs = null;
	if (!query.contains("?")) {
	    int idx = query.lastIndexOf("/");
	    pairs = query.substring(0, idx).split("&");
	} else {
	    pairs = parts[1].split("&");
	}

	if (pairs.length == 0) {
	    return;
	}

	for (String pair : pairs) {
	    int idx = pair.indexOf("=");
	    passedParamenters.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
	}
	if (passedParamenters.isEmpty()) {
	    return;
	}
	for (String s : passedParamenters.keySet()) {
	    System.out.println(s + ": " + passedParamenters.get(s));
	}

    }
}
