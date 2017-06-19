
public class BacktrackingEJ4 {
	int [] processors = {0,0,0};

	// Cuando se encuentra una posible solución, se guarda la suma 
	// tareas del procesador que mas tiene asignado
	int possibleSolution = 0; 

	public BacktrackingEJ4 () {
		int [] tasks = {50,20,10,60};

		// Ningun procesador aginado al principio
		int[] taskAssigned = {-1,-1,-1,-1};

		getSolution(tasks, taskAssigned, 0);
	}

	public void getSolution (int tasks[],int taskAssigned[], int level) {

		if(level == tasks.length) {
			if(isSolution(tasks,taskAssigned)) {
				for (int i = 0; i < taskAssigned.length; i++) {
					System.out.print("Procesador "+taskAssigned[i]);
					System.out.print(" tarea: "+tasks[i]);
					System.out.println();
				}
				System.out.println("*******************************************");
			}
		}
		else {
			// 3 es la cantidad de procesadores
			for (int i = 0; i < 3; i++) {
				taskAssigned[level] = i;
				getSolution(tasks,taskAssigned, level+1);
			}
		}
	}

	/**
	 * Es posible solucion cuando todas las tareas tienen al menos un procesador asignado
	 * @param tasks
	 * @param taskAssigned
	 * @return
	 */
	private boolean isSolution (int tasks[],int taskAssigned[]) {

		// Seteo los 3 procesadores en 0
		for (int i = 0; i < processors.length; i++) {
			processors[i] = 0;
		}

		// Asigno las tareas a cada procesador
		for (int i = 0; i < taskAssigned.length; i++) {
			// Si esa tarea tiene al menos un procesador asignado guardo el valor de la tarea en el procesador
			if(taskAssigned[i] >= 0) {
				processors[taskAssigned[i]] += tasks[i];
			}
			else {
				return false;
			}

		}

		// Si la cantidad de procesadores es menor que la cantidad de tareas
		// debo chequear que cada procesador tenga asignada al menos 1 tarea
		if(processors.length < tasks.length) {
			for (int i = 0; i < processors.length; i++) {
				if(processors[i] == 0) {
					return false;
				}
			}
		}
		// Si la cantidad de procesadores es mayor que la cantidad de tareas
		// debo chequear que cada procesador tenga 1 o ninguna tarea
		else if (processors.length > tasks.length) {
			// TODO 
		}

		// Si la cantidad de procesadores es igual que la cantidad de tareas
		// debo chequear que cada procesador tenga unicamente una tarea
		else if (processors.length == tasks.length) {
			// TODO
		}


		return true;
	}

	public static void main(String[] args) {
		BacktrackingEJ4 b = new BacktrackingEJ4();
	}
}
