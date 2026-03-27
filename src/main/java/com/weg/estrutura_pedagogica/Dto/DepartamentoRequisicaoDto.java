package com.weg.estrutura_pedagogica.Dto;

import java.util.List;

public record DepartamentoRequisicaoDto(
        String nome,
        List<FuncionarioRequisicaoDto> funcionarios
) {
}