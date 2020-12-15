package cl.jrios.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.jrios.model.Archivo;

public interface IArchivoRepo extends JpaRepository<Archivo, Integer>{

}
