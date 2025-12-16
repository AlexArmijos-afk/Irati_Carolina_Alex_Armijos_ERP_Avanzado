package com.reto.erp.model.luego;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Linea_Pedido")
public class LineaPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lineaPedidoId;

    @ManyToOne(optional = false)  
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedidoId;

    @ManyToOne(optional = false)  
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto productoId;

    @Column(nullable = false)
    private String descripcionProducto;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal ivaPorcentaje;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotalSinImpuestos;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotalIva;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotalConImpuestos;

    public LineaPedido() {}

	public LineaPedido(long lineaPedidoId, Pedido pedidoId, Producto productoId, String descripcionProducto, int cantidad,
			BigDecimal precioUnitario, BigDecimal ivaPorcentaje, BigDecimal subtotalSinImpuestos,
			BigDecimal subtotalIva, BigDecimal subtotalConImpuestos) {
		super();
		this.lineaPedidoId = lineaPedidoId;
		this.pedidoId = pedidoId;
		this.productoId = productoId;
		this.descripcionProducto = descripcionProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.ivaPorcentaje = ivaPorcentaje;
		this.subtotalSinImpuestos = subtotalSinImpuestos;
		this.subtotalIva = subtotalIva;
		this.subtotalConImpuestos = subtotalConImpuestos;
	}

	public long getLineaPedidoId() {
		return lineaPedidoId;
	}

	public void setLineaPedidoId(long lineaPedidoId) {
		this.lineaPedidoId = lineaPedidoId;
	}

	public Pedido getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Pedido pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Producto getProductoId() {
		return productoId;
	}

	public void setProductoId(Producto productoId) {
		this.productoId = productoId;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getIvaPorcentaje() {
		return ivaPorcentaje;
	}

	public void setIvaPorcentaje(BigDecimal ivaPorcentaje) {
		this.ivaPorcentaje = ivaPorcentaje;
	}

	public BigDecimal getSubtotalSinImpuestos() {
		return subtotalSinImpuestos;
	}

	public void setSubtotalSinImpuestos(BigDecimal subtotalSinImpuestos) {
		this.subtotalSinImpuestos = subtotalSinImpuestos;
	}

	public BigDecimal getSubtotalIva() {
		return subtotalIva;
	}

	public void setSubtotalIva(BigDecimal subtotalIva) {
		this.subtotalIva = subtotalIva;
	}

	public BigDecimal getSubtotalConImpuestos() {
		return subtotalConImpuestos;
	}

	public void setSubtotalConImpuestos(BigDecimal subtotalConImpuestos) {
		this.subtotalConImpuestos = subtotalConImpuestos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, descripcionProducto, ivaPorcentaje, lineaPedidoId, pedidoId, precioUnitario,
				productoId, subtotalConImpuestos, subtotalIva, subtotalSinImpuestos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineaPedido other = (LineaPedido) obj;
		return cantidad == other.cantidad && Objects.equals(descripcionProducto, other.descripcionProducto)
				&& Objects.equals(ivaPorcentaje, other.ivaPorcentaje) && lineaPedidoId == other.lineaPedidoId
				&& Objects.equals(pedidoId, other.pedidoId) && Objects.equals(precioUnitario, other.precioUnitario)
				&& Objects.equals(productoId, other.productoId)
				&& Objects.equals(subtotalConImpuestos, other.subtotalConImpuestos)
				&& Objects.equals(subtotalIva, other.subtotalIva)
				&& Objects.equals(subtotalSinImpuestos, other.subtotalSinImpuestos);
	}
    
    

}