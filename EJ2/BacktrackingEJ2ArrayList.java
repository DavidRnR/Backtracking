import java.util.ArrayList;

public class BacktrackingEJ2ArrayList {
	ArrayList<Integer> numbers = new ArrayList<Integer>();

	public BacktrackingEJ2ArrayList () {
		numbers.add(4);
		numbers.add(1);
		numbers.add(2);
		numbers.add(6);
		numbers.add(3);
		numbers.add(5);
		numbers.add(9);

		ArrayList<Integer> group = new ArrayList<Integer>();
		group.add(0);
		group.add(0);
		group.add(0);
		group.add(0);
		group.add(0);
		group.add(0);
		group.add(0);

		getSolution(numbers, group, 0);
	}

	public void getSolution (ArrayList<Integer> numb, ArrayList<Integer> group, int level) {

		if(level == numb.size()) {
			if(isSolution(numb,group)){
				System.out.println(numb + " "+group);
				printSol(numb,group);
			}
		}
		else {
			for (int i = 0; i < 2; i++) {
				group.set(level, i);
				getSolution(new ArrayList<Integer> (numb), new ArrayList<Integer>(group) , level+1);

			}
		}

	}

	private boolean isSolution(ArrayList<Integer> numb,ArrayList<Integer> group) {
		Integer plus1 = 0;
		Integer plus2 = 0;

		for (int i = 0; i < group.size(); i++) {
			if(group.get(i) == 0) {
				plus1 += numb.get(i);
			}
			else if(group.get(i) == 1) {
				plus2 += numb.get(i);
			}

		}
		return plus1 == plus2;
	}

	private void printSol(ArrayList<Integer> numb, ArrayList<Integer> group) {
		System.out.println("SOLUCION ENCONTRADA!:");
		for (int i = 0; i < group.size(); i++) {
			System.out.println("Elemento " + numb.get(i) + ": Pertenece al conjunto Conj: " + group.get(i));
		}

		System.out.println();
		System.out.println();

	}


	public static void main(String[] args) {
		BacktrackingEJ2ArrayList b = new BacktrackingEJ2ArrayList();
	}
}