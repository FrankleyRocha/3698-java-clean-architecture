package br.com.alura.codechella.infra.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.domain.entities.usuario.Usuario;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;
    private final ListarUsuarios listarUsuarios;

    public UsuarioController(CriarUsuario criarUsuario, ListarUsuarios listarUsuarios) {
        this.criarUsuario = criarUsuario;
        this.listarUsuarios = listarUsuarios;
    }

    @PostMapping
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto dto){

        Usuario salvo = criarUsuario.cadastrarUsuario(new Usuario(dto.cpf(),dto.nome(), dto.nascimento(), dto.email()));

        return new UsuarioDto(
            salvo.getCpf(),
            salvo.getNome(),
            salvo.getNascimento(),
            salvo.getEmail()
        );

    }

    @GetMapping
    public List<UsuarioDto> listarUsuarios(){
        return listarUsuarios.obterTodosUsuarios().stream().map(
            u -> new UsuarioDto(u.getCpf(),u.getNome(),u.getNascimento(), u.getEmail())
        ).collect(Collectors.toList());
    }

}
