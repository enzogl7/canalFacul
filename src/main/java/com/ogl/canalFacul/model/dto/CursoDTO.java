package com.ogl.canalFacul.model.dto;

import com.ogl.canalFacul.model.Modalidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoDTO(@NotBlank(message = "Nome do curso é obrigatório") String nome,
                       @NotNull(message = "Selecione uma modalidade") Modalidade modalidade,
                       @NotBlank(message = "Turma é obrigatória") String turma,
                       String descricao) {
}
