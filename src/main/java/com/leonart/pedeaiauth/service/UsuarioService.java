package com.leonart.pedeaiauth.service;

import com.leonart.pedeaiauth.domain.Usuario;
import com.leonart.pedeaiauth.dto.UsuarioDTO;
import com.leonart.pedeaiauth.exception.UsuarioNaoEncontradoException;
import com.leonart.pedeaiauth.mapper.UsuarioMapper;
import com.leonart.pedeaiauth.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDTO buscarUsuarioPorId(Long id) {
       Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado com ID: " + id));
        UsuarioDTO usuarioDTO = UsuarioMapper.toDTO(usuario);
        return usuarioDTO;
    }

    public void criarUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioRepository.existsByEmail(usuarioDTO.getEmail())) {
            throw new RuntimeException("E-mail já cadastrado.");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setDataDeCriacao(LocalDateTime.now());
        usuario.setDataDaUltimaAlteracao(LocalDateTime.now());
        usuario.setEndereco(usuarioDTO.getEndereco());

        usuarioRepository.save(usuario);
    }
}
