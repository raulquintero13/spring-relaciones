package com.example.service;

import java.util.List;

import com.example.dto.EmpleadoDto;
import com.example.entity.Empleado;



public interface IEmpleadoService {

	public List<Empleado>  findAll();
	public EmpleadoDto findById(Long id);
	public EmpleadoDto create(EmpleadoDto EmpleadoDto);
	public EmpleadoDto update(EmpleadoDto EmpleadoDto);
	public void delete(Long id);

	
	
}
