package com.weg.estrutura_pedagogica.Mapper;

import com.weg.estrutura_pedagogica.Dto.DepartamentoRequisicaoDto;
import com.weg.estrutura_pedagogica.Dto.DepartamentoRespostaDto;
import com.weg.estrutura_pedagogica.Model.Departamento;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoMapper {

    public Departamento toEntity(DepartamentoRequisicaoDto dto) {
        Departamento departamento = new Departamento();
        departamento.setNome(dto.getNome());
        return departamento;
    }

    public DepartamentoRespostaDto toDto(Departamento departamento) {
        DepartamentoRespostaDto dto = new DepartamentoRespostaDto();
        dto.setId(departamento.getId());
        dto.setNome(departamento.getNome());
        return dto;
    }
}