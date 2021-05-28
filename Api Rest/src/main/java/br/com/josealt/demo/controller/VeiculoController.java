package br.com.josealt.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.josealt.demo.model.Pessoa;
import br.com.josealt.demo.model.Veiculo;
import br.com.josealt.demo.repository.PessoaRepository;
import br.com.josealt.demo.repository.VeiculoRepository;

@RestController
@RequestMapping("/")
public class VeiculoController {

	private PessoaRepository pessoaRepository;
	private VeiculoRepository veiculoRepository;
	
	public VeiculoController(PessoaRepository pessoaRepository,
							 VeiculoRepository veiculoRepository) {
		this.pessoaRepository = pessoaRepository;
		this.veiculoRepository = veiculoRepository;
	}
	
	@GetMapping("veiculos")
	public List<Veiculo> getVeiculos() {
		return this.veiculoRepository.findAll();
	}
	
	@GetMapping("veiculo/{id}")
	public Optional<Veiculo> getVeiculoById(@PathVariable Long id) {
		return this.veiculoRepository.findById(id);
	}
	
	@PostMapping("veiculo/{id}")
	public Veiculo setVeiculo(@RequestBody Veiculo veiculo, @PathVariable Long id) {
		Optional<Pessoa> optional = pessoaRepository.findById(id);
		if(optional.isPresent()) {
			Pessoa pessoa = optional.get();
			Veiculo newVeiculo = new Veiculo();
			newVeiculo.setMarca(veiculo.getMarca());
			newVeiculo.setModelo(veiculo.getModelo());
			newVeiculo.setPlaca(veiculo.getPlaca());
			newVeiculo.setAno(veiculo.getAno());
			newVeiculo.setPessoa(pessoa);
			return this.veiculoRepository.save(newVeiculo);
		}
		else {
			return null;
		}
	}
	
	@DeleteMapping("veiculo/{id}")
	public void deleteVeiculo(@PathVariable Long id) {
		this.veiculoRepository.deleteById(id);
	}
}
