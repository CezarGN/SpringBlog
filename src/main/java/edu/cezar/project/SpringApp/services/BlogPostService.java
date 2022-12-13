package edu.cezar.project.SpringApp.services;

import edu.cezar.project.SpringApp.dao.BlogPostRepository;
import edu.cezar.project.SpringApp.dao.entities.BlogPost;
import edu.cezar.project.SpringApp.dto.BlogPostResponseDto;
import edu.cezar.project.SpringApp.dto.CreateBlogDto;
import edu.cezar.project.SpringApp.dto.CreateBlogPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.*;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository repository;

    public BlogPostResponseDto saveBlogPost(CreateBlogPostDto dto){
        BlogPost newBlogPost = BlogPost.builder()
                .postTitle(dto.getPostTitle())
                .postTest(dto.getPostTest())
                .postTime(dto.getPostTime())
                .build();

        var savedDB = repository.save(newBlogPost);

        return BlogPostResponseDto.builder()
                .id(savedDB.getId())
                .postTitle(savedDB.getPostTitle())
                .postTime(savedDB.getPostTime())
                .build();
    }

    public boolean findBlogPost(long id){
        return repository.existsById(id);
    }

    public BlogPostRepository getAllBlogPosts(){
        return repository;
    }

    public void deleteBlogPost(long id){
        repository.deleteById(id);
    }


    //ENTITY TO DTO
    public BlogPostResponseDto entityToDto(BlogPost example){
        return (BlogPostResponseDto.builder()
                .postTest(example.getPostTest())
                .postTime(example.getPostTime())
                .postTitle(example.getPostTitle()).build()
        );

    }

    //DTO TO ENTITY
    public BlogPost dtoToEntity(BlogPostResponseDto example){
        return (BlogPost.builder()
                .postTest(example.getPostTest())
                .postTime(example.getPostTime())
                .postTitle(example.getPostTitle())
                .build());

    }
}


