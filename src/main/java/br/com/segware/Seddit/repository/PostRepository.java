package br.com.segware.Seddit.repository;

import br.com.segware.Seddit.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, String> {
}
