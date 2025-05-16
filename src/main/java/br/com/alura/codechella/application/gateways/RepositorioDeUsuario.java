package br.com.alura.codechella.application.gateways;

import java.util.List;

import br.com.alura.codechella.domain.entities.usuario.Usuario;

public interface RepositorioDeUsuario {

     Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();

}
