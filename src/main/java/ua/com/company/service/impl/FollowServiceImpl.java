package ua.com.company.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.company.model.Follow;
import ua.com.company.repository.FollowRepository;
import ua.com.company.service.FollowService;

import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Override
    public Follow createFollow(Follow follow) {
        return followRepository.save(follow);
    }

    @Override
    public List<Follow> getFollowsByFollowerId(Long followerId) {
        return followRepository.findByFollowerId(followerId);
    }

    @Override
    public List<Follow> getFollowsByFollowedId(Long followedId) {
        return followRepository.findByFollowedId(followedId);
    }

    @Override
    public void deleteFollow(Long id) {
        followRepository.deleteById(id);
    }
}