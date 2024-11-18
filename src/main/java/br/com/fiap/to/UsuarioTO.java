package br.com.fiap.to;

import jakarta.validation.constraints.*;

public class UsuarioTO {
    private Long codigo;

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private String senha;

    @NotNull
    @PositiveOrZero
    private Long pontos;

    public UsuarioTO() {
    }

    public UsuarioTO(Long codigo, @NotBlank String nome, @NotBlank String email, @NotBlank @Size(min = 6, max = 20) String senha, @NotNull @PositiveOrZero Long pontos) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.pontos = pontos;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getPontos() {
        return pontos;
    }

    public void setPontos(Long pontos) {
        this.pontos = pontos;
    }
}
