package WCCI.proofofconcept;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class EntityMappingTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private AuthorRepository authorRepo;
	
	@Autowired
	private GenreRepository genreRepo;

	@Test
	public void shouldSaveAndLoadPost( ) {
		Post post = new Post("1", new Author("dan"), new Genre("punk"), null, null);
		entityManager.persist(post);
		entityManager.flush();
		Post foundPost = postRepo.findById(post.getId()).get();
		assertThat(foundPost.getTitle(), is("1"));
	}




















}
