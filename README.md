# rockwell

### ArchUnit

One of the main components of a successful project is technical leadership that lets the team go in the right
direction. Nevertheless, there are tools that can support teams in keeping the code clean and protect the
architecture, so that the project won't become a Big Ball of Mud, and thus will be pleasant to develop and
to maintain. The first option, the one we proposed, is [ArchUnit](https://www.archunit.org/) - a Java architecture
test tool. ArchUnit lets you write unit tests of your architecture, so that it is always consistent with initial
vision. Maven modules could be an alternative as well, but let's focus on the former.

In terms of hexagonal architecture, it is essential to ensure, that we do not mix different levels of
abstraction (hexagon levels):
```java 
    @ArchTest
    public static final ArchRule model_should_not_depend_on_infrastructure =
            noClasses()
                    .that()
                    .resideInAPackage("..domain.model..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAPackage("..infrastructure..");
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

