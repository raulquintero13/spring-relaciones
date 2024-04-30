package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dto.EmpleadoDto;
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
			response = "Error al obtener informacion en base de datos";
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return  new ResponseEntity<List<Empleado>>(empleadosDto, HttpStatus.OK);
		
	}
	
	@GetMapping("empleados/{id}")
	public ResponseEntity<?> consultaPorId(@PathVariable Long id){
		
		EmpleadoDto empleado = null;
		String response = "";
		
		try { 
			 empleado = empleadoService.findById(id);
			
		}catch(DataAccessException e) {
			response = "Error al realizar la consulta.";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		
		return new ResponseEntity<EmpleadoDto>(empleado, HttpStatus.OK);
	}
	
	
	@PostMapping("/empleados")
	// @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> create(@RequestBody EmpleadoDto empleadoDto){
		
		System.out.println(">>> empleadoDto: " + empleadoDto.toString());
		Map<String, Object> response = new HashMap<>();
		try {
			empleadoDto = this.empleadoService.create(empleadoDto);
			
		}catch(DataAccessException e) {
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
			response.put("mensaje", "Error al tratar de actualizar el registo " + empleadoDto.getIdEmpleado());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "Registro Grabado con exito, con el ID "+ empleadoDto.getIdEmpleado() +" "  );
		response.put("brand", empleadoDto);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}

	
	@PutMapping("/empleados")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> update(@RequestBody EmpleadoDto empleadoDto){
		
		Map<String, Object> response = new HashMap<>();
		try {
			empleadoDto = this.empleadoService.update(empleadoDto);
			
		}catch(DataAccessException e) {
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
			response.put("mensaje", "Error al tratar de actualizar el registo " + empleadoDto.getIdEmpleado());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "Registro Grabado con exito, con el ID "+ empleadoDto.getIdEmpleado() +" "  );
		response.put("brand", empleadoDto);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}


	@DeleteMapping("/empleados/{id}")
	public ResponseEntity<?> borraPorId(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try {
			
			empleadoService.delete(id);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar en base de datos");
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		response.put("mensaje", "Registro eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}

	
}
