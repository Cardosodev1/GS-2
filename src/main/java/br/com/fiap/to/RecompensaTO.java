package br.com.fiap.to;

import jakarta.validation.constraints.*;

import java.sql.Blob;

public class RecompensaTO {
    private Long codigo;

    @NotBlank
    private String nomeEmpresa;

    @NotBlank
    private String descricao;

    @NotNull
    private Blob imagem;

    @NotNull
    @Positive
    private Long pontosNecessarios;

    public RecompensaTO() {
    }

    public RecompensaTO(Long codigo, @NotBlank String nomeEmpresa, @NotBlank String descricao, @NotNull Blob imagem, @NotNull @Positive Long pontosNecessarios) {
        this.codigo = codigo;
        this.nomeEmpresa = nomeEmpresa;
        this.descricao = descricao;
        this.imagem = imagem;
        this.pontosNecessarios = pontosNecessarios;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Blob getImagem() {
        return imagem;
    }

    public void setImagem(Blob imagem) {
        this.imagem = imagem;
    }

    public Long getPontosNecessarios() {
        return pontosNecessarios;
    }

    public void setPontosNecessarios(Long pontosNecessarios) {
        this.pontosNecessarios = pontosNecessarios;
    }
}
