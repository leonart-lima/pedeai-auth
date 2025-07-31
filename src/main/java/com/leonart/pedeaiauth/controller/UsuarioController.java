package com.leonart.pedeaiauth.controller;

import com.leonart.pedeaiauth.api.UsuariosApi;
import com.leonart.pedeaiauth.dto.UsuarioDTO;
import com.leonart.pedeaiauth.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsuarioController implements UsuariosApi {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public ResponseEntity<UsuarioDTO> obterUsuarioPorId(Long id) {
        UsuarioDTO usuarioDTO = usuarioService.buscarUsuarioPorId(id);
        if (usuarioDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioDTO);
    }

    public ResponseEntity<UsuarioDTO> criarUsuario(UsuarioDTO body){
        usuarioService.criarUsuario(body);

        return ResponseEntity.status(201).body(body);
    }

}
