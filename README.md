# Api Gateway
#### Uses: Spring boot + Apache Camel

This project is a PoC to simulate an API Gateway for orchestration of rest services, data transformation, and others..

### How to run 
Both apps are using Maven. Just run *mvn install*, then run *"java -jar name-of-the-generated-package.jar"*


### Endpoints

#### Rest services (backend endpoints)
localhost:3030/veiculos/1 <br/>
localhost:3030/habilitacoes/1


#### Gateway orchestrator (external endpoint)
localhost:8080/api/condutor

