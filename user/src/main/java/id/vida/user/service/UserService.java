package id.vida.user.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import id.vida.user.model.User;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService
{
    public User createUser(User user)
    {
        log.info("rcvd user={}", user);
        String userId = UUID.randomUUID().toString();
        user.setId(userId);
        return user;
    }
}
