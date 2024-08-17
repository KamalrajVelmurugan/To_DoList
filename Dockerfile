from eclipse-temurin:17
copy target/employee.jar employee.jar
cmd ["java", "jar", "employee.jar"]