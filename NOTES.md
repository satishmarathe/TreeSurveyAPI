##1 To return a List from controller :
Use this : public ResponseEntity<?> getFestivals()
Rather than : public List<MusicFestival> getFestivals()

##2 In POJO to suppress attributes appearing in json o/p:
Use annotation : @JsonIgnore in bean getter it will not send it in json o/p

##3 To use a default Postgres schema:
In application.properties while specifying URL do the following :
spring.datasource.url=jdbc:postgresql://localhost:5433/postgres?currentSchema=tree_survey

Notice that we have appended 'currentSchema' at the end !
Reference:https://stackoverflow.com/questions/39430422/how-to-properly-specify-database-schema-in-spring-boot

##4 Posted data from UI not populating POJO
This is the place where we need to use @RequestBody annotation which will ensure that spring boot will use Jackson to bind
ui sent json payload to our Java POJO

```java
	@CrossOrigin   
    @PostMapping("/api/v1/surveys")
    public ResponseEntity<?>  createSurvey(@RequestBody Survey survey) {
```


