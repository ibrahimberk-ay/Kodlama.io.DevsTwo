package kodlama.io.DevsTwo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.DevsTwo.business.abstracts.ITechnologyService;
import kodlama.io.DevsTwo.business.requests.CreateTechnologyRequest;
import kodlama.io.DevsTwo.business.requests.DeleteTechnologyRequest;
import kodlama.io.DevsTwo.business.requests.UpdateTechnologyRequest;
import kodlama.io.DevsTwo.business.responses.GetAllTechnologyResponse;
import kodlama.io.DevsTwo.business.responses.GetByTechIdResponse;
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
	public GetByTechIdResponse getById(int id) {
		Technology tech = techRepo.findById(id).get();
		GetByTechIdResponse responseItem = new GetByTechIdResponse();
		responseItem.setName(tech.getName());
		responseItem.setProgrammingLanguageName(tech.getProgrammingLanguage().getName());
		return responseItem;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception{
		Technology technology = new Technology();
		ProgrammingLanguage pLang = pLangRepo.findById(createTechnologyRequest.getProgrammingLangId()).get();
		
		List<Technology> technologies = techRepo.findAll();
		for(Technology tech : technologies) {
			if(tech.getName().matches(createTechnologyRequest.getName()) 
					&& 
					tech.getProgrammingLanguage().equals(pLangRepo.findById(createTechnologyRequest.getProgrammingLangId()).get())) 
			{
				throw new Exception("This Technology and Its Programming Language Already Exists");
			}
			if(createTechnologyRequest.getName().isBlank()) {
				throw new Exception("Technology Name Can Not Be Empty");
			}
		}
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
