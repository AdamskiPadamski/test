# General

## My specs while developing

java version "1.8.0_51"

Java(TM) SE Runtime Environment (build 1.8.0_51-b16)

Java HotSpot(TM) 64-Bit Server VM (build 25.51-b03, mixed mode)

javac 1.8.0_51

These exact specs shouldn't be necessary to run the application, some
version of Java 8 is required though.

## Building and running

The project is built with Maven. A wrapper has been included for Maven
so that you won't have to download maven if you don't want to (provided
the wrapper works!). To run, clone the project and cd into its working 
directory. From here it should simply be a case of running:

```
    ./mvnw spring-boot:run
```

Then if you go to http://localhost:8080/ you should be able to make use
of the site. 

The backend has a fairly comprehensive test suite, if you want to run
the tests while building, run:

```
    ./mvnw package
```

This will generate a jar file under the generated 'target' directory
that can be ran with:

```
    java -jar <jar_name_here>
```

## Other information

The backend application makes use of h2, an in-memory Java database to
store data (this database is populated at startup using Spring's 
CommandLineRunner). I don't believe this should cause any issues, but
if you do run into any at the database level this may be relevant.

In addition, the backend also makes use of the
Lombok library which provides a way to remove boilerplate such as
getters/setters via annotations. If you use an IDE you will likely have
to do some minor configuration for it to play nicely with Lombok. This
is fairly straightforward for both Eclipse and IntelliJ. IntelliJ 
should tell you what to do (enable annotation processing and download 
the Lombok plugin), I'm afraid I'm not too sure for Eclipse but I 
imagine it will be a similar process.

Thanks,

Adam :)