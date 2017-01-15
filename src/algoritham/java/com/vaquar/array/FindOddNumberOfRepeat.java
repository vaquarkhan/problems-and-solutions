package algoritham.java.com.vaquar.array;


public class FindOddNumberOfRepeat {

	public static void main(String[] args) {

		int[] v = {1,1,2,2,3,3,3,4,4,5,5};
		
		int odd_repeat_count = 0;
		int number_count = 1;
		for (int i=1; i<v.length; i++) {
			
			if (v[i] == v[i-1]) {
				number_count++;
			} else {
				int s = number_count & 1;
				if (s == 1) {
					odd_repeat_count++;
				}
				number_count = 1;
			}
		}
		
		System.out.println(odd_repeat_count);
	}

}
