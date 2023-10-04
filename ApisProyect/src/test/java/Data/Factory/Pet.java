package Data.Factory;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;

@Getter @Setter
public class Pet {
	private Long id;
	private String name;
	private Category category;
	private ArrayList<Tags> tags;
	private ArrayList<String> photoUrls;
	private String status;

	@Override
	public String toString() {
		return "Pet{" +
				"id=" + id +
				", name='" + name + '\'' +
				", category=" + category +
				", tags=" + tags +
				", photoUrls=" + photoUrls +
				", status='" + status + '\'' +
				'}';
	}
}
