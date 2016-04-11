/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author paulkibe
 */
@Entity
@Table(name = "agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a"),
    @NamedQuery(name = "Agenda.findById", query = "SELECT a FROM Agenda a WHERE a.id = :id"),
    @NamedQuery(name = "Agenda.findByUsuarioId", query = "SELECT a FROM Agenda a WHERE a.usuario.id = :usuarioId"),
    @NamedQuery(name = "Agenda.findByDescricao", query = "SELECT a FROM Agenda a WHERE a.descricao = :descricao"),
    @NamedQuery(name = "Agenda.findByDataInicio", query = "SELECT a FROM Agenda a WHERE a.dataInicio = :dataInicio"),
    @NamedQuery(name = "Agenda.findByDataFim", query = "SELECT a FROM Agenda a WHERE a.dataFim = :dataFim"),
    @NamedQuery(name = "Agenda.findByDataCriacaoAgenda", query = "SELECT a FROM Agenda a WHERE a.dataCriacaoAgenda = :dataCriacaoAgenda")})
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "data_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;
    @Column(name = "data_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;
    @Basic(optional = false)
    @Column(name = "data_criacao_agenda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacaoAgenda;
    @JoinColumn(name = "id_tipo_agenda", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoAgenda tipoAgenda;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agenda")
    private List<Percurso> percursoList;

    public Agenda() {
    }

    public Agenda(Integer id, String descricao, Date dataInicio, Date dataFim, Date dataCriacaoAgenda, TipoAgenda tipoAgenda, Usuario usuario, List<Percurso> percursoList) {
        this.id = id;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataCriacaoAgenda = dataCriacaoAgenda;
        this.tipoAgenda = tipoAgenda;
        this.usuario = usuario;
        this.percursoList = percursoList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataCriacaoAgenda() {
        return dataCriacaoAgenda;
    }

    public void setDataCriacaoAgenda(Date dataCriacaoAgenda) {
        this.dataCriacaoAgenda = dataCriacaoAgenda;
    }

    public TipoAgenda getTipoAgenda() {
        return tipoAgenda;
    }

    public void setTipoAgenda(TipoAgenda tipoAgenda) {
        this.tipoAgenda = tipoAgenda;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<Percurso> getPercursoList() {
        return percursoList;
    }

    public void setPercursoList(List<Percurso> percursoList) {
        this.percursoList = percursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.entidade.Agenda[ id=" + id + " ]";
    }
    
}
