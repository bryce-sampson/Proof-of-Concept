package WCCI.proofofconcept;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class PostTest {
	@Test
	public void shouldHaveTitles()  {
		Post underTest = new Post();
		String givenTitle = underTest.getTitle();
		assertThat(givenTitle, is(""));
	}
	
	
	

}

