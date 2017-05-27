
public class EscreveOutraCoisa implements Runnable {

	public void run() {
		Integer contador = 0;
		while (contador < 1000) {
			System.out.println("OUTRA COISA");
			contador++;
		}
	}
		
}
