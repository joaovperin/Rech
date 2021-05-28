package br.com.josealt.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "pessoas")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@Column(nullable = false)
	private int apartamento;
	
	private String dataNascimento;
	
	@Column(nullable = false)
	private String telefone;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Veiculo> veiculos;

	
	@Deprecated // Indica que não usaremos constantemento, ou utilizado por outras bibliotecas externas.
	public Pessoa() { }  
	
	public Pessoa(String nome, String cpf, int apartamento, String dataNascimento, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.apartamento = apartamento;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getApartamento() {
		return apartamento;
	}

	public void setApartamento(int apartamento) {
		this.apartamento = apartamento;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}
}
