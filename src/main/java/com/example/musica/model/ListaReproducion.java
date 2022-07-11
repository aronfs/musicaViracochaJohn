/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.musica.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author arons
 */
@Entity
@Table(name = "lista_reproducion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaReproducion.findAll", query = "SELECT l FROM ListaReproducion l "),
    @NamedQuery(name = "ListaReproducion.findByIdLista", query = "SELECT l FROM ListaReproducion l WHERE l.idLista = :idLista"),
    @NamedQuery(name = "ListaReproducion.findByNombre", query = "SELECT l FROM ListaReproducion l WHERE l.nombre = :nombre"),
    @NamedQuery(name = "ListaReproducion.findByDescripcion", query = "SELECT l FROM ListaReproducion l WHERE l.descripcion = :descripcion")
})
public class ListaReproducion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_lista")
    private Integer idLista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLista")
    private List<Musica> musicaList;

    public ListaReproducion() {
    }

    public ListaReproducion(Integer idLista) {
        this.idLista = idLista;
    }

    public ListaReproducion(Integer idLista, String nombre, String descripcion) {
        this.idLista = idLista;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdLista() {
        return idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Musica> getMusicaList() {
        return musicaList;
    }

    public void setMusicaList(List<Musica> musicaList) {
        this.musicaList = musicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLista != null ? idLista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaReproducion)) {
            return false;
        }
        ListaReproducion other = (ListaReproducion) object;
        if ((this.idLista == null && other.idLista != null) || (this.idLista != null && !this.idLista.equals(other.idLista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.musica.model.ListaReproducion[ idLista=" + idLista + " ]";
    }
    
}
