package com.khelamigo.post_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khelamigo.post_service.dto.PostRequestDto;
import com.khelamigo.post_service.model.Post;
import com.khelamigo.post_service.model.Tag;
import com.khelamigo.post_service.model.User;
import com.khelamigo.post_service.repository.PostRepository;
import com.khelamigo.post_service.repository.TagRepository;
import com.khelamigo.post_service.repository.UserRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TagRepository tagRepository;

    public List<Post> getAllPosts() {

        return postRepository.findAll();
    }

    public List<Post> getPostsByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }

    public List<Post> getPostsByTagName(String tagName) {
        return postRepository.findByTagsName(tagName);
    }

    public Post createPost(PostRequestDto postRequestDto, Long userId) {

        User user = new User();
        user.setId(userId);

        Post post = new Post();
        post.setContent(postRequestDto.getContent());
        post.setLatitude(postRequestDto.getLatitude());
        post.setLongitude(postRequestDto.getLongitude());
        post.setMedia(postRequestDto.getMedia());

        //If the tag already exists use it otherwise create a new
        List<Tag> tags = postRequestDto.getTags().stream().map(tagDto -> {
            return tagRepository.findByName(tagDto.getName())
                .orElseGet(() -> {
                    Tag newTag = new Tag();
                    newTag.setName(tagDto.getName());
                    return tagRepository.save(newTag);
                });
            }).collect(Collectors.toList());

        post.setTags(tags);

        post.setUser(user);

        return postRepository.save(post);
    }

    @Transactional
    public Post likePost(String postId, Long userId) {
        
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));

        User existingUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        post.getLikes().add(existingUser);

        return postRepository.save(post);
    }

    @Transactional
    public void deletePost(String postId) {
        
        if (!postRepository.existsById(postId)) {
            throw new RuntimeException("Post not found");
        }
        // postRepository.deleteById(postId);
        postRepository.deletePostWithAllAssociations(postId);
    }
}
