package com.leonart.pedeaiauth.service;

import com.leonart.pedeaiauth.domain.Usuario;
import com.leonart.pedeaiauth.exception.UsuarioSenhaNaoExisteException;
import com.leonart.pedeaiauth.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String authenticate(String username, String password) {
        Usuario usuario = usuarioRepository.findByLogin(username)
                .orElseThrow(() -> new UsuarioSenhaNaoExisteException());

        if (!encoder.matches(password, usuario.getSenha())) {
            throw new UsuarioSenhaNaoExisteException();
        }

        return "Login realizado com sucesso";
    }
}
