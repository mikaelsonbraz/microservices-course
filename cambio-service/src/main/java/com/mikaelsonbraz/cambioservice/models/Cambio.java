package com.mikaelsonbraz.cambioservice.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Cambio implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long cambioId;
    private String from;
    private String to;
    private BigDecimal conversionFactory;
    private BigDecimal convertedValue;
    private String environment;

    public Cambio() {
    }

    public Cambio(Long cambioId, String from, String to, BigDecimal conversionFactory, BigDecimal convertedValue, String environment) {
        this.cambioId = cambioId;
        this.from = from;
        this.to = to;
        this.conversionFactory = conversionFactory;
        this.convertedValue = convertedValue;
        this.environment = environment;
    }

    public Long getCambioId() {
        return cambioId;
    }

    public void setCambioId(Long cambioId) {
        this.cambioId = cambioId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionFactory() {
        return conversionFactory;
    }

    public void setConversionFactory(BigDecimal conversionFactory) {
        this.conversionFactory = conversionFactory;
    }

    public BigDecimal getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(BigDecimal convertedValue) {
        this.convertedValue = convertedValue;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cambio cambio = (Cambio) o;
        return Objects.equals(cambioId, cambio.cambioId) && Objects.equals(from, cambio.from) && Objects.equals(to, cambio.to) && Objects.equals(conversionFactory, cambio.conversionFactory) && Objects.equals(convertedValue, cambio.convertedValue) && Objects.equals(environment, cambio.environment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cambioId, from, to, conversionFactory, convertedValue, environment);
    }
}
