package kodlama.io.DevsTwo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.DevsTwo.business.abstracts.ITechnologyService;
import kodlama.io.DevsTwo.business.requests.CreateTechnologyRequest;
import kodlama.io.DevsTwo.business.requests.DeleteTechnologyRequest;
import kodlama.io.DevsTwo.business.requests.UpdateTechnologyRequest;
import kodlama.io.DevsTwo.business.responses.GetAllTechnologyResponse;
import kodlama.io.DevsTwo.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.DevsTwo.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.DevsTwo.entities.concretes.ProgrammingLanguage;
import kodlama.io.DevsTwo.entities.concretes.Technology;

@Service
public class TechnologyManager implements ITechnologyService {
	
	private TechnologyRepository techRepo;
	private ProgrammingLanguageRepository pLangRepo;

	public TechnologyManager(TechnologyRepository techRepo, ProgrammingLanguageRepository pLangRepo) {
		this.techRepo = techRepo;
		this.pLangRepo = pLangRepo;
	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> technology = techRepo.findAll();
		List<GetAllTechnologyResponse> technoResponse = new ArrayList<GetAllTechnologyResponse>(); 
		
		for(Technology techno : technology) {
			GetAllTechnologyResponse responseItem = new GetAllTechnologyResponse();
			responseItem.setId(techno.getId());
			responseItem.setName(techno.getName());
			responseItem.setProgrammingLanguageName(techno.getProgrammingLanguage().getName());
			technoResponse.add(responseItem);
		}
		
		return technoResponse;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();
		ProgrammingLanguage pLang = pLangRepo.findById(createTechnologyRequest.getProgrammingLangId()).get();
		technology.setName(createTechnologyRequest.getName());
		technology.setProgrammingLanguage(pLang);
		this.techRepo.save(technology);
		
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		this.techRepo.deleteById(deleteTechnologyRequest.getId());
		
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest, int techId) {
		Technology tech = techRepo.findById(techId).get();
		ProgrammingLanguage pLang = pLangRepo.findById(updateTechnologyRequest.getProgrammingLangId()).get();
		tech.setName(updateTechnologyRequest.getName());
		tech.setProgrammingLanguage(pLang);
		this.techRepo.save(tech);
		
		
	}
	
	
	
}
