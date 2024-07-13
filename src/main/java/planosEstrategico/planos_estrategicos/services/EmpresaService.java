package planosEstrategico.planos_estrategicos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import planosEstrategico.planos_estrategicos.models.EmpresaModel;
import planosEstrategico.planos_estrategicos.repositories.EmpresaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<EmpresaModel> findAll() {
        return empresaRepository.findAll();
    }

    public Optional<EmpresaModel> findById(Long id) {
        return empresaRepository.findById(id);
    }

    public EmpresaModel save(EmpresaModel empresa) {
        return empresaRepository.save(empresa);
    }

    public EmpresaModel update(Long id, EmpresaModel empresa){
        Optional<EmpresaModel> empresaExistenteOpt = empresaRepository.findById(id);
        if (empresaExistenteOpt.isPresent()) {
            EmpresaModel empresaExistente = empresaExistenteOpt.get();
            empresaExistente.setNomeEmpresa(empresa.getNomeEmpresa());
            empresaExistente.setMissao(empresa.getMissao());
            empresaExistente.setVisao(empresa.getVisao());
            empresaExistente.setValores(empresa.getValores());
            return empresaRepository.save(empresaExistente);
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        empresaRepository.deleteById(id);
    }
}
