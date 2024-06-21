package com.test.renato.back.Controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.test.renato.back.Modelo.Tareas;
import com.test.renato.back.Servicios.TareasService;


@RestController
@RequestMapping("/api/tareas")
public class TareasContoller {
    @Autowired
    private TareasService tareasService;

    @GetMapping("/listar")
    public List<Tareas> getAllTareas() {
        return tareasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tareas> getTareaById(@PathVariable Long id) {
        Optional<Tareas> tarea = tareasService.findById(id);
        return tarea.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public List<Tareas> getTareasByNombre(@PathVariable String nombre) {
        return tareasService.findByNombre(nombre);
    }

    @PostMapping("/crear")
    public Tareas createTarea(@RequestBody Tareas tarea) {
        return tareasService.save(tarea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tareas> updateTarea(@PathVariable Long id, @RequestBody Tareas tarea) {
        tarea.setId(id);
        Tareas updatedTarea = tareasService.update(tarea);
        if (updatedTarea != null) {
            return ResponseEntity.ok(updatedTarea);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarea(@PathVariable Long id) {
        tareasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
