package kodlama.io.DevsTwo.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="programminglanguages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProgrammingLanguage{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "programmingLanguage")
	private List<Technology> technologies;
	
}
