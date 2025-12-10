package com.reto.erp.model;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Movimiento_Stock")
public class MovimientoStock {

    public enum TipoMovimiento {
        ENTRADA,
        SALIDA,
        AJUSTE
    }

    public enum Motivo {
        VENTA,
        COMPRA,
        AJUSTE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movimientoStockId;

    @Column(nullable = false)
    private long productoId; // FK → PRODUCTO.producto_id

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMovimiento tipoMovimiento;

    @Column(nullable = false)
    private int cantidad; // positiva o negativa según movimiento

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Motivo motivo;

    @Column
    private String referencia;

    @Column(nullable = false)
    private long hechoPor; // FK → USUARIO.usuario_id

    public MovimientoStock() {}

    public MovimientoStock(long movimientoStockId, long productoId, LocalDateTime fecha,
                           TipoMovimiento tipoMovimiento, int cantidad, Motivo motivo,
                           String referencia, long hechoPor) {
        this.movimientoStockId = movimientoStockId;
        this.productoId = productoId;
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
        this.motivo = motivo;
        this.referencia = referencia;
        this.hechoPor = hechoPor;
    }

	public long getMovimientoStockId() {
		return movimientoStockId;
	}

	public void setMovimientoStockId(long movimientoStockId) {
		this.movimientoStockId = movimientoStockId;
	}

	public long getProductoId() {
		return productoId;
	}

	public void setProductoId(long productoId) {
		this.productoId = productoId;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public long getHechoPor() {
		return hechoPor;
	}

	public void setHechoPor(long hechoPor) {
		this.hechoPor = hechoPor;
	}
    
    
}