# salary_slip_calculation_mongodb

Spring-boot + Mongo DB + JPA / Hibernate + REST CRUD

For Mongo DB integration to spring boot, we have to add the following starter dependency in pom.xml.

 <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>


Implemented REST CRUD APIs for calculating the salary of employee. Employee model class includes empId, designation, date of joining, retirement date, basic pay, da, special allowance, professional tax and pf.

REST APIs details:
1. http://localhost:8080/employees/ (GET)
2. http://localhost:8080/employees/byEmpId/{empId} (GET)
3. http://localhost:8080/employees/byDesignation/{designation} GET
4. http://localhost:8080/employees/orderByDa GET
5. http://localhost:8080/employees/save POST
6. http://localhost:8080/employees/delete/{id} DELETE
