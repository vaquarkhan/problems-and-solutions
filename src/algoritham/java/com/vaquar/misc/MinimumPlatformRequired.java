package algoritham.java.com.vaquar.misc;


/**
 * http://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 * 
 *  
 *  Input:  arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
 *          dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
 *  Output: 3
 *  There are at-most three trains at a time (time between 11:00 to 11:20)
 *  
 * 
 *
 */
public class MinimumPlatformRequired {
	public static void main(String[] args) {
		// int [] arr = {900, 940, 950, 1100, 1500, 1800};
		// int [] dep = {910, 1200, 1120, 1130, 1900, 2000};

		int[] arr = { 900, 940, 950, 1100, 1110, 1500, 1800 };
		int[] dep = { 910, 1200, 1120, 1130, 1120, 1900, 2000 };
		int no = findMinimumPlatformRequired(arr, dep);
	}

	private static int findMinimumPlatformRequired(int[] arr, int[] dep) {
		int timeStart = 0;
		int timeEnd = 0;
		int start = 0;
		int totalPFsReq = 0;
		for (int d = 0, totPFReqInner = 0, timeEndInner = Integer.MAX_VALUE; d < dep.length; d++) {
			if (dep[start] >= dep[d]) {
				totPFReqInner += 1;
				timeEndInner = Math.min(timeEndInner, dep[d]); //Time end will be minimum of all departure
			} else {
				start = d;
				if (totPFReqInner > totalPFsReq) {
					totalPFsReq = totPFReqInner;
					timeEnd = timeEndInner;
					timeStart = arr[d - 1]; //Time start will be maximum of all arrival
				}
				timeEndInner = Integer.MAX_VALUE;
				totPFReqInner = 1;
			}
		}
		System.out.println(
				"There are minimum of " + totalPFsReq + " platforms required, from:" + timeStart + "  to:" + timeEnd);
		return totalPFsReq;
	}
}
