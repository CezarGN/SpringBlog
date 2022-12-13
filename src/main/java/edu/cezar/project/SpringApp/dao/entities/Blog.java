package edu.cezar.project.SpringApp.dao.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id ;
    private String blogTitle;
    private String username;

    @OneToMany
    private List<BlogPost> blogPosts = new ArrayList<BlogPost>();
}
