package planosEstrategico.planos_estrategicos.models;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import java.util.UUID;

import java.io.Serializable;

@Entity
@Table(name = "planos_estrategicos_setor")
public class PlanosSetorModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "id_empresa")
    private Long id_empresa;

    @Column
    private String setor;

    @Column
    private String horizonte;

    @Column
    private String descricao;

    @OneToOne
    @JoinColumn(name = "id_plano_empresa")
    private Long id_plano_empresa;

    public PlanosSetorModel() {
    }

    //GETTERS E SETTERS

    public UUID getId() {
        return id;
    }

    public String getSetor() {
        return setor;
    }

    public String getHorizonte() {
        return horizonte;
    }

    public Long getId_empresa() {
        return id_empresa;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getId_plano_empresa() {
        return id_plano_empresa;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setId_empresa(Long id_empresa) {
        this.id_empresa = id_empresa;
    }

    public void setHorizonte(String horisonte) {
        this.horizonte = horisonte;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId_plano_empresa(Long plano_pai_id) {
        this.id_plano_empresa = plano_pai_id;
    }
}
