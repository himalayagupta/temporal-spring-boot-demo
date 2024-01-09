package id.vida.workflowfacade.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.vida.workflowfacade.config.workers.TemporalWorkerConfig;
import id.vida.workflowfacade.model.User;
import id.vida.workflowfacade.workflows.UserRegistrationWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class WorkflowController
{

    private final WorkflowClient workflowClient;

    @PostMapping("/register-user")
    public ResponseEntity<User> postMethodName(@RequestBody User entity)
    {
        // Configure WorkflowOptions (you can set task queue, workflow id, etc.)
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(TemporalWorkerConfig.USER_REGISTRATION_TASK_QUEUE)
                .build();

        UserRegistrationWorkflow wfStub = workflowClient.newWorkflowStub(UserRegistrationWorkflow.class, options);

        try
        {
            // Perform Sync. execution
            CompletableFuture<String> status = WorkflowClient.execute(wfStub::processRegistration, entity);
            String userId = status.get();
            entity.setId(userId);
        } catch (Exception e)
        {
            log.error("error in workflow");
        }
        return ResponseEntity.ok(entity);
    }

}
