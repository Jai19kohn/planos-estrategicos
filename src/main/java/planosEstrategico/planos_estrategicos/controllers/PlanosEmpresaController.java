package planosEstrategico.planos_estrategicos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import planosEstrategico.planos_estrategicos.models.PlanosEmpresaModel;
import planosEstrategico.planos_estrategicos.services.PlanosEmpresaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planos_empresa")
public class PlanosEmpresaController {

    @Autowired
    private PlanosEmpresaService planosEmpresaService;

    @GetMapping
    public List<PlanosEmpresaModel> getAllPlanosEmpresa() {
        return planosEmpresaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanosEmpresaModel> getPlanoEmpresaById(@PathVariable Long id) {
        Optional<PlanosEmpresaModel> planoEmpresa = planosEmpresaService.findById(id);
        if (planoEmpresa.isPresent()) {
            return ResponseEntity.ok(planoEmpresa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public PlanosEmpresaModel createPlanoEmpresa(@RequestBody PlanosEmpresaModel planoEmpresa) {
        return planosEmpresaService.save(planoEmpresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanosEmpresaModel> updatePlanoEmpresa(@PathVariable Long id, @RequestBody PlanosEmpresaModel planoEmpresaDetails) {
        Optional<PlanosEmpresaModel> planoEmpresa = planosEmpresaService.findById(id);
        if (planoEmpresa.isPresent()) {
            PlanosEmpresaModel updatedPlanoEmpresa = planoEmpresa.get();
            updatedPlanoEmpresa.setId_empresa(planoEmpresaDetails.getId_empresa());
            updatedPlanoEmpresa.setHorizonte(planoEmpresaDetails.getHorizonte());
            updatedPlanoEmpresa.setDescricao(planoEmpresaDetails.getDescricao());
            return ResponseEntity.ok(planosEmpresaService.save(updatedPlanoEmpresa));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlanoEmpresa(@PathVariable Long id) {
        planosEmpresaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
