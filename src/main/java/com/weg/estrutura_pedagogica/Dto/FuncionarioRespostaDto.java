package com.weg.estrutura_pedagogica.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioRespostaDto {

    private Long id;
    private String nome;
    private Double salario;
    private String nomeDepartamento;
}