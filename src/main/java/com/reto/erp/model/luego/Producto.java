package com.reto.erp.model.luego;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productoId;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String sku;

    @Column
    private String descripcion;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal ivaPorcentaje;

    @Column(nullable = false)
    private int stockActual;

    @Column(nullable = false)
    private int stockMinimo;

    public Producto() {}

    public Producto(long productoId, String nombre, String sku, String descripcion,
                    BigDecimal precioUnitario, BigDecimal ivaPorcentaje, int stockActual, int stockMinimo) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.sku = sku;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.ivaPorcentaje = ivaPorcentaje;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
    }

	public long getProductoId() {
		return productoId;
	}

	public void setProductoId(long productoId) {
		this.productoId = productoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public int getStockActual() {
		return stockActual;
	}

	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, ivaPorcentaje, nombre, precioUnitario, productoId, sku, stockActual,
				stockMinimo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(ivaPorcentaje, other.ivaPorcentaje)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(precioUnitario, other.precioUnitario)
				&& productoId == other.productoId && Objects.equals(sku, other.sku) && stockActual == other.stockActual
				&& stockMinimo == other.stockMinimo;
	}
    
    
}