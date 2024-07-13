package planosEstrategico.planos_estrategicos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import planosEstrategico.planos_estrategicos.models.EmpresaModel;
import planosEstrategico.planos_estrategicos.services.EmpresaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<EmpresaModel> getAllEmpresas() {
        return empresaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaModel> getEmpresaById(@PathVariable Long id) {
        Optional<EmpresaModel> empresa = empresaService.findById(id);
        return empresa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EmpresaModel> createEmpresa(@RequestBody EmpresaModel empresa) {
        EmpresaModel novaEmpresa = empresaService.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEmpresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaModel> updateEmpresa(@PathVariable Long id, @RequestBody EmpresaModel empresaDetails) {
        EmpresaModel updatedEmpresa = empresaService.update(id, empresaDetails);
        if (updatedEmpresa != null) {
            return ResponseEntity.ok(updatedEmpresa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable Long id) {
        empresaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
