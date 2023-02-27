package kodlama.io.rentAcar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentAcar.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model,Integer>{

}
