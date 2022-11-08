package kodlama.io.DevsTwo.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.DevsTwo.business.abstracts.ITechnologyService;
import kodlama.io.DevsTwo.business.requests.CreateTechnologyRequest;
import kodlama.io.DevsTwo.business.requests.DeleteTechnologyRequest;
import kodlama.io.DevsTwo.business.responses.GetAllTechnologyResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
	private ITechnologyService iTechnoService;

	@Autowired
	public TechnologyController(ITechnologyService iTechnoService) {
		this.iTechnoService = iTechnoService;
	}
	
	@GetMapping("/getall")
	public List<GetAllTechnologyResponse> getAll(){
		return iTechnoService.getAll();
	}
	
	@PostMapping("/add")
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		this.iTechnoService.add(createTechnologyRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		this.iTechnoService.delete(deleteTechnologyRequest);
	}
	

}
