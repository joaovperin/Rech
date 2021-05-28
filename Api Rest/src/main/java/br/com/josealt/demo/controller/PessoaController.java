package br.com.josealt.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.josealt.demo.model.Pessoa;
import br.com.josealt.demo.repository.PessoaRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/")
public class PessoaController {

	private PessoaRepository pessoaRepository;
	
	public PessoaController(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	@GetMapping("pessoas")
	public List<Pessoa> getPessoas() {
		return this.pessoaRepository.findAll();
	}
	
	@GetMapping("pessoa/{id}")
	public Optional<Pessoa> getPessoaById(@PathVariable Long id) {
		return this.pessoaRepository.findById(id);
	}

	@PostMapping("pessoa")
	public Pessoa setPessoa(@RequestBody Pessoa pessoa) {
		return this.pessoaRepository.save(pessoa);
	}
	
	@PutMapping("pessoa/{id}")
	public Pessoa updatePessoa(@PathVariable Long id, @RequestBody Pessoa newPessoa) {
		Optional<Pessoa> oldPessoa = this.pessoaRepository.findById(id);
		Pessoa pessoa = oldPessoa.get();
		pessoa.setNome(newPessoa.getNome());
		pessoa.setCpf(newPessoa.getCpf());
		pessoa.setApartamento(newPessoa.getApartamento());
		pessoa.setDataNascimento(newPessoa.getDataNascimento());
		pessoa.setTelefone(newPessoa.getTelefone());
		return this.pessoaRepository.save(pessoa);
	}
	
	@DeleteMapping("pessoa/{id}")
	public void deletePessoa(@PathVariable Long id) {
		this.pessoaRepository.deleteById(id);
	}
}
