package edu.cezar.project.SpringApp.controllers;
import edu.cezar.project.SpringApp.dao.entities.BlogPost;


import edu.cezar.project.SpringApp.dto.CreateBlogPostDto;
import edu.cezar.project.SpringApp.services.BlogPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class BlogpostController {
List<BlogPost> repo2 = new ArrayList<>();
private final BlogPostService blogPostService;

     @PostMapping ("/blogpost")
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody CreateBlogPostDto example2)
    throws URISyntaxException{
        return new ResponseEntity(
                blogPostService.saveBlogPost(example2),
                HttpStatus.CREATED
        );
     }

     @GetMapping("/blogpost")
     public ResponseEntity<BlogPost> findBlogPost(@RequestParam long id)
         throws URISyntaxException{
        return new ResponseEntity(
                blogPostService.findBlogPost(id),
                HttpStatus.ACCEPTED
        );
     }


     @GetMapping("/blogposts")
     public ResponseEntity<BlogPost> all()
     throws URISyntaxException{
        return new ResponseEntity(
                blogPostService.getAllBlogPosts(),
                HttpStatus.ACCEPTED
        );
     }

     @DeleteMapping("/blogpost")
    public ResponseEntity deleteBlogPost(@RequestParam long id)
         throws URISyntaxException{
         blogPostService.deleteBlogPost(id);
       return new ResponseEntity(
               HttpStatus.ACCEPTED
       );

     }
}
