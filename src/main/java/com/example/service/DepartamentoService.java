package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.example.dto.DepartamentoDto;
import com.example.entity.Departamento;
import com.example.entity.Empleado;
import com.example.repository.IDepartamentoRepository;

@Service
public class DepartamentoService implements IDepartamentoService {

	@Autowired
	private IDepartamentoRepository departamentoRepository;

	public List<Departamento> findAll() {

		// List<Departamento> departamentos = null;
		// ArrayList<DepartamentoDto> departamentosDto = new ArrayList<>();
		// departamentos = departamentoRepository.findAll();

		// System.out.println(departamentos.toString());

		// for (int i = 0; i < departamentos.size(); i++) {

		// departamentosDto.add(departamentos.get(i));

		// }
		return departamentoRepository.findAll();
	}

	public List<?> totalEmpleadosById(Long id){

		return departamentoRepository.totalEmpleadosByID(id);
	}

	public Departamento findById(Long id) {

		// Departamento departamento = null;
		// DepartamentoDto departamentoDto = new DepartamentoDto();
		// departamento = departamentoRepository.findById(id).orElse(null);
		// System.out.println("departamento>>>> "+departamento.toString());

		// DepartamentoDto departamentoDto = new DepartamentoDto(
		// 	departamento.getIdDepartamento(),
		// 	departamento.getNombre(),
		// 	departamento.getDescripcion(),
		// 	departamento.getDireccion(), 
		// 	departamento.getEmpleados()		
		// );
	
		// departamentoDto.setIdDepartamento(departamento.getIdDepartamento());
		// departamentoDto.setNombre(departamento.getNombre());
		// departamentoDto.setDireccion(departamento.getDireccion());
		// departamentoDto.setEmpleados(null);
		// System.out.println("departamentDto>>>> " + departamentoDto.toString());




		return departamentoRepository.findById(id).orElse(null);

	}

	
	public DepartamentoDto create(DepartamentoDto departamentoDto) {
		
		Departamento departamento = new Departamento();
		departamento.setNombre(departamentoDto.getNombre());
		departamento.setDireccion(departamentoDto.getDireccion());
		
		departamento =  departamentoRepository.save(departamento);
		
		departamentoDto.setIdDepartamento(departamento.getIdDepartamento());
		
		return departamentoDto;
		
	}
	
	
	public DepartamentoDto update(DepartamentoDto departamentoDto) {
		
		Departamento departamento = new Departamento();
		departamento.setIdDepartamento(departamentoDto.getIdDepartamento());
		departamento.setNombre(departamentoDto.getNombre());
		departamento.setDescripcion(departamentoDto.getDescripcion());
		departamento.setDireccion(departamentoDto.getDireccion());
		
		departamento = departamentoRepository.save(departamento);
		
		departamentoDto.setIdDepartamento(departamento.getIdDepartamento());
		
		return departamentoDto;
	}

	
	public void delete(Long  id) {
		departamentoRepository.deleteById(id);
	}
	
	//
	//
	
}
