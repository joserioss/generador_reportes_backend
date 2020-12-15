package cl.jrios.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import cl.jrios.model.Workdone;
import cl.jrios.repo.IWorkdoneRepo;
import cl.jrios.service.IWorkdoneService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class WorkdoneServiceImpl implements IWorkdoneService {

	@Autowired
	private IWorkdoneRepo repo;

	@Override
	public Workdone registrar(Workdone obj) {
		obj.getDetailWorkdone().forEach(detail -> {
			detail.setWorkdone(obj);
		});
		return repo.save(obj);
	}

	@Override
	public Workdone modificar(Workdone obj) {
		return repo.save(obj);
	}

	@Override
	public List<Workdone> listar() {
		return repo.findAll();
	}

	@Override
	public Workdone leerPorId(Integer id) {
		Optional<Workdone> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Workdone();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public byte[] generarReporte(Integer id) {
		byte[] data = null;
		Workdone veh = this.leerPorId(id);
		List<Workdone> workdone = new ArrayList<>();
		workdone.add(veh);
//		Lista necesaria para poder ingresar valores del workdone a pdf de jasperreports.
		JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(workdone);

		try {
			File file = new ClassPathResource("/reports/DercoMAQ.jasper").getFile();
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, datasource);
			data = JasperExportManager.exportReportToPdf(print);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

}
