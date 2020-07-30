package com.challenge.testes;

import com.challenge.desafio.CalculadorDeClasses;
import com.challenge.desafio.ClasseParaCalcular;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CalculadorDeClassesTest {
    private CalculadorDeClasses calculadorDeClasses;
    private ClasseParaCalcular paraCalcular;

    @Before
    public void setup() {
        this.calculadorDeClasses = new CalculadorDeClasses();
        this.paraCalcular = new ClasseParaCalcular(new BigDecimal(100),
                new BigDecimal(100),
                new BigDecimal(100),
                new BigDecimal(100));
    }

    @Test
    public void deveSomarCamposAnotadosSomarDaclasse() {
        assertEquals(new BigDecimal(200), calculadorDeClasses.somar(paraCalcular));
    }

    @Test
    public void deveSomarCamposAnotadosSubtrairDaclasse() {
        assertEquals(new BigDecimal(200), calculadorDeClasses.subtrair(paraCalcular));
    }

    @Test
    public void deveSubtrairCamposAnotadosDaclasseDosCamposAnotadosComSomar() {
        assertEquals(new BigDecimal(0), calculadorDeClasses.totalizar(paraCalcular));
    }
}
