import java.util.*;


public class PE73 {
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		
		int b = in.nextInt();
		float a = b;
		int d = in.nextInt();
		in.close();
		int count = 0;
		
		//Increasing through denominators.
		for(int i = b; i <= d; i++) {
			
			//Going through possible numerators.
			//for(int j = 1; j < i/2+1; j++) {
			for(int j = i/(b+1)+1; j < (i-1)/b+1; j++) {
				
				//System.out.println(j + "/" + i);
				
				if(gcd(i, j) == 1) {
					count++;
				}
			}
		}
		
		System.out.println(count);
		
	}
	
	public static HashMap<HashSet<Integer>, Integer> gcdCache;

	public static int gcd(int a, int b) {
		HashSet<Integer> cacheKey = new HashSet<Integer>();
		cacheKey.add(a);
 		cacheKey.add(b);

		if (gcdCache.containsKe(cacheKey)){
			return gcdCache.get(cacheKey);
		}
		if(a == 0){
			gcdCache.set(cacheKey, b);
			return b;
		} 
		if(b == 0){
			gcdCache.set(cacheKey, a);
			return a;
		}
		if(a > b) return gcd(b, a % b);
		return gcd(a, b % a);
	}
}



