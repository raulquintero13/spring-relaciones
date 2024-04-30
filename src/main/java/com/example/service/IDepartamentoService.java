package com.example.service;

import java.util.List;

import com.example.dto.DepartamentoDto;
import com.example.entity.Departamento;

public interface IDepartamentoService {

	public List<Departamento>  findAll();
	public Departamento findById(Long id);
	public DepartamentoDto create(DepartamentoDto departamentoDto);
	public DepartamentoDto update(DepartamentoDto departamentoDto);
	public void delete(Long id);

	
	
}
