package planosEstrategico.planos_estrategicos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import planosEstrategico.planos_estrategicos.models.PerspectivasModel;

@Repository
public interface PerspectivasRepository extends JpaRepository<PerspectivasModel, Long> {
}
