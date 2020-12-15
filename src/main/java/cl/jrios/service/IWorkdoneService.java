package cl.jrios.service;

import cl.jrios.model.Workdone;

public interface IWorkdoneService extends ICRUD<Workdone>{

	byte[] generarReporte(Integer id);

}
