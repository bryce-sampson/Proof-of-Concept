package WCCI.proofofconcept;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PostMapTest {

	PostMap underTest = new PostMap();

	@Test
	public void shoudBeAbleToAddPostToMap() {
		underTest.addPostToMap(new Post("a post", null, null, null, null));
		String expectedTitle = underTest.getTitle("a post");
		assertEquals("a post", expectedTitle);
	}

	@Test
	public void shouldBeAbleToGetAllTheDeatils() {
		Author underTest1 = new Author("Dan");
		underTest.addPostToMap(new Post("a post", new Author("Dan"), null, "Jan,01,1999", "good song"));

	}

}
