import java.util.ArrayList;
import java.util.List;

/*
 * Alex is attending a Halloween party with his girlfriend, Alison
 * At the party, Alison spots the corner of an infinite chocolate bar 
 * (two dimensional, infinitely long in width and length).
 *  If the chocolate can be served only as 1 x 1 sized pieces 
 *  and Alex can cut the chocolate bar exactly  times, 
 *  find the maximum number of chocolate pieces Alex can cut
 * 
 * 
 * 
 */

public class HalloweenParty {
	
	List<Integer> list;
	
	public HalloweenParty() {
		list = new ArrayList<Integer>();
	}
	
	public int cutInfiniteChocolateBar(int times) {
		int numOfPieces = 0;
		
		if(times < 2) {
			return numOfPieces;
		}
		else {
			numOfPieces = 1; // base case with time = 2
			list.add(numOfPieces);
		}
		
		
		for(int i=3; i <= times; i++) {
			int add = i / 2;
			int pre = list.get(list.size() - 1);
			numOfPieces = pre + add;
			list.add(numOfPieces);
		}
		
		
		return numOfPieces;
	}
}
