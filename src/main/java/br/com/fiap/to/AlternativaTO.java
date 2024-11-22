package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AlternativaTO {
    private Long codigo;

    @NotBlank
    private String descricao;

    @NotNull
    private String correta;

    @NotNull
    private Long codigoPergunta;

    public AlternativaTO() {
    }

    public AlternativaTO(Long codigo, @NotBlank String descricao, @NotNull String correta, @NotNull Long codigoPergunta) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.correta = correta;
        this.codigoPergunta = codigoPergunta;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCorreta() {
        return correta;
    }

    public void setCorreta(String correta) {
        this.correta = correta;
    }

    public Long getCodigoPergunta() {
        return codigoPergunta;
    }

    public void setCodigoPergunta(Long codigoPergunta) {
        this.codigoPergunta = codigoPergunta;
    }
}
