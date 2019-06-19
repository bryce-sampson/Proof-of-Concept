package WCCI.proofofconcept;

import java.util.HashMap;
import java.util.Map;

public class AuthorMap {
	
	Map<String, Author> authors = new HashMap<>();

	public void addAuthorToMap(Author author) {
		authors.put(author.getName(), author);
		
	}

	public String getName(String name) {
		return authors.get(name).getName();
	}

	public int getAuthorMapSize() {
		return authors.size();
	}

}
