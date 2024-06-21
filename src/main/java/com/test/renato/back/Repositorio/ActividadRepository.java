package com.test.renato.back.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.renato.back.Modelo.Tareas;



@Repository
public interface ActividadRepository extends JpaRepository<Tareas, Long> {

    public List<Tareas> findByNombre(String nombre);
    

    @Query("SELECT t FROM Tareas t WHERE t.eliminar = false AND t.completada = false")
    List<Tareas> findAllActive();

    @Query("SELECT t FROM Tareas t WHERE t.id = :id AND t.eliminar = false AND t.completada = false")
    Optional<Tareas> findActiveById(Long id);

    public Optional<Tareas> findById(Long id);
}