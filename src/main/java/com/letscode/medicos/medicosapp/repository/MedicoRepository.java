package com.letscode.medicos.medicosapp.repository;

import com.letscode.medicos.medicosapp.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
