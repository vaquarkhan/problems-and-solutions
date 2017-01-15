package algoritham.java.com.vaquar.array;


public class MaximumSubArray {
	public static void main(String[] args) {
//      int[] array = {1,-2,-5,55,56,-11,58,-13};
//      int[] array = {1,-2,-5,55};
//      int[] array = {-100,200,-5,55,56,-11,58,-13};
//      int[] array = {-5,55,56,-11,58,-13,-100,200};
//      int[] array = {52,55,1,4};
//		int[] array = {52,55,1,5,0};
//      int[] array = {100,52,1,55,1,4};
//      int[] array = {100,52,40,55,1,30,52};
		int[] array = {100,52,40,55,30,52};
      
      int min = array[0];
      int max = 0;
      int tmp = array[0];
      
      for(int i = 1; i < array.length; i++) {
    	  int val = array[i];
    	  if(val < min && val < tmp) {
    		  tmp = val;
    	  }
    	  else if ( (val - tmp ) >  (max - min)) {
    		  min = tmp;
    		  max = val;
    	  }
      }
      
      System.out.println("Min/Max : " + min + "/" + max);
	}
}

