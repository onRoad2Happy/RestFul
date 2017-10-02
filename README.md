Restful service with DB CRUD operation using JAX-RS and MYSQL

Rest stands for represtational state transfer it's architecural style for creating web network based application.

JAX-RS is the Java API specification and jersey its implementation.

In below program, we will perform CRUD operation in Restful application with Java JAX-RS using jersey.


Please follow below steps:

1. Create maven project using jersey all dependencies are already added in pom.xml.

2. Create model class which will be similar to the table. (POJO class) class annotated with @XmlRootElement

3. Create DAO, having DB connection details, along with DB operations (create, read, update and delete).

4. Create DTO, having one more layer which will help to communicate to database.

5. Service class starting point of the project (@Path, @PathParam, @GET,@POST,@PUT,@DELETE, @Producer, @Consumer, Mediatype etc..)

6. Configure package related information in web.xml, resource will be triggered from browser and based on web.xml configuration it will look for the particular
   class and will perform the operations.


