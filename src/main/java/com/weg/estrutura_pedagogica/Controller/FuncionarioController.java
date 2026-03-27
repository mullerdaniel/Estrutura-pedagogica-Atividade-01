package com.weg.estrutura_pedagogica.Controller;

import com.weg.estrutura_pedagogica.Dto.FuncionarioRequisicaoDto;
import com.weg.estrutura_pedagogica.Dto.FuncionarioRespostaDto;
import com.weg.estrutura_pedagogica.Service.FuncionarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @PostMapping
    public FuncionarioRespostaDto salvar(@RequestBody FuncionarioRequisicaoDto dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<FuncionarioRespostaDto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public FuncionarioRespostaDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}