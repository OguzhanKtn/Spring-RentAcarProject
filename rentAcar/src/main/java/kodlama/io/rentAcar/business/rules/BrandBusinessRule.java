package kodlama.io.rentAcar.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentAcar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentAcar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandBusinessRule {
	private BrandRepository brandRepository;
	
	public void checkIfBrandNameExists(String name) {
		if(this.brandRepository.existsByName(name)) {
			throw new BusinessException("Brand already exists");
		}
		
	}

}
