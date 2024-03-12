package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Empleado;
import com.example.service.EmpleadoService;



@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmpleadoController {

    @Autowired
	private EmpleadoService empleadoService;

    @GetMapping("/empleados")
	public  ResponseEntity<?> consulta(){
		
		List<Empleado> empleadosDto = null;
		String response;

		try {
			
			empleadosDto = this.empleadoService.findAll();
			System.out.println(empleadosDto.toString());
			
		}catch(DataAccessException e) {
			System.out.println("Mensaje de Error en el Catch");
			response = "Error al eliminar en base de datos";
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return  new ResponseEntity<List<Empleado>>(empleadosDto, HttpStatus.OK);
		
	}
	


}
