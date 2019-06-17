package WCCI.proofofconcept;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;


public class AuthorTest {
	@Test
	public void shouldHaveName() {
		Author underTest = new Author("");
		String author =	underTest.getName();
		assertThat(author, is(""));
	}
	@Test
	public void shouldHaveNameHamlet() {
		Author underTest = new Author("Hamlet");
		String author =	underTest.getName();
		assertThat(author, is("Hamlet"));
	}
}
