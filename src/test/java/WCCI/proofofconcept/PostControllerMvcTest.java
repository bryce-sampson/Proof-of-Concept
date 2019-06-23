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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)

public class PostControllerMvcTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PostRepository postRepo;

	@Mock
	private Post postOne;

	@Mock
	private Post postTwo;

	@Test
	public void shouldReturnStatusOfOk() throws Exception {
		Collection<Post> posts = Arrays.asList(postOne, postTwo);
		when(postRepo.findAll()).thenReturn(posts);
		mvc.perform(get("/author")).andExpect(view().name(is("singleAuthorView")));
	}

	
	// can not figure out why this does not work new post or author??
	@Test
	public void addAuthorTest() throws Exception {
		Author authorToAdd = new Author("dan");
		mvc.perform(post("/add").contentType(MediaType.APPLICATION_JSON).content(toJson(authorToAdd)))
				.andExpect(status().is3xxRedirection());

	}

	private String toJson(Author newAuthor) {
		return newAuthor.getName();
	}

}
