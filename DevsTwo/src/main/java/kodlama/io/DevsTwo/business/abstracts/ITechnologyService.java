package kodlama.io.DevsTwo.business.abstracts;

import java.util.List;

import kodlama.io.DevsTwo.business.requests.CreateTechnologyRequest;
import kodlama.io.DevsTwo.business.requests.DeleteTechnologyRequest;
import kodlama.io.DevsTwo.business.responses.GetAllTechnologyResponse;

public interface ITechnologyService {
	List<GetAllTechnologyResponse> getAll();
	
	void add(CreateTechnologyRequest createTechnologyRequest);
	void delete(DeleteTechnologyRequest deleteTechnologyRequest);
	void update(CreateTechnologyRequest createTechnologyRequest);
}
