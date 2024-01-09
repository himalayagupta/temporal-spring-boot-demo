package id.vida.userverification.service;

import org.springframework.stereotype.Service;

import id.vida.userverification.model.User;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserVerificationService
{
    public User verifyUser(User user)
    {
        log.info("rcvd user={}", user);
        // do something
        return user;
    }
}
