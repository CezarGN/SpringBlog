package edu.cezar.project.SpringApp.dao;


import edu.cezar.project.SpringApp.dao.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}
