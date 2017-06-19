public class BackParcial {

	public static int N = 7;

	public static void main(String[] args) {
		int numeros[] = { 4,1,2,6,3,5,9 };
		int conj[] = new int[N];
		back(numeros, conj, 0);

	}

	public static void back(int numeros[], int conj[], int nivel) {
		if (nivel == numeros.length) {
			if (danLaMismaSuma(numeros, conj)) {
				imprimir(numeros, conj);
			}
		} else {
			for (int i = 0; i < 3; i++) {
				conj[nivel] = i;
				back(numeros, conj, nivel+1);
			}
		}
	}

	private static void imprimir(int numeros[], int conj[]) {
		System.out.println("SOLUCION ENCONTRADA!:");
		for (int i = 0; i < conj.length; i++) {
			System.out.println("Elemento " + numeros[i] + "·pertenece al conjunto Conj: " + conj[i]);
		}

		System.out.println();
		System.out.println();

	}

	private static boolean danLaMismaSuma(int numeros[], int conj[]) {
		int suma1 = 0, suma2 = 0, suma3 = 0;
		for (int i = 0; i < conj.length; i++) {
			if (conj[i] == 0)
				suma1 += numeros[i];
			else if (conj[i] == 1)
				suma2 += numeros[i];
			else if (conj[i] == 2)
				suma3 += numeros[i];
		}

		return suma1 == suma2 && suma2 == suma3 && suma1 == suma3;
	}

}