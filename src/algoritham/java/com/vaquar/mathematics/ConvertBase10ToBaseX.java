package algoritham.java.com.vaquar.mathematics;

/**
 * This class will be useful to retrieve piece of bits from 32 bit integer.
 * This will be useful to form TRIE from the hashcode value of object. 
 * 
 */
public class ConvertBase10ToBaseX {
	enum Base {
		/**
		 * Integer is represented in 32 bit in 32 bit machine.
		 * There we can split this integer no of bits into multiples of 1,2,4,8,16 bits
		 */
		BASE2(1,1,32), BASE4(3,2,16), BASE8(7,3,11)/* OCTAL*/, /*BASE10(3,2),*/ 
		BASE16(15, 4, 8){		
			public String getFormattedValue(int val){
				switch(val) {
				case 10:
					return "A";
				case 11:
					return "B";
				case 12:
					return "C";
				case 13:
					return "D";
				case 14:
					return "E";
				case 15:
					return "F";
				default:
					return "" + val;
				}
				
			}
		}, /*BASE32(31,5,1),*/ BASE256(255, 8, 4), /*BASE512(511,9),*/ Base65536(65535, 16, 2);
		
		private int LEVEL_0_MASK;
		private int LEVEL_1_ROTATION;
		private int MAX_ROTATION;
		
		Base(int levelZeroMask, int levelOneRotation, int maxPossibleRotation) {
			this.LEVEL_0_MASK = levelZeroMask;
			this.LEVEL_1_ROTATION = levelOneRotation;
			this.MAX_ROTATION = maxPossibleRotation;
		}
		
		int getLevelZeroMask(){
			return LEVEL_0_MASK;
		}
		int getLevelOneRotation(){
			return LEVEL_1_ROTATION;
		}
		int getMaxRotation(){
			return MAX_ROTATION;
		}
		String getFormattedValue(int val){
			return "" + val;
		}
	}

	public void getBaseXValueOn(Base base, int on) {
		int rotation = base.getLevelOneRotation();
		int mask = base.getLevelZeroMask();
        
//		recursiveReversePrint(2, base, on);
//      System.out.println((on & mask));
        
        forwardPrint(base, on);
	}
	
	private void recursiveReversePrint(int level, Base base, int on) {
		
		int rotation = base.getLevelOneRotation();
		int mask = base.getLevelZeroMask();
		int maxRotation = base.getMaxRotation();
		
		for(; level <= maxRotation; ) {
			int rotation1 = (level-1) * rotation;
			int mask1 = mask << rotation1 ;
			if(level < maxRotation ) {
				level++;
				recursiveReversePrint(level, base, on);
			}
		    System.out.print((on & mask1) >>> rotation1);
		    break;
		}
	}
	
	
	private void forwardPrint(Base base, int on) {
		
		int rotation = base.getLevelOneRotation();
		int mask = base.getLevelZeroMask();
		int maxRotation = base.getMaxRotation();
		boolean valueFound = false;
		
		for(int level = maxRotation; level >= 2; level--) {
			int rotation1 = (level-1) * rotation;
			int mask1 = mask << rotation1 ;
			if((on & mask1) > 0 ) {
				valueFound = true;
			}
			if(valueFound)
		    System.out.print(base.getFormattedValue((on & mask1) >>> rotation1));
		}
		System.out.println(base.getFormattedValue((on & mask)));
	}

	public int getBaseXValueOnAtLevel(Base base, int on, int level) {
		if(level > base.getMaxRotation() || level < 1) {
			return 0; //INVALID Input
		}
		int rotation = base.getLevelOneRotation();
		int mask = base.getLevelZeroMask();

//		for(int i = 2; i <= level; i++) {
//			mask = mask << rotation;
//		}
		
		if(level > 1) {
			rotation = (level-1) * rotation;
			mask = mask << rotation;
		} else {
			rotation = 0;
		}
		
		
		return (on & mask) >>> rotation;
	}
	
	public static void main(String[] args) {
		ConvertBase10ToBaseX obj = new ConvertBase10ToBaseX();
		
		obj.getBaseXValueOn(Base.BASE2,-1392490240); //(-1392490240 < 0 ? ((-1392490240)-1) : 1392490240)); 
		System.out.println(obj.getBaseXValueOnAtLevel(Base.BASE8, -12, 3)); 
//		obj.getBaseXValueOn(Base.BASE16,300); 
//		obj.getBaseXValueOn(Base.BASE16,7); 
//		obj.getBaseXValueOn(Base.BASE16,7);
		
		/*obj.getBaseXValueOn(Base.BASE2,12456);
		obj.getBaseXValueOn(Base.BASE8,12456);
		obj.getBaseXValueOn(Base.BASE2,8);
		obj.getBaseXValueOn(Base.BASE2,9);
		obj.getBaseXValueOn(Base.BASE2,10);
		obj.getBaseXValueOn(Base.BASE2,11);
		obj.getBaseXValueOn(Base.BASE2,12);
		obj.getBaseXValueOn(Base.BASE2,13);
		obj.getBaseXValueOn(Base.BASE2,14);
		obj.getBaseXValueOn(Base.BASE2,15);
		obj.getBaseXValueOn(Base.BASE2,16);
		obj.getBaseXValueOn(Base.BASE2,17);
		
		
		System.out.println(obj.getBaseXValueOnAtLevel(Base.BASE2, 4, 1)); 
		System.out.println(obj.getBaseXValueOnAtLevel(Base.BASE2, 4, 2)); 
		System.out.println(obj.getBaseXValueOnAtLevel(Base.BASE2, 4, 3)); 
		System.out.println(obj.getBaseXValueOnAtLevel(Base.BASE2, 4, 4)); 
		
		System.out.println(obj.getBaseXValueOnAtLevel(Base.BASE16,15, 1)); 
		System.out.println(obj.getBaseXValueOnAtLevel(Base.BASE16,30, 2)); 
		System.out.println(obj.getBaseXValueOnAtLevel(Base.BASE16,7, 1)); 
		System.out.println(obj.getBaseXValueOnAtLevel(Base.BASE16,7, 2)); 
		
		System.out.println(obj.getBaseXValueOnAtLevel(Base.BASE256, 511, 1)); 
		System.out.println(obj.getBaseXValueOnAtLevel(Base.BASE256, 511, 2)); 
		System.out.println(obj.getBaseXValueOnAtLevel(Base.BASE256, 512, 1));
		System.out.println(obj.getBaseXValueOnAtLevel(Base.BASE256, 512, 2)); 
		System.out.println(obj.getBaseXValueOnAtLevel(Base.BASE256, 513, 2)); */
		
		
	}
}