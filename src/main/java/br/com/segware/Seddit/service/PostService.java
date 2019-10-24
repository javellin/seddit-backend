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
    post.setUpvotes(0);
    return savePost(post);
  }

  public Integer upvote(String postId) throws Exception {
    Post post = postRepository.findById(postId).orElseThrow(Exception::new);

    post.setUpvotes(post.getUpvotes() + 1);

    return savePost(post).getUpvotes();
  }

  public Integer removeUpvote(String postId) throws Exception {
    Post post = postRepository.findById(postId).orElseThrow(Exception::new);

    post.setUpvotes(post.getUpvotes() - 1);

    return savePost(post).getUpvotes();
  }

  private Post savePost(Post post) {
    return postRepository.save(post);
  }
}
