package com.challenge.desafio;

import java.math.BigDecimal;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

public class ClasseParaCalcular {

    @Somar
    private BigDecimal somarUM;

    @Somar
    private BigDecimal somarDOIS;

    @Subtrair
    private BigDecimal subitrairUM;

    @Subtrair
    private BigDecimal subitrairDOIS;

    public ClasseParaCalcular(BigDecimal somarUM, BigDecimal somarDOIS, BigDecimal subitrairUM,
                              BigDecimal subitrairDOIS) {
        this.somarUM = somarUM;
        this.somarDOIS = somarDOIS;
        this.subitrairUM = subitrairUM;
        this.subitrairDOIS = subitrairDOIS;
    }

    public BigDecimal getSomarUM() {
        return somarUM;
    }

    public void setSomarUM(BigDecimal somarUM) {
        this.somarUM = somarUM;
    }

    public BigDecimal getSomarDOIS() {
        return somarDOIS;
    }

    public void setSomarDOIS(BigDecimal somarDOIS) {
        this.somarDOIS = somarDOIS;
    }

    public BigDecimal getSubitrairUM() {
        return subitrairUM;
    }

    public void setSubitrairUM(BigDecimal subitrairUM) {
        this.subitrairUM = subitrairUM;
    }

    public BigDecimal getSubitrairDOIS() {
        return subitrairDOIS;
    }

    public void setSubitrairDOIS(BigDecimal subitrairDOIS) {
        this.subitrairDOIS = subitrairDOIS;
    }

    public BigDecimal getParaSomar() {
        return somarUM;
    }

    public void setParaSomar(BigDecimal paraSomar) {
        this.somarUM = paraSomar;
    }

    public BigDecimal getParaSubtrair() {
        return subitrairUM;
    }

    public void setParaSubtrair(BigDecimal paraSubtrair) {
        this.subitrairUM = paraSubtrair;
    }

}
