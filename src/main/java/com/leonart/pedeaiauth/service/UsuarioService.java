package com.leonart.pedeaiauth.service;

import com.leonart.pedeaiauth.domain.Usuario;
import com.leonart.pedeaiauth.dto.UsuarioDTO;
import com.leonart.pedeaiauth.dto.UsuarioUpdateDTO;
import com.leonart.pedeaiauth.exception.EmailJaCadastradoException;
import com.leonart.pedeaiauth.exception.UsuarioNaoEncontradoException;
import com.leonart.pedeaiauth.exception.UsuarioSenhaNaoExisteException;
import com.leonart.pedeaiauth.mapper.UsuarioMapper;
import com.leonart.pedeaiauth.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioDTO buscarUsuarioPorId(Long id) {
       Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado com ID: " + id));
        UsuarioDTO usuarioDTO = UsuarioMapper.toDTO(usuario);
        return usuarioDTO;
    }

    public void criarUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioRepository.existsByEmail(usuarioDTO.getEmail())) {
            throw new EmailJaCadastradoException();
        }

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setDataDeCriacao(LocalDateTime.now());
        usuario.setDataDaUltimaAlteracao(LocalDateTime.now());
        usuario.setEndereco(usuarioDTO.getEndereco());
        usuario.setRole(com.leonart.pedeaiauth.domain.Role.valueOf(usuarioDTO.getRole().name()));

        usuarioRepository.save(usuario);
    }

    public void alterarUsuario(Long id, UsuarioUpdateDTO usuarioUpdateDTO) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isEmpty()) {
            new UsuarioNaoEncontradoException("Usuário não encontrado com ID: " + id);
        }
        Usuario usuario = usuarioOpt.get();
        usuario.setNome(usuarioUpdateDTO.getNome());
        usuario.setEmail(usuarioUpdateDTO.getEmail());
        usuario.setLogin(usuarioUpdateDTO.getLogin());
        usuario.setEndereco(usuarioUpdateDTO.getEndereco());

        usuarioRepository.save(usuario);
    }

    public void trocarSenha(Long id, String senhaAtual, String novaSenha) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado com ID: " + id));
        if (!passwordEncoder.matches(senhaAtual, usuario.getSenha())) {
            throw new UsuarioSenhaNaoExisteException();
        }
        usuario.setSenha(passwordEncoder.encode(novaSenha));
        usuarioRepository.save(usuario);
    }
}
