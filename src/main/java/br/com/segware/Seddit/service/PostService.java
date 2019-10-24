package br.com.segware.Seddit.service;

import br.com.segware.Seddit.domain.Post;
import br.com.segware.Seddit.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostService {

  @Autowired
  private PostRepository postRepository;

  public Iterable<Post> findAll() {
    return postRepository.findAll();
  }

  public Post createPost(Post post) {
    return savePost(post);
  }

  public Post upvote(String postId) throws Exception {
    Post post = postRepository.findById(postId).orElseThrow(Exception::new);

    post.setUpvotes(post.getUpvotes() + 1);

    return savePost(post);
  }

  public Post removeUpvote(String postId) throws Exception {
    Post post = postRepository.findById(postId).orElseThrow(Exception::new);

    post.setUpvotes(post.getUpvotes() - 1);

    return savePost(post);
  }

  private Post savePost(Post post) {
    return postRepository.save(post);
  }
}
