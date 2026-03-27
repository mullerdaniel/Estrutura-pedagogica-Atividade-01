package com.weg.estrutura_pedagogica.Mapper;

import com.weg.estrutura_pedagogica.Dto.FuncionarioRequisicaoDto;
import com.weg.estrutura_pedagogica.Dto.FuncionarioRespostaDto;
import com.weg.estrutura_pedagogica.Model.Departamento;
import com.weg.estrutura_pedagogica.Model.Funcionario;
import com.weg.estrutura_pedagogica.Repository.DepartamentoRepository;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    private final DepartamentoRepository departamentoRepository;

    public FuncionarioMapper(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public Funcionario toEntity(FuncionarioRequisicaoDto dto) {
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(dto.getNome());
        funcionario.setSalario(dto.getSalario());

        Departamento departamento = departamentoRepository.findById(dto.getDepartamentoId())
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));

        funcionario.setDepartamento(departamento);

        return funcionario;
    }

    public FuncionarioRespostaDto toDto(Funcionario funcionario) {
        FuncionarioRespostaDto dto = new FuncionarioRespostaDto();

        dto.setId(funcionario.getId());
        dto.setNome(funcionario.getNome());
        dto.setSalario(funcionario.getSalario());
        dto.setNomeDepartamento(funcionario.getDepartamento().getNome());

        return dto;
    }
}