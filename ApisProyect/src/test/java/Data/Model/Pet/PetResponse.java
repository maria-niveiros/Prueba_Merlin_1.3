package Data.Model.Pet;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PetResponse {

	private Long id;
	private String name;
	private Integer quantity;

	public PetResponse(Long id, String name) {
		this.id=id;
		this.name=name;
	}

	public PetResponse(String name, Integer quantity){
		this.name=name;
		this.quantity=quantity;
	}

	@Override
	public String toString() {
		return " {" +
				"id=" + id +
				", name='" + name + '\'' +
				'}'+'\n';
	}


	public String asString() {
		return "PetResponse{" +
				"name='" + name + '\'' +
				", quantity=" + quantity +
				'}';
	}
}
