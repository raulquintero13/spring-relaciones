package com.example.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamentos")
public class Departamento3 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDepartamento;
	private String nombre;
	private String descripcion;
	private String direccion;

	@OneToMany(cascade = 
			  CascadeType.ALL, fetch = 
			  FetchType.EAGER, 
			  orphanRemoval = true 
			  ,mappedBy = "departamento")
			  @JsonBackReference
			 private Set<Empleado> empleados;
	
	
	public Departamento3() {
		super();
	}

	public Departamento3(long idDepartamento, String nombre, String descripcion, String direccion) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.direccion = direccion;
	}

	public long getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(long idDepartamento) {
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

	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}

	@Override
	public String toString() {
		return "Departamento [idDepartamento=" + idDepartamento + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", direccion=" + direccion + ", empleados=" + empleados + "]";
	}

	
		
}
