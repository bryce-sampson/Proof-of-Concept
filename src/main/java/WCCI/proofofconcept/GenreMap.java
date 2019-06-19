package WCCI.proofofconcept;

import java.util.HashMap;
import java.util.Map;

public class GenreMap {
	
	Map<String, Genre> genres = new HashMap<>();

	public void addGenreToMap(Genre genre) {
		genres.put(genre.getGenName(), genre);
		
	}

	public String getGenName(String name) {
		return genres.get(name).getGenName();
	}
	
}
