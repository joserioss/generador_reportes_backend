package cl.jrios.service;

import cl.jrios.model.Archivo;

public interface IArchivoService{
	int guardar(Archivo archivo);
	byte[] leerArchivo(Integer idArchivo);
}
