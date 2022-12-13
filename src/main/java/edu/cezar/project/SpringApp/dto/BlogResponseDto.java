package edu.cezar.project.SpringApp.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogResponseDto {
    private long Id ;
    private String blogTitle;
    private String username;
}
