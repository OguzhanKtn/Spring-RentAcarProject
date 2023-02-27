package kodlama.io.rentAcar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentAcar.business.abstracts.ModelService;
import kodlama.io.rentAcar.business.requests.CreateModelRequest;
import kodlama.io.rentAcar.business.responses.GetAllModelResponse;
import kodlama.io.rentAcar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentAcar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentAcar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService{

	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllModelResponse> getAll() {
		List<Model> models = modelRepository.findAll();
		List<GetAllModelResponse> modelResponse = models.stream()
				.map(model ->this.modelMapperService.forResponse()
				.map(model, GetAllModelResponse.class)).collect(Collectors.toList());
		
		return modelResponse;
	}
	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		modelRepository.save(model);
		
	}

}
