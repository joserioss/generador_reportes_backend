package cl.jrios.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cl.jrios.exception.ModelNotFoundException;
import cl.jrios.model.Vehicle;
import cl.jrios.service.IVehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	@Autowired
	private IVehicleService service;
	
	@GetMapping
	public ResponseEntity<List<Vehicle>> listar(){
		List<Vehicle> lista = service.listar();
		return new ResponseEntity<List<Vehicle>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("{/id}")
	public ResponseEntity<Vehicle> listarPorId(@PathVariable("id") Integer id){
		Vehicle obj = service.leerPorId(id);
		if(obj.getId() == null) {
			throw new ModelNotFoundException("ID no encontrado" + id);
		}
		return new ResponseEntity<Vehicle>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Vehicle vehicle){
		service.registrar(vehicle);
		URI location =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vehicle.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Vehicle> modificar(@Valid @RequestBody Vehicle vehicle){
		Vehicle obj = service.modificar(vehicle);
		return new ResponseEntity<Vehicle>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Vehicle obj = service.leerPorId(id);
		if(obj.getId() == null) {
			throw new ModelNotFoundException("ID no encontrado" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
