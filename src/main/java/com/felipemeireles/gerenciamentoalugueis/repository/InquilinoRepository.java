package com.felipemeireles.gerenciamentoalugueis.repository;

import com.felipemeireles.gerenciamentoalugueis.model.Inquilino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquilinoRepository extends JpaRepository<Inquilino, Long> {
}
