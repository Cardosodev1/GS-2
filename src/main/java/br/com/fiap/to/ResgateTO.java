package br.com.fiap.to;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ResgateTO {
    private Long codigo;

    @FutureOrPresent
    private LocalDate dataResgate;

    @NotNull
    private Long codigoUsuario;

    @NotNull
    private Long codigoRecompensa;

    public ResgateTO() {
    }

    public ResgateTO(Long codigo, @FutureOrPresent LocalDate dataResgate, @NotNull Long codigoUsuario, @NotNull Long codigoRecompensa) {
        this.codigo = codigo;
        this.dataResgate = dataResgate;
        this.codigoUsuario = codigoUsuario;
        this.codigoRecompensa = codigoRecompensa;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataResgate() {
        return dataResgate;
    }

    public void setDataResgate(LocalDate dataResgate) {
        this.dataResgate = dataResgate;
    }

    public Long getCodigoRecompensa() {
        return codigoRecompensa;
    }

    public void setCodigoRecompensa(Long codigoRecompensa) {
        this.codigoRecompensa = codigoRecompensa;
    }

    public Long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
}
