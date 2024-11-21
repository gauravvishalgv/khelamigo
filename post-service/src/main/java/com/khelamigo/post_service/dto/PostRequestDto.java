package com.khelamigo.post_service.dto;

import java.util.List;

import com.khelamigo.post_service.model.Media;
import com.khelamigo.post_service.model.Tag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDto {

    private String content;
    private Double latitude;
    private Double longitude;
    private List<Media> media;
    private List<Tag> tags;
}
