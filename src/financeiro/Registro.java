package financeiro;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Registro {
	private HashMap<String, List<Transacao>> transacaoPorFamiliar;
	
	public Registro() {
		this.transacaoPorFamiliar = new HashMap<>();
	}
	
	public void adicionarTransacao(String cpf, Transacao novaTransacao) {
		if(!this.transacaoPorFamiliar.containsKey(cpf)) {
			List<Transacao> novaLista = new ArrayList<>();
			this.transacaoPorFamiliar.put(cpf, novaLista);
		}
		
		List<Transacao> listaDoFamiliar = this.transacaoPorFamiliar.get(cpf);
		listaDoFamiliar.add(novaTransacao);
	}
	
	
}
