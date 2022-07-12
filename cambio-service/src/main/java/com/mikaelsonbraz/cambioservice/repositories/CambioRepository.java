package com.mikaelsonbraz.cambioservice.repositories;

import com.mikaelsonbraz.cambioservice.models.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CambioRepository extends JpaRepository<Cambio, Long> {

    Cambio findByFromAndTo(String from, String to);
}
