package br.com.alura.codechella.infra.gateways;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repositorio;
    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioJpa(
        UsuarioRepository repositorio,
        UsuarioEntityMapper mapper
    ) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        return mapper.toDomain(
            repositorio.save(
                mapper.toEntity(usuario)
            )
        );
    }

    @Override
    public List<Usuario> listarTodos() {
        return repositorio.
            findAll().
                stream().
                    map(mapper::toDomain).
                        collect(Collectors.toList());
    }

}