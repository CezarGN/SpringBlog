package edu.cezar.project.SpringApp.controllers;


import edu.cezar.project.SpringApp.dao.entities.Blog;
import edu.cezar.project.SpringApp.dto.BlogResponseDto;
import edu.cezar.project.SpringApp.dto.CreateBlogDto;
import edu.cezar.project.SpringApp.services.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;


@RestController
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping("/blog")
   public ResponseEntity <Blog> findBlog(@RequestParam long id)
    throws URISyntaxException {
        return new ResponseEntity(
                id,
                HttpStatus.ACCEPTED);
    }

    @GetMapping("/blogs")
   public ResponseEntity <Blog> all()
       throws URISyntaxException{
       return new ResponseEntity(
              blogService.findAll(),
               HttpStatus.ACCEPTED);
   }


   @DeleteMapping("/blog")
   public ResponseEntity<Long> deleteBlog(@RequestParam long Id)
   throws URISyntaxException {
        blogService.deleteBlog(Id);
        return new ResponseEntity(
                HttpStatus.ACCEPTED
        );
    }


    @PostMapping("/blog")
    public ResponseEntity<Blog> createBlog(@RequestBody CreateBlogDto example)
            throws URISyntaxException {
        return new ResponseEntity(
                blogService.saveBlog(example),
                HttpStatus.CREATED);
    }

    @PutMapping("/blog")
    public ResponseEntity<Blog> updateBlog(@RequestBody BlogResponseDto example, @RequestParam long Id)
    throws URISyntaxException{
        return new ResponseEntity(
                blogService.updateBlog(example, Id),
                HttpStatus.ACCEPTED);
    }
}


