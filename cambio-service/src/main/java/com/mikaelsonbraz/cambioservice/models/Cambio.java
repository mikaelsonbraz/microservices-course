package com.mikaelsonbraz.cambioservice.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Cambio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cambioId;

    @Column(name = "from_currency", nullable = false, length = 3)
    private String from;
    @Column(name = "to_currency", nullable = false, length = 3)
    private String to;
    @Column(nullable = false)
    private BigDecimal conversionFactor;

    @Transient
    private BigDecimal convertedValue;
    @Transient
    private String environment;

    public Cambio() {
    }

    public Cambio(Long cambioId, String from, String to, BigDecimal conversionFactor, BigDecimal convertedValue, String environment) {
        this.cambioId = cambioId;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
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

    public BigDecimal getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(BigDecimal conversionFactory) {
        this.conversionFactor = conversionFactory;
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
        return Objects.equals(cambioId, cambio.cambioId) && Objects.equals(from, cambio.from) && Objects.equals(to, cambio.to) && Objects.equals(conversionFactor, cambio.conversionFactor) && Objects.equals(convertedValue, cambio.convertedValue) && Objects.equals(environment, cambio.environment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cambioId, from, to, conversionFactor, convertedValue, environment);
    }

    @Override
    public String toString() {
        return "Cambio{" +
                "cambioId=" + cambioId +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", conversionFactor=" + conversionFactor +
                ", convertedValue=" + convertedValue +
                ", environment='" + environment + '\'' +
                '}';
    }
}
