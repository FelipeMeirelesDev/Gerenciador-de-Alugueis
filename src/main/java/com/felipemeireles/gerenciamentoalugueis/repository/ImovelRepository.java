package com.felipemeireles.gerenciamentoalugueis.repository;

import com.felipemeireles.gerenciamentoalugueis.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {
}
