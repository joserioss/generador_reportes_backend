package cl.jrios.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.jrios.model.Vehicle;
import cl.jrios.repo.IVehicleRepo;
import cl.jrios.service.IVehicleService;

@Service
public class VehicleServiceImpl implements IVehicleService {

	@Autowired
	private IVehicleRepo repo;

	@Override
	public Vehicle registrar(Vehicle obj) {
		return repo.save(obj);
	}

	@Override
	public Vehicle modificar(Vehicle obj) {
		return repo.save(obj);
	}

	@Override
	public List<Vehicle> listar() {
		return repo.findAll();
	}

	@Override
	public Vehicle leerPorId(Integer id) {
		Optional<Vehicle> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Vehicle();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
