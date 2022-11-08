package kodlama.io.DevsTwo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.DevsTwo.business.abstracts.IProgrammingLanguageService;
import kodlama.io.DevsTwo.business.requests.CreatePLanguageRequest;
import kodlama.io.DevsTwo.business.requests.DeletePLanguageRequest;
import kodlama.io.DevsTwo.business.requests.UpdatePLanguageRequest;
import kodlama.io.DevsTwo.business.responses.GetAllProgLanguagesResponse;
import kodlama.io.DevsTwo.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.DevsTwo.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements IProgrammingLanguageService {
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	public ProgrammingLanguageManager(ProgrammingLanguageRepository pLanguageRepo) {
		this.programmingLanguageRepository = pLanguageRepo;
	}
	
	@Override
	public List<GetAllProgLanguagesResponse> getAll() {
		List<ProgrammingLanguage> pLangs = programmingLanguageRepository.findAll();
		List<GetAllProgLanguagesResponse> langsResponse = new ArrayList<GetAllProgLanguagesResponse>();
		
		for(ProgrammingLanguage pLang : pLangs) {
			GetAllProgLanguagesResponse responseItem = new GetAllProgLanguagesResponse();
			responseItem.setId(pLang.getId());
			responseItem.setName(pLang.getName());
			langsResponse.add(responseItem);
		}
		
		return langsResponse;
	}

	@Override
	public void add(CreatePLanguageRequest createPLanguageRequest) {
		ProgrammingLanguage pLang = new ProgrammingLanguage();
		pLang.setName(createPLanguageRequest.getName());
		this.programmingLanguageRepository.save(pLang);
		
	}

	@Override
	public void delete(DeletePLanguageRequest deletePLanguageRequest) {
		this.programmingLanguageRepository.deleteById(deletePLanguageRequest.getId());
	}

	@Override
	public void update(UpdatePLanguageRequest updatePLanguageRequest) {
		// TODO
		
		
	}

}
