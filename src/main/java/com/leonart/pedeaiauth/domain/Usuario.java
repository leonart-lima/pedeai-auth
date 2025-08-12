package com.leonart.pedeaiauth.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "USUARIO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LOGIN", nullable = false, length = 50)
    private String login;

    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    @Column(name = "SENHA", nullable = false, length = 16)
    private String senha;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "DATA_DA_ULTIMA_ALTERACAO", nullable = false, length = 20)
    private LocalDateTime dataDaUltimaAlteracao;

    @Column(name = "DATA_DE_CRIACAO", nullable = false, length = 20)
    private LocalDateTime dataDeCriacao;

    @Column(name = "ENDERECO", nullable = false, length = 100)
    private String endereco;

    @Column(name = "ROLE", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Role role;

}
