package com.weg.estrutura_pedagogica.Mapper;

import com.weg.estrutura_pedagogica.Dto.DepartamentoRequisicaoDto;
import com.weg.estrutura_pedagogica.Dto.DepartamentoRespostaDto;
import com.weg.estrutura_pedagogica.Dto.FuncionarioRequisicaoDto;
import com.weg.estrutura_pedagogica.Model.Departamento;
import com.weg.estrutura_pedagogica.Model.Funcionario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartamentoMapper {

    public Departamento toEntity(DepartamentoRequisicaoDto dto) {
        Departamento departamento = new Departamento();
        departamento.setNome(dto.nome());

        if (dto.funcionarios() != null) {
            List<Funcionario> funcionarios = dto.funcionarios()
                    .stream()
                    .map(f -> {
                        Funcionario func = new Funcionario();
                        func.setNome(f.nome());
                        func.setSalario(f.salario());
                        func.setDepartamento(departamento); // vínculo
                        return func;
                    })
                    .collect(Collectors.toList());

            departamento.setFuncionarios(funcionarios);
        }

        return departamento;
    }

    public DepartamentoRespostaDto toDto(Departamento departamento) {
        return new DepartamentoRespostaDto(
                departamento.getId(),
                departamento.getNome()
        );
    }
}