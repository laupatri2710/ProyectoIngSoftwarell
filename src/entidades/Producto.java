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
@Table(name = "producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_producto")
    private Long codProducto;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "habilitado")
    private Boolean habilitado;
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "precio_venta")
    private double precioVenta;
    @Basic(optional = false)
    @Column(name = "precio_alquiler")
    private double precioAlquiler;
    @ManyToMany(mappedBy = "productoList", fetch = FetchType.LAZY)
    private List<CategoriaProducto> categoriaProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProducto", fetch = FetchType.LAZY)
    private List<VentaAlquilerProducto> ventaAlquilerProductoList;

    public Producto() {
    }

    public Producto(Long codProducto) {
        this.codProducto = codProducto;
    }

    public Producto(Long codProducto, String nombre, double precioVenta, double precioAlquiler) {
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.precioAlquiler = precioAlquiler;
    }

    public Long getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Long codProducto) {
        this.codProducto = codProducto;
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

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public List<CategoriaProducto> getCategoriaProductoList() {
        return categoriaProductoList;
    }

    public void setCategoriaProductoList(List<CategoriaProducto> categoriaProductoList) {
        this.categoriaProductoList = categoriaProductoList;
    }

    public List<VentaAlquilerProducto> getVentaAlquilerProductoList() {
        return ventaAlquilerProductoList;
    }

    public void setVentaAlquilerProductoList(List<VentaAlquilerProducto> ventaAlquilerProductoList) {
        this.ventaAlquilerProductoList = ventaAlquilerProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProducto != null ? codProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codProducto == null && other.codProducto != null) || (this.codProducto != null && !this.codProducto.equals(other.codProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Producto[ codProducto=" + codProducto + " ]";
    }
    
}
