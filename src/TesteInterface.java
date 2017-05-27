
public interface TesteInterface {

	Integer getTamanho();
	
	default String getNome() {
		return "oi";
	};
	
}
