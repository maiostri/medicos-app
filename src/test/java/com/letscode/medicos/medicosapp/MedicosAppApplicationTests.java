package com.letscode.medicos.medicosapp;

import com.letscode.medicos.medicosapp.domain.Medico;
import com.letscode.medicos.medicosapp.exceptions.MedicoNaoEncontradoException;
import com.letscode.medicos.medicosapp.service.MedicoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MedicosAppApplicationTests {

    @Autowired
    private MedicoService medicoService;

    @Test
    @DisplayName("Deve adicionar um médico corretamente")
    void adicionaMedico() {
        Medico medico = Medico.builder().nome("João").crm("999").build();

        Medico retornoMedico = medicoService.adicionaMedico(medico);

        Assertions.assertEquals(medico, retornoMedico);
    }

    @Test
    @DisplayName("Deve ser possível buscar um médico por id existente")
    public void buscaMedicoExistente() throws MedicoNaoEncontradoException {
        Medico medico = Medico.builder().nome("João").crm("999").build();
        Medico medicoInserido = medicoService.adicionaMedico(medico);
        Medico medicoBuscado = medicoService.buscaPorId(medicoInserido.getId());

        Assertions.assertEquals(medicoInserido, medicoBuscado);

    }

    @Test
    @DisplayName("Deve ser possível buscar um médico por id nao existente")
    public void buscaMedicoNaoExistente() {
        Assertions.assertThrows(MedicoNaoEncontradoException.class, () -> medicoService.buscaPorId(9999L));
    }

}
