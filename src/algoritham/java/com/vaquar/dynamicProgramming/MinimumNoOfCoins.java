package algoritham.java.com.vaquar.dynamicProgramming;

/**
 * 
 * 
 * https://www.youtube.com/watch?v=NJuKJ8sasGk
 * Coin Changing Minimum Coins Dynamic Programming
 * by Tushar Roy
 * 
 * Greedy algorithm OR BackTracing algorithm will fail to find the optimal (exact/very correct) value.
 * So opting the dynamic programming.
 * 
 * https://www.youtube.com/watch?v=rdI94aW6IWw
 * Change Making Problem - Dynamic Programming
 * By CSBreakdown
 * Watch @ 1:12 to 1:32 
 * 
 * 
 *
 */
public class MinimumNoOfCoins {
	public static void main(String[] args) {
		int total = 13;
		int[] coins = { 7, 2, 3, 6 };
		int minNoOfCoins = findMinNoOfCoins(total, coins);
		System.out.println(minNoOfCoins);
	}

	/**
	 * 
	 * minNoOfCoins4Value = minNoOfCoins required for (index) Value.
	 * [ 0,          1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]
	 * [ 0, 2147483646, 1, 1, 2, 2, 1, 1, 2, 2,  2,  3,  2,  2]
	 * e.g) 2 = minNoOfCoins required for 13.
	 * 
	 * @param total
	 * @param coins
	 * @return
	 */
	private static int findMinNoOfCoins(int total, int[] coins) {
		int[] minNoOfCoins4Value = new int[total + 1];
		int[] toDetermineWhereAnswerComeFrom = new int[total + 1];
		
		minNoOfCoins4Value[0] = 0;
		toDetermineWhereAnswerComeFrom[0] = -1;
		for(int i = 1; i <= total; i++) {
			minNoOfCoins4Value[i] = Integer.MAX_VALUE -1;
			toDetermineWhereAnswerComeFrom[i] = -1;
		}
		
		for(int j = 0; j < coins.length; j++) {
			for(int i = 0; i <= total; i++) {
				if(coins[j] <= i ) {
					
					
//					int initial = minNoOfCoins4Value[i];
//					minNoOfCoins4Value[i] = Math.min(minNoOfCoins4Value[i], (1 + minNoOfCoins4Value[i - coins[j]]));
//					if(initial != minNoOfCoins4Value[i]) {
//						toDetermineWhereAnswerComeFrom[i] = j;
//					}
					
					//This is another way doing the min check like above commented code.
					if((1 + minNoOfCoins4Value[i - coins[j]]) < minNoOfCoins4Value[i]) {
						minNoOfCoins4Value[i] = (1 + minNoOfCoins4Value[i - coins[j]]);
						toDetermineWhereAnswerComeFrom[i] = j;
					}
				}
			}
		}
		
		printCoinCombination(toDetermineWhereAnswerComeFrom, coins);
		return minNoOfCoins4Value[total];
	}
	
	/**
	 * toDetermineWhereAnswerComeFrom is array where each value can be built with coin [index]
	 * [ 0,  1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]
	 * [-1, -1, 1, 2, 1, 2, 3, 0, 3,  1,  2,  1,  3, 3]
	 * 
	 * int[] coins = { 7, 2, 3, 6 };
	 * 
	 * So here 13 can be built with coin[3]  which is 6
	 *                   then  with coin[toDetermineWhereAnswerComeFrom[13-6]] == coin[toDetermineWhereAnswerComeFrom[7]] == coin[0] == 7
	 *                   so 13 = 7 + 6; 
	 * 
	 * @param toDetermineWhereAnswerComeFrom
	 * @param coins
	 */
    private static void printCoinCombination(int toDetermineWhereAnswerComeFrom[], int coins[]) {
        if (toDetermineWhereAnswerComeFrom[toDetermineWhereAnswerComeFrom.length - 1] == -1) {
            System.out.print("No solution is possible");
            return;
        }
        int start = toDetermineWhereAnswerComeFrom.length - 1;
        System.out.print("Coins used to form total ");
        while ( start != 0 ) {
            int j = toDetermineWhereAnswerComeFrom[start];
            System.out.print(coins[j] + " ");
            start = start - coins[j];
        }
        System.out.print("\n");
    }
}
