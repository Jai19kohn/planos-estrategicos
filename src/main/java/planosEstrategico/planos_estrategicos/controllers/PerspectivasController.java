package planosEstrategico.planos_estrategicos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import planosEstrategico.planos_estrategicos.models.PerspectivasModel;
import planosEstrategico.planos_estrategicos.services.PerspectivasService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/perspectivas")
public class PerspectivasController {

    @Autowired
    private PerspectivasService perspectivasService;

    @GetMapping
    public List<PerspectivasModel> getAllPerspectivas() {
        return perspectivasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerspectivasModel> getPerspectivaById(@PathVariable Long id) {
        Optional<PerspectivasModel> perspectiva = perspectivasService.findById(id);
        return perspectiva.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PerspectivasModel> createPerspectiva(@RequestBody PerspectivasModel perspectiva) {
        PerspectivasModel novaPerspectiva = perspectivasService.save(perspectiva);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPerspectiva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerspectivasModel> updatePerspectiva(@PathVariable Long id, @RequestBody PerspectivasModel perspectivaDetails) {
        PerspectivasModel updatedPerspectiva = perspectivasService.update(id, perspectivaDetails);
        if (updatedPerspectiva != null) {
            return ResponseEntity.ok(updatedPerspectiva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerspectiva(@PathVariable Long id) {
        perspectivasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
