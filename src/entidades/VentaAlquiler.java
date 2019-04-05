/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author wgarnicap
 */
@Entity
@Table(name = "venta_alquiler")
@NamedQueries({
    @NamedQuery(name = "VentaAlquiler.findAll", query = "SELECT v FROM VentaAlquiler v")})
public class VentaAlquiler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "venta_alquiler")
    private int ventaAlquiler;
    @Basic(optional = false)
    @Column(name = "precio_total")
    private double precioTotal;
    @Basic(optional = false)
    @Column(name = "forma_pago")
    private int formaPago;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ventaAlquiler", fetch = FetchType.LAZY)
    private VentaAlquilerProducto ventaAlquilerProducto;
    @JoinColumn(name = "num_ident_cliente", referencedColumnName = "num_identificacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tercero numIdentCliente;
    @JoinColumn(name = "num_ident_vendedor", referencedColumnName = "num_identificacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tercero numIdentVendedor;

    public VentaAlquiler() {
    }

    public VentaAlquiler(Long id) {
        this.id = id;
    }

    public VentaAlquiler(Long id, int ventaAlquiler, double precioTotal, int formaPago, Date fecha) {
        this.id = id;
        this.ventaAlquiler = ventaAlquiler;
        this.precioTotal = precioTotal;
        this.formaPago = formaPago;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVentaAlquiler() {
        return ventaAlquiler;
    }

    public void setVentaAlquiler(int ventaAlquiler) {
        this.ventaAlquiler = ventaAlquiler;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(int formaPago) {
        this.formaPago = formaPago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public VentaAlquilerProducto getVentaAlquilerProducto() {
        return ventaAlquilerProducto;
    }

    public void setVentaAlquilerProducto(VentaAlquilerProducto ventaAlquilerProducto) {
        this.ventaAlquilerProducto = ventaAlquilerProducto;
    }

    public Tercero getNumIdentCliente() {
        return numIdentCliente;
    }

    public void setNumIdentCliente(Tercero numIdentCliente) {
        this.numIdentCliente = numIdentCliente;
    }

    public Tercero getNumIdentVendedor() {
        return numIdentVendedor;
    }

    public void setNumIdentVendedor(Tercero numIdentVendedor) {
        this.numIdentVendedor = numIdentVendedor;
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
        if (!(object instanceof VentaAlquiler)) {
            return false;
        }
        VentaAlquiler other = (VentaAlquiler) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.VentaAlquiler[ id=" + id + " ]";
    }
    
}
