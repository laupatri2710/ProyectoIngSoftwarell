/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author wgarnicap
 */
@Entity
@Table(name = "venta_alquiler_producto")
@NamedQueries({
    @NamedQuery(name = "VentaAlquilerProducto.findAll", query = "SELECT v FROM VentaAlquilerProducto v")})
public class VentaAlquilerProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_venta_alquiler")
    private Long idVentaAlquiler;
    @Basic(optional = false)
    @Column(name = "precio_producto")
    private double precioProducto;
    @JoinColumn(name = "cod_producto", referencedColumnName = "cod_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto codProducto;
    @JoinColumn(name = "id_venta_alquiler", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private VentaAlquiler ventaAlquiler;

    public VentaAlquilerProducto() {
    }

    public VentaAlquilerProducto(Long idVentaAlquiler) {
        this.idVentaAlquiler = idVentaAlquiler;
    }

    public VentaAlquilerProducto(Long idVentaAlquiler, double precioProducto) {
        this.idVentaAlquiler = idVentaAlquiler;
        this.precioProducto = precioProducto;
    }

    public Long getIdVentaAlquiler() {
        return idVentaAlquiler;
    }

    public void setIdVentaAlquiler(Long idVentaAlquiler) {
        this.idVentaAlquiler = idVentaAlquiler;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    public VentaAlquiler getVentaAlquiler() {
        return ventaAlquiler;
    }

    public void setVentaAlquiler(VentaAlquiler ventaAlquiler) {
        this.ventaAlquiler = ventaAlquiler;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVentaAlquiler != null ? idVentaAlquiler.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaAlquilerProducto)) {
            return false;
        }
        VentaAlquilerProducto other = (VentaAlquilerProducto) object;
        if ((this.idVentaAlquiler == null && other.idVentaAlquiler != null) || (this.idVentaAlquiler != null && !this.idVentaAlquiler.equals(other.idVentaAlquiler))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.VentaAlquilerProducto[ idVentaAlquiler=" + idVentaAlquiler + " ]";
    }
    
}
