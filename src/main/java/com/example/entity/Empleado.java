package com.example.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.*;

@Entity
@Table (name="empleados")
public class Empleado implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEmpleado;
	private String nombre;
	private String apellido;
	private String curp;
	private String rfc;
	private Integer edad;
	private String telefono;
	private String correo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="IdDepartamento")
	@JsonBackReference
	private Departamento departamento;

	
	
	
	
	public Empleado() {
		super();
	}





	public Empleado(Long idEmpleado, String nombre, String apellido, String curp, String rfc, Integer edad, String telefono,
			String correo, Departamento departamento) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.curp = curp;
		this.rfc = rfc;
		this.edad = edad;
		this.telefono = telefono;
		this.correo = correo;
		this.departamento = departamento;
	}





	public Long getIdEmpleado() {
		return idEmpleado;
	}





	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getApellido() {
		return apellido;
	}





	public void setApellido(String apellido) {
		this.apellido = apellido;
	}





	public String getCurp() {
		return curp;
	}





	public void setCurp(String curp) {
		this.curp = curp;
	}





	public String getRfc() {
		return rfc;
	}





	public void setRfc(String rfc) {
		this.rfc = rfc;
	}





	public Integer getEdad() {
		return edad;
	}





	public void setEdad(Integer edad) {
		this.edad = edad;
	}





	public String getTelefono() {
		return telefono;
	}





	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}





	public String getCorreo() {
		return correo;
	}





	public void setCorreo(String correo) {
		this.correo = correo;
	}





	public Departamento getDepartamento() {
		return departamento;
	}





	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}





	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", curp=" + curp + ", rfc="
				+ rfc + ", edad=" + edad + ", telefono=" + telefono + ", correo=" + correo + ", departamento="
				+ departamento + "]";
	}
	
	
	
	
	
	
}
