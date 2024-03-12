package com.example.dto;

import java.util.List;

import com.example.entity.Empleado;

import jakarta.persistence.*;


public class DepartamentoDto {

	
	private Long idDepartamento;
	private String nombre;
	private String direccion;
	private List<Empleado> empleados;

	
	
	public DepartamentoDto() {
		super();
	}



	public DepartamentoDto(Long idDepartamento, String nombre, String direccion, List<Empleado> empleados) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
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
		return "DepartamentoDto [idDepartamento=" + idDepartamento + ", nombre=" + nombre + ", direccion=" + direccion + ", empleados="
				+ empleados + "]";
	}
	
	
	
	
	
	
	
	
}
