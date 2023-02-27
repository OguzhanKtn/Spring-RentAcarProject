package kodlama.io.rentAcar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kodlama.io.rentAcar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentAcar.core.utilities.exceptions.ProblemDetails;

@SpringBootApplication
@RestControllerAdvice
public class RentAcarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentAcarApplication.class, args);
	}
	
	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		
		return problemDetails;
	}
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}