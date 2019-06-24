package WCCI.proofofconcept;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
	@Resource
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	String endpoint;

	private void assertThatEndPointIsOk(String endpoint) {
		ResponseEntity<String> response = restTemplate.getForEntity(endpoint, String.class);
		HttpStatus status = response.getStatusCode();
		status.is2xxSuccessful();
//		assertThat(status, is(HttpStatus.OK));
	}

	@Test
	public void authorEndPointIsOk() {
		assertThatEndPointIsOk("/author");
	}

	@Test
	public void postEndPointIsOk() {
		assertThatEndPointIsOk("/post/");
	}

	@Test
	public void addAuthorEndPointIsRediect() {
		ResponseEntity<String> response = restTemplate.getForEntity("/author/add/", String.class);
		HttpStatus status = response.getStatusCode();
		status.is3xxRedirection();
	}

}
