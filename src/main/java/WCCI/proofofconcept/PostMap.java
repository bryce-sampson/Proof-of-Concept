package WCCI.proofofconcept;

import java.util.HashMap;
import java.util.Map;

public class PostMap {
	
	Map<String, Post> posts = new HashMap<>();

	public void addPostToMap(Post post) {
		posts.put(post.getTitle(), post);
		
	}

	public String getTitle(String title) {
		return posts.get(title).getTitle();
	}
	
}
