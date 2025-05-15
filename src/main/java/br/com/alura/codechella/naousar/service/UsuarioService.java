package br.com.alura.codechella.naousar.service;

import java.util.List;

import br.com.alura.codechella.naousar.model.Usuario;

public interface UsuarioService {
    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();
}
