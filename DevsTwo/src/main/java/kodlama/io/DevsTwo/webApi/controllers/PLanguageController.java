package kodlama.io.DevsTwo.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.DevsTwo.business.abstracts.IProgrammingLanguageService;
import kodlama.io.DevsTwo.business.requests.CreatePLanguageRequest;
import kodlama.io.DevsTwo.business.requests.DeletePLanguageRequest;
import kodlama.io.DevsTwo.business.requests.UpdatePLanguageRequest;
import kodlama.io.DevsTwo.business.responses.GetAllProgLanguagesResponse;
import kodlama.io.DevsTwo.business.responses.GetByProgLangIdResponse;

@RestController
@RequestMapping("/api/programminglanguages")
public class PLanguageController {
	private IProgrammingLanguageService iLangService;

	@Autowired
	public PLanguageController(IProgrammingLanguageService ilangService) {
		this.iLangService = ilangService;
	}
	
	@GetMapping("/getall")
	public List<GetAllProgLanguagesResponse> getAll(){
		return iLangService.getAll();
	}
	
	@GetMapping("/getbyid")
	public GetByProgLangIdResponse getById(int id) {
		return iLangService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(CreatePLanguageRequest createPLanguageRequest) {
		this.iLangService.add(createPLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeletePLanguageRequest deletePLanguageRequest) {
		this.iLangService.delete(deletePLanguageRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdatePLanguageRequest updatePLanguageRequest, int langId) {
		this.iLangService.update(updatePLanguageRequest, langId);
	}
	
}
