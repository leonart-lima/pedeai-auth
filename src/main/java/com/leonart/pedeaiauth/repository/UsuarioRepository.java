package com.leonart.pedeaiauth.repository;

import com.leonart.pedeaiauth.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Optional<Usuario> findByEmail(String email);
    public boolean existsByEmail(String email);
    public Optional<Usuario> findByLoginAndSenha(String login, String senha);
    public boolean existsByLogin(String login);
    public Optional<Usuario> findByLogin(String login);
}
