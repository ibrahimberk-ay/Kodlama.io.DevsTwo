package kodlama.io.DevsTwo.business.abstracts;

import java.util.List;

import kodlama.io.DevsTwo.business.requests.CreateTechnologyRequest;
import kodlama.io.DevsTwo.business.requests.DeleteTechnologyRequest;
import kodlama.io.DevsTwo.business.requests.UpdateTechnologyRequest;
import kodlama.io.DevsTwo.business.responses.GetAllTechnologyResponse;
import kodlama.io.DevsTwo.business.responses.GetByTechIdResponse;

public interface ITechnologyService {
	List<GetAllTechnologyResponse> getAll();
	GetByTechIdResponse getById(int id);
	
	void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
	void delete(DeleteTechnologyRequest deleteTechnologyRequest);
	void update(UpdateTechnologyRequest updateTechnologyRequest, int techId);
}
