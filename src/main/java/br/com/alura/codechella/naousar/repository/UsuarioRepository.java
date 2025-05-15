package br.com.alura.codechella.naousar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.codechella.naousar.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
