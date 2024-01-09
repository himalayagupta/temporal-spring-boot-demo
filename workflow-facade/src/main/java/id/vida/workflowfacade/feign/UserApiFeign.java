package id.vida.workflowfacade.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import id.vida.workflowfacade.model.User;

@FeignClient(name = "userApiFeign", url = "${feign.base-url.user-api}", contextId = "UserApiFeign")
public interface UserApiFeign
{
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user);
}