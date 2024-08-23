package ua.com.company.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.company.model.Follow;
import ua.com.company.service.FollowService;

import java.util.List;

@RestController
@RequestMapping("/api/follows")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping
    public ResponseEntity<Follow> createFollow(@RequestBody Follow follow) {
        Follow createdFollow = followService.createFollow(follow);
        return new ResponseEntity<>(createdFollow, HttpStatus.CREATED);
    }

    @GetMapping("/follower/{followerId}")
    public ResponseEntity<List<Follow>> getFollowsByFollowerId(@PathVariable Long followerId) {
        List<Follow> follows = followService.getFollowsByFollowerId(followerId);
        return follows.isEmpty() ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(follows);
    }

    @GetMapping("/followed/{followedId}")
    public ResponseEntity<List<Follow>> getFollowsByFollowedId(@PathVariable Long followedId) {
        List<Follow> follows = followService.getFollowsByFollowedId(followedId);
        return follows.isEmpty() ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(follows);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFollow(@PathVariable Long id) {
        followService.deleteFollow(id);
        return ResponseEntity.noContent().build();
    }
}
