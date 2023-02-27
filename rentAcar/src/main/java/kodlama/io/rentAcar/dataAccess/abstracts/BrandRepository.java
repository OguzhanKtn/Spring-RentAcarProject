package kodlama.io.rentAcar.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentAcar.entities.concretes.Brand;


public interface BrandRepository extends JpaRepository<Brand,Integer>{

	boolean existsByName(String name); // spring jpa keywords

}
