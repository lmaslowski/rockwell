# rockwell

### Port-adapter-architecture - ArchUnit

In terms of hexagonal architecture, it is essential to ensure, that we do not mix different levels of
abstraction (hexagon levels)
```java 
@ArchTest
public static final ArchRule model_should_not_depend_on_adapter =
        noClasses()
            .that()
            .resideInAPackage("..domain.model..")
            .should()
            .dependOnClassesThat()
            .resideInAPackage("..adapter..");
```      
and that frameworks do not affect the domain model
```java
@ArchTest
public static final ArchRule model_should_not_depend_on_spring =
        noClasses()
            .that()
            .resideInAPackage(
                    "..com.kata.rockwell..domain.model..")
            .should()
            .dependOnClassesThat()
            .resideInAPackage("org.springframework..");

@ArchTest
public static final ArchRule application_should_not_depend_on_spring =
        noClasses()
            .that()
            .resideInAPackage(
                    "..com.kata.rockwell..application..")
            .should()
            .dependOnClassesThat()
            .resideInAPackage("org.springframework..");
```

### Extensibility

In order to add new mapper, interface ```Mapper``` should be implemented or ```AbstractMapper``` class has to be extended  

For instance:

```java
@Service("cars")
public class CarsMapper extends AbstractMapper {
    public CarsMapper(@Qualifier("cars") Map<Integer, String> map) {
        super(map);
    }
}
```

```java
@Bean
@Qualifier("cars")
public Map<Integer, String> mapToCars(){
        return new HashMap<>(){{
        put(1,"Audi");
        put(2,"Bmw");
        put(3,"Citroen");
        put(4,"Dacia");
        }};
        }
```

or

```java

@Service("cars")
@AllArgsConstructor
public class CarsMapper implements Mapper {

    private final SpringJpaCarRepository repository;

    @Override
    public String map(Integer number) {
        return repository.findById(number).map(Car::getName).orElse("not mapped");
    }
}

```

###Helpful commands

Run only integration tests: 
```mvn clean && mvn install -DskipTests=true && mvn failsafe:integration-test```
