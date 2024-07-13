package planosEstrategico.planos_estrategicos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import planosEstrategico.planos_estrategicos.models.PlanosSetorModel;

@Repository
public interface PlanosSetorRepository extends JpaRepository<PlanosSetorModel, Long> {
}