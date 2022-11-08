package kodlama.io.DevsTwo.business.abstracts;

import java.util.List;

import kodlama.io.DevsTwo.business.requests.CreatePLanguageRequest;
import kodlama.io.DevsTwo.business.requests.DeletePLanguageRequest;
import kodlama.io.DevsTwo.business.requests.UpdatePLanguageRequest;
import kodlama.io.DevsTwo.business.responses.GetAllProgLanguagesResponse;

public interface IProgrammingLanguageService {
	List<GetAllProgLanguagesResponse> getAll();
	
	void add(CreatePLanguageRequest createPLanguageRequest);
	void delete(DeletePLanguageRequest deletePLanguageRequest);
	void update(UpdatePLanguageRequest updatePLanguageRequest);
	
}
