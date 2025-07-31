package com.leonart.pedeaiauth.mapper;

import com.leonart.pedeaiauth.domain.Usuario;
import com.leonart.pedeaiauth.dto.UsuarioDTO;

public class UsuarioMapper {
    public static UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        // Adicione outros campos conforme necessário
        return dto;
    }
}