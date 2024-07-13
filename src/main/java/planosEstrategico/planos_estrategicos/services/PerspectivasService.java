package planosEstrategico.planos_estrategicos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import planosEstrategico.planos_estrategicos.models.PerspectivasModel;
import planosEstrategico.planos_estrategicos.repositories.PerspectivasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PerspectivasService {

    @Autowired
    private PerspectivasRepository perspectivasRepository;

    public List<PerspectivasModel> findAll() {
        return perspectivasRepository.findAll();
    }

    public Optional<PerspectivasModel> findById(Long id) {
        return perspectivasRepository.findById(id);
    }

    public PerspectivasModel save(PerspectivasModel perspectivas) {
        return perspectivasRepository.save(perspectivas);
    }

    public PerspectivasModel update(Long id, PerspectivasModel perspectivas) {
        Optional<PerspectivasModel> perspectivasExistenteOpt = perspectivasRepository.findById(id);
        if (perspectivasExistenteOpt.isPresent()) {
            PerspectivasModel perspectivasExistente = perspectivasExistenteOpt.get();
            perspectivasExistente.setPlanoEmpresa(perspectivas.getPlanoEmpresa());
            perspectivasExistente.setPlanoSetor(perspectivas.getPlanoSetor());
            perspectivasExistente.setDescricaoPerspectiva(perspectivas.getDescricaoPerspectiva());
            perspectivasExistente.setObjetivos(perspectivas.getObjetivos());
            return perspectivasRepository.save(perspectivasExistente);
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        perspectivasRepository.deleteById(id);
    }
}
