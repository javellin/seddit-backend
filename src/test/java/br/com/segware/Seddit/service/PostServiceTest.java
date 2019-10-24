package br.com.segware.Seddit.service;

import br.com.segware.Seddit.domain.Post;
import br.com.segware.Seddit.repository.PostRepository;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class PostServiceTest {

  @Autowired
  private PostService postService;

  @MockBean
  private PostRepository postRepository;

  @Test
  public void upvoteTestException() {
    Mockito.when(postRepository.findById("1")).thenReturn(null);

    Assertions.assertThrows(Exception.class, () -> postService.upvote("1"));
  }

  @Test
  public void upvoteTestSuccess() throws Exception {
    Post post = new Post();
    post.setId("2");
    post.setTitle("Teste");
    post.setBody("Teste");
    post.setUpvotes(32);

    Post savedPost = new Post();
    savedPost.setUpvotes(33);

    Optional<Post> optionalPost = Optional.of(post);

    Mockito.when(postRepository.findById("2")).thenReturn(optionalPost);
    Mockito.when(postRepository.save(post)).thenReturn(savedPost);

    postService.upvote("2");

    Assertions.assertEquals(savedPost.getUpvotes(), 33);
  }

  @Test
  public void removeUpvoteTestException() throws Exception {
    Mockito.when(postRepository.findById("1")).thenReturn(null);

    Assertions.assertThrows(Exception.class, () -> postService.removeUpvote("1"));
  }

  @Test
  public void removeUpvoteTestSuccess() throws Exception {
    Post post = new Post();
    post.setId("2");
    post.setTitle("Teste");
    post.setBody("Teste");
    post.setUpvotes(32);

    Post savedPost = new Post();
    savedPost.setUpvotes(31);

    Optional<Post> optionalPost = Optional.of(post);

    Mockito.when(postRepository.findById("2")).thenReturn(optionalPost);
    Mockito.when(postRepository.save(post)).thenReturn(savedPost);

    postService.removeUpvote("2");

    Assertions.assertEquals(savedPost.getUpvotes(), 31);
  }
}
