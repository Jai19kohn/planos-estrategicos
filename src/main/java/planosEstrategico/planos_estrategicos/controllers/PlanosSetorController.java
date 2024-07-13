package planosEstrategico.planos_estrategicos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import planosEstrategico.planos_estrategicos.models.PlanosSetorModel;
import planosEstrategico.planos_estrategicos.services.PlanosSetorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planos_setor")
public class PlanosSetorController {

    @Autowired
    private PlanosSetorService planosSetorService;

    @GetMapping
    public List<PlanosSetorModel> getAllPlanosSetor() {
        return planosSetorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanosSetorModel> getPlanoSetorById(@PathVariable Long id) {
        Optional<PlanosSetorModel> planoSetor = planosSetorService.findById(id);
        if (planoSetor.isPresent()) {
            return ResponseEntity.ok(planoSetor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public PlanosSetorModel createPlanoSetor(@RequestBody PlanosSetorModel planoSetor) {
        return planosSetorService.save(planoSetor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanosSetorModel> updatePlanoSetor(@PathVariable Long id, @RequestBody PlanosSetorModel planoSetorDetails) {
        Optional<PlanosSetorModel> planoSetor = planosSetorService.findById(id);
        if (planoSetor.isPresent()) {
            PlanosSetorModel updatedPlanoSetor = planoSetor.get();
            updatedPlanoSetor.setId_empresa(planoSetorDetails.getId_empresa());
            updatedPlanoSetor.setSetor(planoSetorDetails.getSetor());
            updatedPlanoSetor.setHorizonte(planoSetorDetails.getHorizonte());
            updatedPlanoSetor.setDescricao(planoSetorDetails.getDescricao());
            updatedPlanoSetor.setId_plano_empresa(planoSetorDetails.getId_plano_empresa());
            return ResponseEntity.ok(planosSetorService.save(updatedPlanoSetor));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlanoSetor(@PathVariable Long id) {
        planosSetorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
