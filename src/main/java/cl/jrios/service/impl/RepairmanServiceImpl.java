package cl.jrios.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.jrios.model.Repairman;
import cl.jrios.repo.IRepairmanRepo;
import cl.jrios.service.IRepairmanService;

@Service
public class RepairmanServiceImpl implements IRepairmanService {

	@Autowired
	private IRepairmanRepo repo;

	@Override
	public Repairman registrar(Repairman obj) {
		return repo.save(obj);
	}

	@Override
	public Repairman modificar(Repairman obj) {
		return repo.save(obj);
	}

	@Override
	public List<Repairman> listar() {
		return repo.findAll();
	}

	@Override
	public Repairman leerPorId(Integer id) {
		Optional<Repairman> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Repairman();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
