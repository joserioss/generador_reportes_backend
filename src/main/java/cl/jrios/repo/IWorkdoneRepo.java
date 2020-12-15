package cl.jrios.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.jrios.model.Workdone;

public interface IWorkdoneRepo extends JpaRepository<Workdone, Integer>{

}
