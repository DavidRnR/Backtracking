import java.util.ArrayList;

public class Backtracking {
	ArrayList<Integer> paquetes = new ArrayList<Integer>();
	ArrayList<Integer> empleados = new ArrayList<Integer>();

	public Backtracking () {

		//Cargamos paquetes. Cada pos del Array es un paquete con un tiempo
		paquetes.add(5);
		paquetes.add(9);
		paquetes.add(2);
		paquetes.add(5);
		paquetes.add(1);
		paquetes.add(8);

		// Suponemos que tenemos 3 empleados
		// Ningun empleado tiene paquete asignado
		for (int i = 0; i < 3; i++) {
			empleados.add(0);
		}

		ArrayList<Integer> group = new ArrayList<Integer>();

		for (int i = 0; i < paquetes.size(); i++) {
			group.add(-1);
		}

		getSolBacktracking(paquetes, group, 0);

		System.out.println(empleados);
	}

	public void getSolBacktracking (ArrayList<Integer> paq, ArrayList<Integer> group, int level) {

		if(level == paquetes.size()) {
			if(isSolution(paq, group)) {
				
				// Set Empleados
				for (int i = 0; i < empleados.size(); i++) {
					empleados.set(i, 0);
				}
				for (int i = 0; i < group.size(); i++) {
					if(group.get(i) == 0) {
						empleados.set(0,empleados.get(0) + paq.get(i));
					}
					else if (group.get(i) == 1) {
						empleados.set(1,empleados.get(1) + paq.get(i));
					}
					else if (group.get(i) == 2) {
						empleados.set(2,empleados.get(2) + paq.get(i));
					}
				}

			}
		}
		else {
			for (int i = 0; i < 3; i++) {
				group.set(level, i);
				getSolBacktracking(new ArrayList<Integer>(paq),new ArrayList<Integer>(group), level+1);
			}
		}

	}
	
	/**
	 * Es Solucion si todos los paquetes están asignados y todos los empleados tienen tareas
	 * y si la distribucion de tareas es mejor que la anterior
	 * @param paq
	 * @param group
	 * @return
	 */
	private boolean isSolution(ArrayList<Integer> paq, ArrayList<Integer> group) {

		ArrayList<Integer> empleadosAux = new ArrayList<Integer>();

		for (int i = 0; i < 3; i++) {
			empleadosAux.add(0);
		}

		for (int i = 0; i < group.size(); i++) {
			if(group.get(i) == 0) {
				empleadosAux.set(0,empleadosAux.get(0) + paq.get(i));
			}
			else if (group.get(i) == 1) {
				empleadosAux.set(1,empleadosAux.get(1) + paq.get(i));
			}
			else if (group.get(i) == 2) {
				empleadosAux.set(2,empleadosAux.get(2) + paq.get(i));
			}
		}


		if(empleadosAux.get(0) > 0 && empleadosAux.get(1) > 0 && empleadosAux.get(2) > 0) {

			if(empleados.get(0) == 0 && empleados.get(1) == 0 && empleados.get(2) == 0) { 
				return true;
			}
			else {
				int MasOcupado = getEmpleadoMasOcupado(empleados);
				int MasOcupadoAux = getEmpleadoMasOcupado(empleadosAux);

				if(empleados.get(MasOcupado) <= empleadosAux.get(MasOcupadoAux)) {
					return false;
				}
				else {

					return true;
				}		
			}

		}
		else {

			return false;
		}

	}


	/**
	 * Recorre empleados y obtiene la pos del que mas tiempo | Mas Ocupado
	 * @return
	 */
	private int getEmpleadoMasOcupado (ArrayList<Integer> emp) {
		int index = 0;

		for (int i = 0; i < emp.size(); i++) {
			if(emp.get(index) <= emp.get(i)) {
				index = i;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		Backtracking g = new Backtracking();
	}
}