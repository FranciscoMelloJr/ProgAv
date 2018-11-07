package model.aluno;

import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
	
	private Long id;
	private StringProperty nome;
	private Integer idade;
	
	private Long cidade;
	
	private Long curso;
	
}
