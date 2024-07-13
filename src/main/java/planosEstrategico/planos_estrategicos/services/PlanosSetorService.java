package planosEstrategico.planos_estrategicos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import planosEstrategico.planos_estrategicos.models.PlanosSetorModel;
import planosEstrategico.planos_estrategicos.repositories.PlanosSetorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlanosSetorService {

    @Autowired
    private PlanosSetorRepository planosSetorRepository;

    public List<PlanosSetorModel> findAll() {
        return planosSetorRepository.findAll();
    }

    public Optional<PlanosSetorModel> findById(Long id) {
        return planosSetorRepository.findById(id);
    }

    public PlanosSetorModel save(PlanosSetorModel planosEmpresa) {
        return planosSetorRepository.save(planosEmpresa);
    }

    public void deleteById(Long id) {
        planosSetorRepository.deleteById(id);
    }
}