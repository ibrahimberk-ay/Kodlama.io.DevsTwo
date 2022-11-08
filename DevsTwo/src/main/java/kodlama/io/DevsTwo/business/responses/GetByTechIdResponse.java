package kodlama.io.DevsTwo.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByTechIdResponse {
	private String name;
	private String programmingLanguageName;
}
