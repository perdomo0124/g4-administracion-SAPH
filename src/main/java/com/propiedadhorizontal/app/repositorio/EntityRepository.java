package com.propiedadhorizontal.app.repositorio;

import com.propiedadhorizontal.app.modelo.Apartamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends JpaRepository<Apartamento,Long> {
}
