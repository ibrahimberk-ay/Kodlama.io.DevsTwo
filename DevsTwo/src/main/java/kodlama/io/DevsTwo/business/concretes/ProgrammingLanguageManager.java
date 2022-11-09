package kodlama.io.DevsTwo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.DevsTwo.business.abstracts.IProgrammingLanguageService;
import kodlama.io.DevsTwo.business.requests.CreatePLanguageRequest;
import kodlama.io.DevsTwo.business.requests.DeletePLanguageRequest;
import kodlama.io.DevsTwo.business.requests.UpdatePLanguageRequest;
import kodlama.io.DevsTwo.business.responses.GetAllProgLanguagesResponse;
import kodlama.io.DevsTwo.business.responses.GetByProgLangIdResponse;
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
	public GetByProgLangIdResponse getById(int id) {
		ProgrammingLanguage pLang = programmingLanguageRepository.findById(id).get();
		GetByProgLangIdResponse responseItem = new GetByProgLangIdResponse();
		responseItem.setName(pLang.getName());
		return responseItem;
	}
	
	@Override
	public void add(CreatePLanguageRequest createPLanguageRequest) throws Exception {
		ProgrammingLanguage pLang = new ProgrammingLanguage();
		
		List<ProgrammingLanguage> pLangs = programmingLanguageRepository.findAll();
		for(ProgrammingLanguage language : pLangs) {
			if(language.getName().matches(createPLanguageRequest.getName())) {
				throw new Exception("This Programming Language Already Exist");
			}
			if(createPLanguageRequest.getName().isBlank()) {
				throw new Exception("Programming Language Name Can Not Be Empty");
			}
		}
		
		pLang.setName(createPLanguageRequest.getName());
		this.programmingLanguageRepository.save(pLang);
		
	}

	@Override
	public void delete(DeletePLanguageRequest deletePLanguageRequest) {
		this.programmingLanguageRepository.deleteById(deletePLanguageRequest.getId());
	}

	@Override
	public void update(UpdatePLanguageRequest updatePLanguageRequest, int langId) {
		ProgrammingLanguage pLang = programmingLanguageRepository.getReferenceById(langId);
		pLang.setName(updatePLanguageRequest.getName());
		this.programmingLanguageRepository.save(pLang);
		
		
	}

}
