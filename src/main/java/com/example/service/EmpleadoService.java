package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.example.dto.EmpleadoDto;
import com.example.entity.Empleado;
import com.example.repository.IEmpleadoRepository;

@Service
public class EmpleadoService implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepository empleadoRepository;

	public List<Empleado> findAll() {

		List<Empleado> empleados = null;
		ArrayList<EmpleadoDto> empleadosDto = new ArrayList<>();
		empleados = empleadoRepository.findAll();

		System.out.println(empleados.toString());

		for (int i = 0; i < empleados.size(); i++) {

		// empleadosDto.add(empleados.get(i));

		}
		return empleados;
	}

	public EmpleadoDto findById(Long id) {

		Empleado empleado = null;
		EmpleadoDto empleadoDto = new EmpleadoDto();
		empleado = empleadoRepository.findById(id).get();
		System.out.println(empleado.toString());

		empleadoDto.setIdEmpleado(empleado.getIdEmpleado());
		empleadoDto.setNombre(empleado.getNombre());
		empleadoDto.setApellido(empleado.getApellido());
		System.out.println(empleadoDto.toString());

		return empleadoDto;

	}

	
	public EmpleadoDto create(EmpleadoDto empleadoDto) {
		
		Empleado empleado = new Empleado();
		empleado.setNombre(empleadoDto.getNombre());
		
		empleado =  empleadoRepository.save(empleado);
		
		empleadoDto.setIdEmpleado(empleado.getIdEmpleado());
		
		return empleadoDto;
		
	}
	
	
	public EmpleadoDto update(EmpleadoDto empleadoDto) {
		
		Empleado empleado = new Empleado();
		empleado.setNombre(empleadoDto.getNombre());
		
		empleado = empleadoRepository.save(empleado);
		
		empleadoDto.setIdEmpleado(empleado.getIdEmpleado());
		
		return empleadoDto;
	}

	
	public void delete(Long  id) {
		empleadoRepository.deleteById(id);
	}
	
	//
	//
	
}
