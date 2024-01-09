package id.vida.workflowfacade.workflows;

import id.vida.workflowfacade.model.User;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface UserRegistrationWorkflow
{
    @WorkflowMethod
    String processRegistration(User user);
}
