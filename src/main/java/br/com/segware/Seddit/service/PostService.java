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
}
