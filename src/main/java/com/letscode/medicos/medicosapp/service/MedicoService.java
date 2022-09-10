package com.letscode.medicos.medicosapp.service;

import com.letscode.medicos.medicosapp.exceptions.MedicoNaoEncontradoException;
import com.letscode.medicos.medicosapp.repository.MedicoRepository;
import com.letscode.medicos.medicosapp.domain.Medico;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicoService {
    private MedicoRepository medicoRepository;

    public Medico adicionaMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Medico buscaPorId(Long id) throws MedicoNaoEncontradoException {
        return medicoRepository.findById(id).orElseThrow(MedicoNaoEncontradoException::new);
    }
}
