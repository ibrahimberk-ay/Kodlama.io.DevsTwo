package kodlama.io.DevsTwo.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTechnologyRequest {
	private String name;
	private int programmingLangId;
}
