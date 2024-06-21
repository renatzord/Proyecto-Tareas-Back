package com.test.renato.back.Servicios;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.test.renato.back.Modelo.Tareas;
import com.test.renato.back.Repositorio.ActividadRepository;


@Service
@Transactional
public class TareasService {


    @Autowired
    private ActividadRepository actividadRepository;

    public List<Tareas> findAll() {
        return actividadRepository.findAllActive();
    }

    public Optional<Tareas> findById(Long id) {
        return actividadRepository.findActiveById(id);
    }

    public List<Tareas> findByNombre(String nombre) {
        return actividadRepository.findByNombre(nombre);
    }

    public Tareas save(Tareas tarea) {
        return actividadRepository.save(tarea);
    }

    public void deleteById(Long id) {
        Optional<Tareas> tarea = actividadRepository.findById(id);
        tarea.ifPresent(t -> {
            t.setEliminar(true);
            actividadRepository.save(t);
        });
    }

    public Tareas update(Tareas tarea) {
        Optional<Tareas> existingTarea = actividadRepository.findById(tarea.getId());
        if (existingTarea.isPresent()) {
            Tareas updatedTarea = existingTarea.get();
            updatedTarea.setNombre(tarea.getNombre());
            updatedTarea.setDescripcion(tarea.getDescripcion());
            updatedTarea.setCompletada(tarea.isCompletada());
            updatedTarea.setEliminar(tarea.isEliminar());
            return actividadRepository.save(updatedTarea);
        } else {
            return null;
        }
    }

    
    public Tareas markAsCompleted(Long id) {
        Optional<Tareas> tareaOpt = actividadRepository.findById(id);
        if (tareaOpt.isPresent()) {
            Tareas tarea = tareaOpt.get();
            tarea.setCompletada(true);
            return actividadRepository.save(tarea);
        } else {
            throw new RuntimeException("Tarea no encontrada");
        }
    }


    
}
