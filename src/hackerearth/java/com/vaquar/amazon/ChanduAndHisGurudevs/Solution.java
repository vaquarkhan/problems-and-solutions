package hackerearth.java.com.vaquar.amazon.ChanduAndHisGurudevs;

public class Solution {

    public static void main(String args[]) {
	boolean a = true;
	boolean b = !true;
	boolean c = a | b;
	boolean d = a & b;
	boolean e = d ? b : c;
	System.out.println(d + " " + e);
    }
}
