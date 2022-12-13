package edu.cezar.project.SpringApp.services;

import edu.cezar.project.SpringApp.dao.BlogRepository;
import edu.cezar.project.SpringApp.dao.entities.Blog;
import edu.cezar.project.SpringApp.dao.entities.BlogPost;
import edu.cezar.project.SpringApp.dto.BlogResponseDto;
import edu.cezar.project.SpringApp.dto.CreateBlogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    private BlogRepository repository;

    public BlogResponseDto saveBlog(CreateBlogDto dto) {
        Blog newBlog = Blog.builder()
                .blogTitle(dto.getBlogTitle())
                .username(dto.getUsername())
                .build();

        var savedDb =repository.save(newBlog);

        return BlogResponseDto.builder()
                .Id(savedDb.getId())
                .blogTitle(savedDb.getBlogTitle())
                .username(savedDb.getUsername())
                .build();
    }

    public boolean findBlog(long id){
        return repository.existsById(id);
    }

    public BlogResponseDto updateBlog(BlogResponseDto dto, long id){

        Blog updatedBlog = Blog.builder()
                .blogTitle(dto.getBlogTitle())
                .username(dto.getUsername())
                .Id(id)
                .build();

        var savedDb = repository.save(updatedBlog);

        return BlogResponseDto.builder()
                .Id(savedDb.getId())
                .blogTitle(savedDb.getBlogTitle())
                .username(savedDb.getUsername())
                .build();
    }

    public void deleteBlog(long id){
        repository.deleteById(id);
    }

    public Blog dtoToEntity(BlogResponseDto dto) {
        return (Blog.builder()
                .username(dto.getUsername())
                .blogTitle(dto.getBlogTitle())
                .username(dto.getUsername())
                .build()
        );
    }

    public BlogResponseDto entityToDto(Blog blog){
        return(BlogResponseDto.builder()
                .username(blog.getUsername())
                .blogTitle(blog.getBlogTitle())
                .Id(blog.getId())
                .build());
    }
}
