package cl.jrios.service;

import cl.jrios.model.Vehicle;

public interface IVehicleService extends ICRUD<Vehicle>{
	
	byte[] generarReporte(Integer id);

}
