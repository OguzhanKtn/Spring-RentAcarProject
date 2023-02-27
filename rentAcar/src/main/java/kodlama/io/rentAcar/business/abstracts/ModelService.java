package kodlama.io.rentAcar.business.abstracts;

import java.util.List;

import kodlama.io.rentAcar.business.requests.CreateModelRequest;
import kodlama.io.rentAcar.business.responses.GetAllModelResponse;

public interface ModelService {
	List<GetAllModelResponse> getAll();
	void add(CreateModelRequest createModelRequest);
}
