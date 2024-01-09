package id.vida.workflowfacade.activities;

import org.springframework.stereotype.Component;

import id.vida.workflowfacade.feign.UserApiFeign;
import id.vida.workflowfacade.feign.UserVerificationApiFeign;
import id.vida.workflowfacade.model.User;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserRegistrationActivitiesImpl implements UserRegistrationActivities
{
    private final UserApiFeign userApiFeign;
    private final UserVerificationApiFeign userVerificationApiFeign;

    @Override
    public void validateUser(User user)
    {
        userVerificationApiFeign.verifyUser(user);
    }

    @Override
    public String persistUser(User user)
    {
        User newUser = userApiFeign.createUser(user).getBody();
        return newUser != null ? newUser.getId() : null;
    }
}
