package edu.cezar.project.SpringApp.dao.entities;

import lombok.*;

import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogPost {
    private long id;
    private String postTitle;
    private String postTest;
    private String postTime;
}
