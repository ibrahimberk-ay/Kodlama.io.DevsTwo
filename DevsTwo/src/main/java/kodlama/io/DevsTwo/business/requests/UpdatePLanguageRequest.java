package kodlama.io.DevsTwo.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePLanguageRequest {
	private int id;
	private String name;
}
