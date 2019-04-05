/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author wgarnicap
 */
@Entity
@Table(name = "tercero")
@NamedQueries({
    @NamedQuery(name = "Tercero.findAll", query = "SELECT t FROM Tercero t")})
public class Tercero implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "num_identificacion")
    private Long numIdentificacion;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;
    @Column(name = "habilitado")
    private Boolean habilitado;
    @Basic(optional = false)
    @Column(name = "clave")
    private String clave;
   
    @ManyToMany(mappedBy = "terceroList", fetch = FetchType.LAZY)
    private List<Rol> rolList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numIdentCliente", fetch = FetchType.LAZY)
    private List<VentaAlquiler> ventaAlquilerList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numIdentVendedor", fetch = FetchType.LAZY)
    private List<VentaAlquiler> ventaAlquilerList1;

    public Tercero() {
    }

    public Tercero(Long numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public Tercero(Long numIdentificacion, String nombres, String apellidos, String clave) {
        this.numIdentificacion = numIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.clave = clave;
    }

    public Long getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(Long numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    public List<VentaAlquiler> getVentaAlquilerList() {
        return ventaAlquilerList;
    }

    public void setVentaAlquilerList(List<VentaAlquiler> ventaAlquilerList) {
        this.ventaAlquilerList = ventaAlquilerList;
    }

    public List<VentaAlquiler> getVentaAlquilerList1() {
        return ventaAlquilerList1;
    }

    public void setVentaAlquilerList1(List<VentaAlquiler> ventaAlquilerList1) {
        this.ventaAlquilerList1 = ventaAlquilerList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numIdentificacion != null ? numIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tercero)) {
            return false;
        }
        Tercero other = (Tercero) object;
        if ((this.numIdentificacion == null && other.numIdentificacion != null) || (this.numIdentificacion != null && !this.numIdentificacion.equals(other.numIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tercero[ numIdentificacion=" + numIdentificacion + " ]";
    }
    
}
