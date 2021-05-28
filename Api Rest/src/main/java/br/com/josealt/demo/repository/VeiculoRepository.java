package br.com.josealt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.josealt.demo.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

}
