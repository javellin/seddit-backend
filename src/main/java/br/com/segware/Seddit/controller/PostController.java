package br.com.segware.Seddit.controller;

import br.com.segware.Seddit.domain.Post;
import br.com.segware.Seddit.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {

  @Autowired
  private PostService postService;

  @GetMapping
  public Iterable<Post> findAll() {
    return postService.findAll();
  }

  @PostMapping
  public Post createPost(@RequestBody Post post) {
    return postService.createPost(post);
  }

  @PutMapping(path = "/{id}/upvote")
  public Post upvote(@PathVariable String id) throws Exception {
    return postService.upvote(id);
  }

  @PutMapping(path = "/{id}/removeUpvote")
  public Post removeUpvote(@PathVariable String id) throws Exception {
    return postService.removeUpvote(id);
  }
}
