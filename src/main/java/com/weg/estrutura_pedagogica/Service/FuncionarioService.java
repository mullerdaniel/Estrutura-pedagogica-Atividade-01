package com.weg.estrutura_pedagogica.Service;

import com.weg.estrutura_pedagogica.Dto.FuncionarioRequisicaoDto;
import com.weg.estrutura_pedagogica.Dto.FuncionarioRespostaDto;
import com.weg.estrutura_pedagogica.Mapper.FuncionarioMapper;
import com.weg.estrutura_pedagogica.Model.Funcionario;
import com.weg.estrutura_pedagogica.Repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;
    private final FuncionarioMapper mapper;

    public FuncionarioService(FuncionarioRepository repository,
                              FuncionarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public FuncionarioRespostaDto salvar(FuncionarioRequisicaoDto dto) {
        Funcionario funcionario = mapper.toEntity(dto);
        funcionario = repository.save(funcionario);
        return mapper.toDto(funcionario);
    }

    public List<FuncionarioRespostaDto> listar() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public FuncionarioRespostaDto buscarPorId(Long id) {
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        return mapper.toDto(funcionario);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}