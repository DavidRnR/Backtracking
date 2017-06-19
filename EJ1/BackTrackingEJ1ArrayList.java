import java.util.*;

public class BackTrackingEJ1ArrayList {
	int M = 15;
	
	public BackTrackingEJ1ArrayList () {
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(6);
		numbers.add(3);
		numbers.add(7);
		numbers.add(4);
		numbers.add(2);
		numbers.add(9);
		
		getSolution(new ArrayList<Integer>(), numbers);
		
	}
	
	public void getSolution(ArrayList<Integer> posSol, ArrayList<Integer> numbers) {
		
		if(isSolution(posSol)) {
			System.out.println(posSol);
		}
		else {
			while(!numbers.isEmpty()) {
				posSol.add(numbers.remove(0));
				getSolution(new ArrayList<Integer>(posSol),new ArrayList<Integer>(numbers));
				posSol.remove(posSol.size()-1);
			}	
		}
	}
	
	public boolean isSolution(ArrayList<Integer> posSol) {
		int plus = 0;
		
		for (int i = 0; i < posSol.size(); i++) {
			plus += posSol.get(i);
		}
		
		return plus == M;
	}
	
	public static void main(String[] args) {
		BackTrackingEJ1ArrayList b = new BackTrackingEJ1ArrayList();
	}
}
