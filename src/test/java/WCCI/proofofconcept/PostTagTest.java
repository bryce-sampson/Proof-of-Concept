package WCCI.proofofconcept;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class PostTagTest {

	@Test
	public void postTagShouldHaveName() {
		PostTag underTest = new PostTag("");
		String postTag = underTest.getName();
		assertThat(postTag, is(""));
	}
	@Test 
	public void postTagShouldHaveNameGuitar() {
		PostTag underTest = new PostTag("guitar");
		String postTag = underTest.getName();
		assertThat(postTag, is("guitar"));
	}
}
