package com.example.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table (name="departamentos")
public class Departamento implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String direccion;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="id", cascade = CascadeType.ALL )
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Empleado> empleados;

	
	
	public Departamento() {
		super();
	}



	public Departamento(Long id, String nombre, String direccion, List<Empleado> empleados) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.empleados = empleados;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public List<Empleado> getEmpleados() {
		return empleados;
	}



	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	
	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", empleados=" + empleados
				+ "]";
	}
	
	
	
	
	
	
}
