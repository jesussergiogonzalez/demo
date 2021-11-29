package com.example.demo.products;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Producto")
public class Productos {
	
	@Id
	@Column(name="ID")
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	private Long ID;
	@Column(name="Descripcion", nullable=false , length=50)
	private String Descripcion;
	@Column(name="Precio", nullable=false)
	private double Precio;

	
	
	public Long getID() {
		return ID;
	}
	public void setID(Long i) {
		ID = i;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public double getPrecio() {
		return Precio;
	}
	public void setPrecio(double precio) {
		Precio = precio;
	}

}
