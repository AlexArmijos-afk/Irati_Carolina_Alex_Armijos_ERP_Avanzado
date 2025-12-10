package com.reto.erp.model;

import java.time.LocalDateTime;
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
@Table(name="Factura")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL: auto_increment
	private long id; 
	
	@Column(name = "numero_factura", nullable = false, unique = true) //MySQL: not null
	private float nFactura;
	
	@ManyToOne(optional = false)  
	@JoinColumn(name = "pedido_id", nullable = false) 
	private Pedido pedido;
	
	@Column(name = "fecha_emision", nullable = false)
	private LocalDateTime fechaEmision = LocalDateTime.now();
	
	@Column(name = "total_sin_iva", nullable = false) //MySQL: not null
	private float totalSinIva;
	
	@Column(name = "total_iva", nullable = false) //MySQL: not null
	private float iva;
	
	@Column(name = "total_con_iva", nullable = false) //MySQL: not null
	private float totalConIva;
	
	@Column(name = "estado_cobro", nullable = false) //MySQL: not null
	private EstadoFactura estado;
	
	public Factura() {}

	public Factura(long id, float nFactura, Pedido pedido, LocalDateTime fechaEmision, float totalSinIva, float iva,
			float totalConIva, EstadoFactura estado) {
		super();
		this.id = id;
		this.nFactura = nFactura;
		this.pedido = pedido;
		this.fechaEmision = fechaEmision;
		this.totalSinIva = totalSinIva;
		this.iva = iva;
		this.totalConIva = totalConIva;
		this.estado = estado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getnFactura() {
		return nFactura;
	}

	public void setnFactura(float nFactura) {
		this.nFactura = nFactura;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDateTime fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public float getTotalSinIva() {
		return totalSinIva;
	}

	public void setTotalSinIva(float totalSinIva) {
		this.totalSinIva = totalSinIva;
	}

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public float getTotalConIva() {
		return totalConIva;
	}

	public void setTotalConIva(float totalConIva) {
		this.totalConIva = totalConIva;
	}

	public EstadoFactura getEstado() {
		return estado;
	}

	public void setEstado(EstadoFactura estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(estado, fechaEmision, id, iva, nFactura, pedido, totalConIva, totalSinIva);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		return estado == other.estado && Objects.equals(fechaEmision, other.fechaEmision) && id == other.id
				&& Float.floatToIntBits(iva) == Float.floatToIntBits(other.iva)
				&& Float.floatToIntBits(nFactura) == Float.floatToIntBits(other.nFactura)
				&& Objects.equals(pedido, other.pedido)
				&& Float.floatToIntBits(totalConIva) == Float.floatToIntBits(other.totalConIva)
				&& Float.floatToIntBits(totalSinIva) == Float.floatToIntBits(other.totalSinIva);
	}
	
	
}
