## Hibernate Association
Implementation of a bidirectional mapping with Hibernate<br />
Association 1:N <br />



### Technologies
JPA, Hibernate, Association<br />
Databases: MySQL, MSSQL <br />


### Data Model
Entities: <br />
TouristCity, Hotel <br />

Associations, Relations: <br />
TouristCity:Hotel = 1:N <br />

Dao: <br /> 
Implements CRUD operations <br />

Implementation of Associaton in Database:  <br />
Hibernate creates joincolumn/foreign key column according to the @ManyToOne annotation <br />




### Steps
##### MYSQL
Use persistence unit 'jpa-example-mysql'  <br />
Start MySQL <br />
Create table 'jpa_example' <br />

##### MSSQLSERVER
Use persistence unit 'jpa-example-mssqlserver'  <br />
Start MSSQLSERVER <br />
Create table 'jpa_example' <br />



##### Run as Test
*mvn test* <br />


##### Build jar, Run jar
*mvn clean compile package* <br />
*java -jar target/jar-name.jar* <br />





