package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;

public class ArtigoTO {
    private Long codigo;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotBlank
    private String conteudo;

    public ArtigoTO() {
    }

    public ArtigoTO(Long codigo, @NotBlank String titulo, @NotBlank String descricao, @NotBlank String conteudo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.conteudo = conteudo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
