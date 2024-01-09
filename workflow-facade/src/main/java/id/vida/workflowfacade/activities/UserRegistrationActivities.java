package id.vida.workflowfacade.activities;

import id.vida.workflowfacade.model.User;
import io.temporal.activity.ActivityInterface;

/**
 * User registration activities consists of performing validation and persisting
 * of the user
 */
@ActivityInterface
public interface UserRegistrationActivities
{
    void validateUser(User user);

    String persistUser(User user);
}
