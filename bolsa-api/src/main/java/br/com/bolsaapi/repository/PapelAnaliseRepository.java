package br.com.bolsaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bolsaapi.model.Papel;

@Repository
public interface PapelAnaliseRepository extends JpaRepository<Papel, Long>{

}
