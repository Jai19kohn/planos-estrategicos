package planosEstrategico.planos_estrategicos.models;

import jakarta.persistence.*;
import java.util.UUID;
import java.io.Serializable;

@Entity
@Table(name = "perspectivas")
public class PerspectivasModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "plano_id", nullable = true)
    private PlanosEmpresaModel planoEmpresa;

    @ManyToOne
    @JoinColumn(name = "plano_setor_id", nullable = true)
    private PlanosSetorModel planoSetor;

    @Column(name = "descricao_perspectiva")
    private String descricaoPerspectiva;

    @Column(name = "objetivos")
    private String objetivos;

    // Getters e Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PlanosEmpresaModel getPlanoEmpresa() {
        return planoEmpresa;
    }

    public void setPlanoEmpresa(PlanosEmpresaModel planoEmpresa) {
        this.planoEmpresa = planoEmpresa;
    }

    public PlanosSetorModel getPlanoSetor() {
        return planoSetor;
    }

    public void setPlanoSetor(PlanosSetorModel planoSetor) {
        this.planoSetor = planoSetor;
    }

    public String getDescricaoPerspectiva() {
        return descricaoPerspectiva;
    }

    public void setDescricaoPerspectiva(String descricaoPerspectiva) {
        this.descricaoPerspectiva = descricaoPerspectiva;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }
}
