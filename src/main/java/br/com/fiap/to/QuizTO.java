package br.com.fiap.to;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class QuizTO {
    private Long codigo;

    @FutureOrPresent
    private LocalDate dataDisponivel;

    @NotNull
    private Long codigoArtigo;

    public QuizTO() {
    }

    public QuizTO(Long codigo, @FutureOrPresent LocalDate dataDisponivel, @NotNull Long codigoArtigo) {
        this.codigo = codigo;
        this.dataDisponivel = dataDisponivel;
        this.codigoArtigo = codigoArtigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataDisponivel() {
        return dataDisponivel;
    }

    public void setDataDisponivel(LocalDate dataDisponivel) {
        this.dataDisponivel = dataDisponivel;
    }

    public Long getCodigoArtigo() {
        return codigoArtigo;
    }

    public void setCodigoArtigo(Long codigoArtigo) {
        this.codigoArtigo = codigoArtigo;
    }
}
