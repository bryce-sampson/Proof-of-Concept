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
	public void shouldSaveAndLoadPost() {
		Author author = new Author("dan");
		Genre punk = new Genre("punk");
		Post post = new Post("1", author, punk, null, null);
		entityManager.persist(author);
		entityManager.persist(punk);
		entityManager.persist(post);
		entityManager.flush();
		Post foundPost = postRepo.findById(post.getId()).get();
		assertThat(foundPost.getTitle(), is("1"));
	}

	@Test
	public void shouldSaveAndLoadAuthor() {
		Author author = new Author("dan");
		entityManager.persist(author);
		entityManager.flush();
		Author foundAuthor = authorRepo.findById(author.getId()).get();
		assertThat(foundAuthor.getName(), is("dan"));
	}

	@Test
	public void shouldSaveAndLoadGenre() {
		Genre genre = new Genre("punk");
		entityManager.persist(genre);
		entityManager.flush();
		Genre foundGenre = genreRepo.findById(genre.getId()).get();
		assertThat(foundGenre.getName(), is("punk"));
	}

	@Test
	public void addPostToAuthorAndGetPostCollectionSize() {
		Author dan = new Author("dan");
		entityManager.persist(dan);
		entityManager.flush();
		dan.addPost(new Post());
		assertThat(dan.getPosts().size(), is(1));
	}

	@Test
	public void addPostToGenreAndGetCollectionSize() {
		Genre punk = new Genre("punk");
		entityManager.persist(punk);
		entityManager.flush();
		punk.addPost(new Post());
		assertThat(punk.getPosts().size(), is(1));

	}

	@Test
	public void addPostTagsToPostAndGetCollectionSize() {
		PostTag stick = new PostTag("stick");
		entityManager.persist(stick);
		entityManager.flush();
		stick.addPost(new Post());
		assertThat(stick.getPosts().size(), is(1));

	}

	@Test
	public void addPostTagsTwiceToPostAndGetCollectionSize() {
		PostTag stick = new PostTag("stick");
		entityManager.persist(stick);
		entityManager.flush();
		stick.addPost(new Post());
		stick.addPost(new Post());
		assertThat(stick.getPosts().size(), is(2));

	}

}
