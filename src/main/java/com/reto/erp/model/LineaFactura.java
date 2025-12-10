package com.reto.erp.model;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@SuppressWarnings("unused")
@Entity
@Table(name="Linea_Factura")
public class LineaFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lineaFacturaId;

    @Column(nullable = false)
    private long facturaId; // FK → FACTURA.factura_id

    @Column(nullable = false)
    private long productoId; // FK → PRODUCTO.producto_id

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

    public LineaFactura() {}

	public LineaFactura(long lineaFacturaId, long facturaId, long productoId, String descripcionProducto, int cantidad,
			BigDecimal precioUnitario, BigDecimal ivaPorcentaje, BigDecimal subtotalSinImpuestos,
			BigDecimal subtotalIva, BigDecimal subtotalConImpuestos) {
		super();
		this.lineaFacturaId = lineaFacturaId;
		this.facturaId = facturaId;
		this.productoId = productoId;
		this.descripcionProducto = descripcionProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.ivaPorcentaje = ivaPorcentaje;
		this.subtotalSinImpuestos = subtotalSinImpuestos;
		this.subtotalIva = subtotalIva;
		this.subtotalConImpuestos = subtotalConImpuestos;
	}

	public long getLineaFacturaId() {
		return lineaFacturaId;
	}

	public void setLineaFacturaId(long lineaFacturaId) {
		this.lineaFacturaId = lineaFacturaId;
	}

	public long getFacturaId() {
		return facturaId;
	}

	public void setFacturaId(long facturaId) {
		this.facturaId = facturaId;
	}

	public long getProductoId() {
		return productoId;
	}

	public void setProductoId(long productoId) {
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
    
    

}
