package com.reto.erp.model.luego;

import java.time.LocalDateTime;
import java.util.Objects;

import com.reto.erp.model.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Pedido")
public class Pedido {
	
	public enum EstadoPedido {PENDIENTE, PAGADO, ENVIADO, CANCELADO}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL: auto_increment
	private long id; 
	
	@ManyToOne(optional = false)  
	@JoinColumn(name = "cliente_id", nullable = false) 
	private Cliente cliente;
	
	@Column(name = "fecha_pedido", nullable = false)
	private LocalDateTime fechaPedido = LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false) //MySQL: not null
	private EstadoPedido estado;
	
	@Column(name = "total_sin_iva", nullable = false) //MySQL: not null
	private float totalSinIva;
	
	@Column(name = "total_iva", nullable = false) //MySQL: not null
	private float iva;
	@Column(name = "total_con_iva", nullable = false) //MySQL: not null
	private float totalConIva;
	
	@ManyToOne(optional = false)  // un cliente SIEMPRE tiene un usuario
	@JoinColumn(name = "creado_por", nullable = false) 
	private Usuario usuarioCrea;
	
	@ManyToOne(optional = false)  // un cliente SIEMPRE tiene un usuario
	@JoinColumn(name = "actualizado_por", nullable = false) 
	private Usuario usuarioActualiza;
	
	@Column(name = "fecha_actualizacion", nullable = false)
	private LocalDateTime fechaActualizacion = LocalDateTime.now();
	
	
	public Pedido() {}


	public Pedido(long id, Cliente cliente, LocalDateTime fechaPedido, EstadoPedido estado, float totalSinIva,
			float iva, float totalConIva, Usuario usuarioCrea, Usuario usuarioActualiza,
			LocalDateTime fechaActualizacion) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.fechaPedido = fechaPedido;
		this.estado = estado;
		this.totalSinIva = totalSinIva;
		this.iva = iva;
		this.totalConIva = totalConIva;
		this.usuarioCrea = usuarioCrea;
		this.usuarioActualiza = usuarioActualiza;
		this.fechaActualizacion = fechaActualizacion;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public LocalDateTime getFechaPedido() {
		return fechaPedido;
	}


	public void setFechaPedido(LocalDateTime fechaPedido) {
		this.fechaPedido = fechaPedido;
	}


	public EstadoPedido getEstado() {
		return estado;
	}


	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
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


	public Usuario getUsuarioCrea() {
		return usuarioCrea;
	}


	public void setUsuarioCrea(Usuario usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}


	public Usuario getUsuarioActualiza() {
		return usuarioActualiza;
	}


	public void setUsuarioActualiza(Usuario usuarioActualiza) {
		this.usuarioActualiza = usuarioActualiza;
	}


	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}


	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cliente, estado, fechaActualizacion, fechaPedido, id, iva, totalConIva, totalSinIva,
				usuarioActualiza, usuarioCrea);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(cliente, other.cliente) && estado == other.estado
				&& Objects.equals(fechaActualizacion, other.fechaActualizacion)
				&& Objects.equals(fechaPedido, other.fechaPedido) && id == other.id
				&& Float.floatToIntBits(iva) == Float.floatToIntBits(other.iva)
				&& Float.floatToIntBits(totalConIva) == Float.floatToIntBits(other.totalConIva)
				&& Float.floatToIntBits(totalSinIva) == Float.floatToIntBits(other.totalSinIva)
				&& Objects.equals(usuarioActualiza, other.usuarioActualiza)
				&& Objects.equals(usuarioCrea, other.usuarioCrea);
	}

	
}
