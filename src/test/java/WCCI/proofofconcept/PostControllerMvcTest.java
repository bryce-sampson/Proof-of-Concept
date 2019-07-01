package WCCI.proofofconcept;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest

public class PostControllerMvcTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PostRepository postRepo;

	@MockBean
	private AuthorRepository authorRepo;

	@MockBean
	private GenreRepository genreRepo;

	@MockBean
	private PostTagRepository postTagRepo;

	@Mock
	private Post postOne;

	@Mock
	private Post postTwo;

	@Mock
	private Author author;

	@Mock
	private Genre genre;

	@Mock
	private PostTag postTag;

	@Test
	public void shouldReturnStatusOfOk() throws Exception {
		Collection<Post> posts = Arrays.asList(postOne, postTwo);
		when(postRepo.findAll()).thenReturn(posts);
		mvc.perform(get("/author")).andExpect(view().name(is("authorsView")));
	}

	@Test
	public void addAuthorTest() throws Exception {
		mvc.perform(post("/author/add/")).andExpect(status().is3xxRedirection());

	}

	@Test
	public void addGenreTest() throws Exception {
		Genre genreToAdd = new Genre("punk");
		mvc.perform(post("/genre/add/" + genreToAdd.getName())).andExpect(status().is3xxRedirection());

	}

}
