
public class BacktrackingEJ1 {
	int M = 15;
	int[] numbers = {6,3,7,4,2,9};

	public BacktrackingEJ1 () {
		int[] group = {0,0,0,0,0,0};

		getSolution(numbers,group, 0);
	}

	public void getSolution(int numb[],int group[], int level) {

		if(isSolution(numb,group, level)) {
			for (int i = 0; i < group.length; i++) {
				if(group[i] == level) {
					System.out.print(numb[i]);

				}				
			}
			System.out.println();

		}

		else {
			for (int i = 0; i < 7 && level < numbers.length; i++) {
				group[level] = i;
				getSolution(numb,group, level+1);	
			}				

		}
	}

	private boolean isSolution(int numb[],int group[], int level) {
		int plus = 0;

		for (int i = 0; i < group.length; i++) {
			if(group[i] == level) {
				plus += numb[i];
			}
		}

		return plus == M;
	}

	public static void main(String[] args) {
		BacktrackingEJ1 b = new BacktrackingEJ1();
	}
}
