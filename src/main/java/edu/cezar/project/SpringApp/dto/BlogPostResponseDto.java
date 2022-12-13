package edu.cezar.project.SpringApp.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogPostResponseDto {
    private long id;
    private String postTitle;
    private String postTest;
    private String postTime;
}
