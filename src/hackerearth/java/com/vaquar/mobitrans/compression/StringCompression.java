package hackerearth.java.com.vaquar.mobitrans.compression;

public class StringCompression {
    public String compress(String str) {

	if (str == null || str.isEmpty()) {
	    return new String();
	}

	char[] charArray = str.toCharArray();
	StringBuilder builder = new StringBuilder();
	int count = 1;

	char prev = charArray[0];

	for (int i = 1; i < charArray.length; i++) {

	    char cur = charArray[i];
	    if (cur == prev) {
		count++;
	    } else {
		builder.append(prev).append(count == 1 ? "" : count);
		count = 1;
	    }
	    prev = cur;
	}
	return builder.append(prev).append(count == 1 ? "" : count).toString();
    }

    public static void main(String[] args) {
	StringCompression test = new StringCompression();

	test.compress("aaaaabbbbbbbbbccccpqrstuv");
	test.compress("aaaaa");
	test.compress("aaaabbb");
	test.compress("aaabbbccc");
	test.compress("abc");
	test.compress("a");
	test.compress("");
    }
}