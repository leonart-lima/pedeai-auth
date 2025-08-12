package com.leonart.pedeaiauth;

import com.leonart.pedeaiauth.repository.UsuarioRepository;
import com.leonart.pedeaiauth.service.AuthService;
import com.leonart.pedeaiauth.exception.UsuarioSenhaNaoExisteException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@SpringBootTest
class AuthServiceTest {

    @Test
    void autenticarUsuarioDeveLancarExcecaoParaCredenciaisInvalidas() {
        UsuarioRepository repo = mock(UsuarioRepository.class);
        AuthService service = new AuthService(repo);
        // Mock do repository e usuário necessário aquusuarioRepositoryi
        assertThrows(UsuarioSenhaNaoExisteException.class, () -> {
            service.authenticate("admin", "senhaErrada");
        });
    }
}