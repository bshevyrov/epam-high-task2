package ua.com.company.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.com.company.model.Follow;
import ua.com.company.model.User;
import ua.com.company.repository.FollowRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FollowServiceTest {

    @Mock
    private FollowRepository followRepository;

    @InjectMocks
    private FollowServiceImpl followService;

    private Follow follow;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        follow = new Follow();
        follow.setId(1L);
        User user = new User();
        user.setId(1L);
        User user1 = new User();
        user1.setId(2L);
        follow.setFollower(user);
        follow.setFollowed(user1);
    }

    @Test
    void testCreateFollow() {
        when(followRepository.save(follow)).thenReturn(follow);

        Follow createdFollow = followService.createFollow(follow);
        assertNotNull(createdFollow);
        assertEquals(follow.getFollower().getId(), createdFollow.getFollower().getId());
    }

    @Test
    void testGetFollowsByFollowerId() {
        List<Follow> follows = Arrays.asList(follow);
        when(followRepository.findByFollowerId(1L)).thenReturn(follows);

        List<Follow> foundFollows = followService.getFollowsByFollowerId(1L);
        assertFalse(foundFollows.isEmpty());
        assertEquals(1, foundFollows.size());
        assertEquals(follow.getFollower().getId(), foundFollows.get(0).getFollower().getId());
    }

    @Test
    void testGetFollowsByFollowedId() {
        List<Follow> follows = Arrays.asList(follow);
        when(followRepository.findByFollowedId(2L)).thenReturn(follows);

        List<Follow> foundFollows = followService.getFollowsByFollowedId(2L);
        assertFalse(foundFollows.isEmpty());
        assertEquals(1, foundFollows.size());
        assertEquals(follow.getFollower().getId(), foundFollows.get(0).getFollowed().getId());
    }

    @Test
    void testDeleteFollow() {
        doNothing().when(followRepository).deleteById(1L);

        followService.deleteFollow(1L);
        verify(followRepository, times(1)).deleteById(1L);
    }
}