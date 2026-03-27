package com.weg.estrutura_pedagogica.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioRequisicaoDto {

    private String nome;
    private Double salario;
    private Long departamentoId;
}