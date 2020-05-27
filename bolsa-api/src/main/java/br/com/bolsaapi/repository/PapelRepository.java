package br.com.bolsaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bolsaapi.model.PapelAnalise;

@Repository
public interface PapelRepository extends JpaRepository<PapelAnalise, Long>{

}
