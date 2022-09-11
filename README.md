
# Dashboard

This is an example project implemented in Java EE, it uses primefaces as frontend framework and postgres SQL as database manager


## Getting Started

- Before you start you should run the script src\main\resources\sql_databases.sql which will create the schema you can use pgadmin to import it.
- You must also have the [wildfly application server](https://www.wildfly.org/) configured with the [postgres JDBC](https://jdbc.postgresql.org/download/) 
driver and the datasource you can find how to configure it online, note that the jdni must have the name java:/PostgresDS

### Prerequisites

Requirements for the software and other tools to build, test and push 
- [wildfly application server](https://www.wildfly.org/)
- [postgres JDBC](https://jdbc.postgresql.org/download/)
- Netbeans IDE or Eclipse
- Maven plugin

### Installing

To test the project you will need to clean and build the project from the selected IDE (netbeans recommended),
and upload the generated .war in the deployments section of the wildfly configuration


