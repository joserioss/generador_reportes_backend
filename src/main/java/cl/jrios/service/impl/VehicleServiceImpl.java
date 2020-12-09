package cl.jrios.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import cl.jrios.model.Vehicle;
import cl.jrios.repo.IVehicleRepo;
import cl.jrios.service.IVehicleService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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

	@Override
	public byte[] generarReporte(Integer id) {
		byte[] data = null;
		Vehicle veh = this.leerPorId(id);
		List<Vehicle> vehicle = new ArrayList<>();
		vehicle.add(veh);
//		Lista necesaria para poder ingresar valores del vehicle a pdf de jasperreports.
		JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(vehicle);

		try {
			File file = new ClassPathResource("/reports/ReporteVehicle.jasper").getFile();
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, datasource);
			data = JasperExportManager.exportReportToPdf(print);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

}
