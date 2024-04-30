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
public class Departamento {


	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDepartamento;
	private String nombre;
	private String descripcion;
	private String direccion;
	
	
	@OneToMany(mappedBy ="departamento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	// @JsonManagedReference
	private List<Empleado> empleados;

	
	
	public Departamento() {
		super();
	}



	public Departamento(Long idDepartamento, String nombre, String descripcion, String direccion, List<Empleado> empleados) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.empleados = empleados;
	}



	public Long getIdDepartamento() {
		return idDepartamento;
	}



	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
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
		return "Departamento [idDepartamento=" + idDepartamento + ", nombre=" + nombre + ", direccion=" + direccion + ", empleados=" + empleados
				+ "]";
	}
	
	
	
	
	
	
}
