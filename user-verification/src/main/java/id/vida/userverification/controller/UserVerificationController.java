package id.vida.userverification.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.vida.userverification.model.User;
import id.vida.userverification.service.UserVerificationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user-verification")
@RequiredArgsConstructor
public class UserVerificationController
{
    private final UserVerificationService userVerificationService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        return ResponseEntity.ok(userVerificationService.verifyUser(user));
    }
}
