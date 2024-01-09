package id.vida.workflowfacade.workflows;

import java.time.Duration;

import id.vida.workflowfacade.activities.UserRegistrationActivities;
import id.vida.workflowfacade.model.User;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserRegistrationWorkflowImpl implements UserRegistrationWorkflow
{

    private final UserRegistrationActivities activities = Workflow.newActivityStub(UserRegistrationActivities.class,
            ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(2)).build());

    @Override
    public String processRegistration(User user)
    {
        activities.validateUser(user);
        String newUserId = activities.persistUser(user);
        log.info("New user created with userId={}", newUserId);
        return newUserId;
    }
}
