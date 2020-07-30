package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object object) {
        return somaValoresDaAnnotation(object, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object object) {
        return somaValoresDaAnnotation(object, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object object) {
        return this.somar(object).subtract(this.subtrair(object));
    }

    private BigDecimal somaValoresDaAnnotation(Object classe, Class<? extends Annotation> annotationClass) {
        BigDecimal soma = BigDecimal.ZERO;
        BigDecimal value = BigDecimal.ZERO;
        for (Field atributo: classe.getClass().getDeclaredFields()) {
            if(atributo.isAnnotationPresent(annotationClass)) {
                try {
                    Method m = classe.getClass().getMethod(("get" + atributo.getName().substring(0, 1).toUpperCase() + atributo.getName().substring(1, atributo.getName().length())));
                    value = (BigDecimal) m.invoke(classe);
                } catch (IllegalArgumentException e) {
                    return BigDecimal.ZERO;
                } catch (NoSuchMethodException e) {
                    return BigDecimal.ZERO;
                } catch (SecurityException e) {
                    return BigDecimal.ZERO;
                } catch (IllegalAccessException e) {
                    return BigDecimal.ZERO;
                } catch (InvocationTargetException e) {
                    return BigDecimal.ZERO;
                }
                soma = soma.add(value);
            }
        }
        return soma;
    }
}
