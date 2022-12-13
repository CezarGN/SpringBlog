package edu.cezar.project.SpringApp.dao;

import edu.cezar.project.SpringApp.dao.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
