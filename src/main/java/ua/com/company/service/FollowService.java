package ua.com.company.service;


import ua.com.company.model.Follow;

import java.util.List;

public interface FollowService {
    Follow createFollow(Follow follow);
    List<Follow> getFollowsByFollowerId(Long followerId);
    List<Follow> getFollowsByFollowedId(Long followedId);
    void deleteFollow(Long id);
}