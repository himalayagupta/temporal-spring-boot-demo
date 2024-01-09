package id.vida.workflowfacade.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.WorkerFactory;

@Configuration
public class TemporalConfig
{
    /**
     * Creates bean for Temporal Workflow client
     *
     * @return an instance of Temporal Client to communicate with temporal server
     */
    @Bean
    public WorkflowServiceStubs workflowServiceStubs()
    {
        return WorkflowServiceStubs.newLocalServiceStubs(); // intended only for local development
    }

    @Bean
    public WorkflowClient workflowClient()
    {
        return WorkflowClient.newInstance(workflowServiceStubs());
    }

    @Bean
    public WorkerFactory workerFactory()
    {
        return WorkerFactory.newInstance(workflowClient());
    }
}
