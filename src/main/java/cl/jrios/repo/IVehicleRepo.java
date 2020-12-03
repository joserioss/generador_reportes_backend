package cl.jrios.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.jrios.model.Vehicle;

public interface IVehicleRepo extends JpaRepository<Vehicle, Integer>{

}
