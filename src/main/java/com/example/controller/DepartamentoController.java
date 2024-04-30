package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dto.DepartamentoDto;
import com.example.entity.Departamento;
import com.example.service.DepartamentoService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping("/departamentos")
	public  ResponseEntity<?> consulta(){
		
		List<Departamento> departamentosDto = null;
		String response;

		try {
			
			departamentosDto = this.departamentoService.findAll();
			System.out.println(departamentosDto.toString());
			
		}catch(DataAccessException e) {
			System.out.println("Mensaje de Error en el Catch");
			// response = "Error al leer en base de datos";
			response = e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString());

			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return  new ResponseEntity<List<Departamento>>(departamentosDto, HttpStatus.OK);
		
	}
	
	@GetMapping("departamentos/{id}")
	public ResponseEntity<?> consultaPorId(@PathVariable Long id){
		
		Departamento departamento = null;
		String response = "";
		
		try { 
			 departamento = departamentoService.findById(id);
			
		}catch(DataAccessException e) {
			response = "Error al realizar la consulta.";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		
		return new ResponseEntity<Departamento>(departamento, HttpStatus.OK);
	}
	
	@GetMapping("departamentos/{id}/total-empleados")
	public ResponseEntity<?> totalEmpleadosById(@PathVariable Long id){
		
		List<?> departamentosDto = null;
		String response = "";
		
		try { 
			 departamentosDto = departamentoService.totalEmpleadosById(id);
			
		}catch(DataAccessException e) {
			response = "Error al realizar la consulta.";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		
		return new ResponseEntity<List<?>>(departamentosDto, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/departamentos")
	// @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> create(@RequestBody DepartamentoDto departamentoDto){
		
		System.out.println("departamentoDto: " + departamentoDto.toString());
		Map<String, Object> response = new HashMap<>();
		try {
			departamentoDto = this.departamentoService.create(departamentoDto);
			
		}catch(DataAccessException e) {
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
			response.put("mensaje", "Error al tratar de actualizar el registo " + departamentoDto.getIdDepartamento());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "Registro Grabado con exito, con el ID "+ departamentoDto.getIdDepartamento() +" "  );
		response.put("brand", departamentoDto);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	@PutMapping("/departamentos")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> update(@RequestBody DepartamentoDto departamentoDto){
		
		Map<String, Object> response = new HashMap<>();
		try {
			departamentoDto = this.departamentoService.update(departamentoDto);
			
		}catch(DataAccessException e) {
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
			response.put("mensaje", "Error al tratar de actualizar el registo " + departamentoDto.getIdDepartamento());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "Registro Grabado con exito, con el ID "+ departamentoDto.getIdDepartamento() +" "  );
		response.put("brand", departamentoDto);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/departamentos/{id}")
	public ResponseEntity<?> borraPorId(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try {
			
			departamentoService.delete(id);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar en base de datos");
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		response.put("mensaje", "Registro eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	
}
