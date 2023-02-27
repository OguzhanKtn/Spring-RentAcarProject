package kodlama.io.rentAcar.business.abstracts;

import java.util.List;

import kodlama.io.rentAcar.business.requests.CreateBrandRequest;
import kodlama.io.rentAcar.business.responses.GetAllBrandResponse;

public interface BrandService {
	
	List<GetAllBrandResponse> getAll();
	void add(CreateBrandRequest createBrandRequest);

}
