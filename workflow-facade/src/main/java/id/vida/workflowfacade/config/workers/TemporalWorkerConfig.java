package id.vida.workflowfacade.config.workers;

import org.springframework.stereotype.Component;

import id.vida.workflowfacade.activities.UserRegistrationActivities;
import id.vida.workflowfacade.workflows.UserRegistrationWorkflowImpl;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

/**
 * When integrating with Temporal, you need to ensure that the
 * userRegistrationActivitiesImpl instance used by the Temporal worker is the
 * same instance managed by Spring
 */
@Component
@RequiredArgsConstructor
public class TemporalWorkerConfig
{
    public static final String USER_REGISTRATION_TASK_QUEUE = "user-registration-queue";
    private final WorkerFactory workerFactory;
    private final UserRegistrationActivities userRegistrationActivities;

    @PostConstruct
    public void initWorkers()
    {
        Worker worker = workerFactory.newWorker(USER_REGISTRATION_TASK_QUEUE);
        worker.registerWorkflowImplementationTypes(UserRegistrationWorkflowImpl.class);
        worker.registerActivitiesImplementations(userRegistrationActivities);
        workerFactory.start(); // Important step not to be missed
    }
}
