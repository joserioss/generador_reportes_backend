package cl.jrios.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.jrios.model.Repairman;

public interface IRepairmanRepo extends JpaRepository<Repairman, Integer>{

}
