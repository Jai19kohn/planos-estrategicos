package planosEstrategico.planos_estrategicos.models;

import jakarta.persistence.*;
import java.util.UUID;

import java.io.Serializable;

@Entity
@Table(name = "planos_estrategicos_setor")
public class EmpresaModel implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column
    private String nomeEmpresa;

    @Column
    private String missao;

    @Column
    private String visao;

    @Column
    private String valores;

    public EmpresaModel() {
    }

//GETTERS E SETTERS

    public UUID getId() {
        return id;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public String getMissao() {
        return missao;
    }

    public String getVisao() {
        return visao;
    }

    public String getValores() {
        return valores;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public void setMissao(String missao) {
        this.missao = missao;
    }

    public void setVisao(String visao) {
        this.visao = visao;
    }

    public void setValores(String valores) {
        this.valores = valores;
    }
}
