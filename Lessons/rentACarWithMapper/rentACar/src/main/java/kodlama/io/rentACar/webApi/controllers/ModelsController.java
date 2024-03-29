package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.model.CreateModelRequest;
import kodlama.io.rentACar.business.requests.model.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.model.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.model.GetByIdModelResponse;
import lombok.AllArgsConstructor;


@RestController 
@RequestMapping("/api/models")
@AllArgsConstructor  // constructor injection
public class ModelsController {
	private ModelService modelService;
	
	
	
	@GetMapping()
	public List<GetAllModelsResponse> getAll(){
		return modelService.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() @Valid CreateModelRequest createModelRequest) {
		this.modelService.add(createModelRequest);
	}
	
	@GetMapping("/{id}")
	public GetByIdModelResponse getById(@PathVariable int id) {
		return this.modelService.getById(id);
	}
	
	@PutMapping
	public void update(@RequestBody() UpdateModelRequest updateModelRequest) {
		this.modelService.update(updateModelRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable() int id) {
		this.modelService.delete(id);
	}
	
	
	
}
