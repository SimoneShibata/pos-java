public class ClasseSynchronized implements Runnable {

	private Integer valor = 200;

	public void run() {
		somaValorCem();
	}

	private void somaValorCem() {
		synchronized (this) {

			valor = valor + 100;
			System.out.println("valor:" + valor);

		}
	}

}
