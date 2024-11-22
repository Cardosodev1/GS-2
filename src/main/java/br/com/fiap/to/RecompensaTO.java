package br.com.fiap.to;

import jakarta.validation.constraints.*;

public class RecompensaTO {
    private Long codigo;

    @NotBlank
    private String nomeEmpresa;

    @NotBlank
    private String descricao;

    @NotNull
    @Positive
    private Long pontosNecessarios;

    public RecompensaTO() {
    }

    public RecompensaTO(Long codigo, @NotBlank String nomeEmpresa, @NotBlank String descricao, @NotNull @Positive Long pontosNecessarios) {
        this.codigo = codigo;
        this.nomeEmpresa = nomeEmpresa;
        this.descricao = descricao;
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

    public Long getPontosNecessarios() {
        return pontosNecessarios;
    }

    public void setPontosNecessarios(Long pontosNecessarios) {
        this.pontosNecessarios = pontosNecessarios;
    }
}
