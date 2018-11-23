package View_Pista;

public class Scuderia {
	private String nome;
	private long tempo;
	
	
	public Scuderia(String nome, int tempo) {
		this.nome = nome;
		this.tempo = tempo;
	}
	public Scuderia() {
		// TODO Auto-generated constructor stub
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getTempo() {
		return  this.tempo;
	}
	public void setTempo(long tempo) {
		this.tempo = tempo;
	}
}
