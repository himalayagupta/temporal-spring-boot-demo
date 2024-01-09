package id.vida.workflowfacade.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import id.vida.workflowfacade.model.User;

@FeignClient(name = "userVerificationApiFeign", url = "${feign.base-url.user-verification-api}", contextId = "UserVerificationApiFeign")
public interface UserVerificationApiFeign
{
    @PostMapping("/user-verification")
    public ResponseEntity<User> verifyUser(@RequestBody User user);
}