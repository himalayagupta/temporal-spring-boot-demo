# Setting Up Temporal with Docker
```
git clone https://github.com/temporalio/docker-compose.git temporalio
cd temporalio
docker-compose up
```
# Setting up Spring boot projects

## Setting up Spring-Cli
We will use Spring-Cli to create service projects. Let's start with installing Spring-Cli
```
brew tap spring-io/tap
brew install spring-boot
java -version
mvn -v
```

## User Service
A service responsible to manage the user. This will assign unique identifier to the user
```
spring init --dependencies=web,jpa,h2 --java-version=17 --build=maven --group-id=id.vida --artifact-id=user --name=user --description="User Service" user
```

## User verification Service
A service responsible to verify the user's information
```
spring init --dependencies=web,jpa,h2 --java-version=17 --build=maven --group-id=id.vida --artifact-id=user-verification --name=user-verification --description="User Verification Service" user-verification
```

## Workflow API Facade
Create an API Facade service which will expose REST APIs to be invoked from external clients. This will be the entry point to trigger the execution of workflows
```
spring init --dependencies=web --java-version=17 --build=maven --group-id=id.vida --artifact-id=workflow-facade --name=workflow-facade --description="Workflow Facade Service" workflow-facade
```