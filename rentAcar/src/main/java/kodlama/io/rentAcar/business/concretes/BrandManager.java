package kodlama.io.rentAcar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentAcar.business.abstracts.BrandService;
import kodlama.io.rentAcar.business.requests.CreateBrandRequest;
import kodlama.io.rentAcar.business.responses.GetAllBrandResponse;
import kodlama.io.rentAcar.business.rules.BrandBusinessRule;
import kodlama.io.rentAcar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentAcar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentAcar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService{

	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRule brandBusinessRule;
	
	@Autowired
	public BrandManager(BrandRepository brandRepository) {
		super();
		this.brandRepository = brandRepository;
	}

	@Override
	
	public List<GetAllBrandResponse> getAll() {
	
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandResponse> brandResponse = brands.stream()
				.map(brand ->this.modelMapperService.forResponse()
				.map(brand, GetAllBrandResponse.class)).collect(Collectors.toList());
		
		return brandResponse;
		
		
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		brandBusinessRule.checkIfBrandNameExists(createBrandRequest.getName());
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		brandRepository.save(brand);
		
	}
	
}
