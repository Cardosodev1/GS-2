package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PerguntaTO {
    private Long codigo;

    @NotBlank
    private String descricao;

    @NotNull
    private Long codigoQuiz;

    public PerguntaTO() {
    }

    public PerguntaTO(Long codigo, @NotBlank String descricao, @NotNull Long codigoQuiz) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.codigoQuiz = codigoQuiz;
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

    public Long getCodigoQuiz() {
        return codigoQuiz;
    }

    public void setCodigoQuiz(Long codigoQuiz) {
        this.codigoQuiz = codigoQuiz;
    }
}
