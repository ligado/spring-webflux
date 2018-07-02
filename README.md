# spring-webflux
Sample application for a JavaWorld article that uses Spring WebFlux.

This project implements a BookService RESTful web service in two ways:
* Annotation-based approach
* Functional approach, using a router and handler functions

The `BookController` demonstrates how to build a WebFlux application using traditional Spring annotations, 
namely the `@RestController` and request mapping annotations.

The `BookHandler` and `BookRouter` demonstrate how to build a WebFlux application functionally.

Once you have cloned the repository you can start the application using Maven:

`mvn spring-boot:run`

The `/book` URI maps to the `BookController` while the `/fbook` maps to the `BookRouter` and `BookHandler`.

Here are some sample cURL commands to interact with the application:

### Annotation-based Endpoint
~~~~
$ curl --header "Content-Type: application/json" --request POST --data '{"title": "Book 1", "author": "Mr Author"}' http://localhost:8080/book
{"id":"5b2ea197c0f951f7354085d7","title":"Book 1","author":"Mr Author"}

$ curl --header "Content-Type: application/json" --request POST --data '{"title": "Book 2", "author": "Other Author"}' http://localhost:8080/book
{"id":"5b2ea1b0c0f951f7354085d8","title":"Book 2","author":"Other Author"}

$ curl http://localhost:8080/books
[{"id":"5b2ea197c0f951f7354085d7","title":"Book 1","author":"Mr Author"},{"id":"5b2ea1b0c0f951f7354085d8","title":"Book 2","author":"Other Author"}]

$ curl http://localhost:8080/book/5b2ea197c0f951f7354085d7
{"id":"5b2ea197c0f951f7354085d7","title":"Book 1","author":"Mr Author"}
~~~~

### Functional Endpoint
~~~~
$ curl --header "Content-Type: application/json" --request POST --data '{"title": "Book 1", "author": "Author"}' http://localhost:8080/fbook
{"id":"5b394748aaac8a7c67f94367","title":"Book 1","author":"Author"}

$ curl --header "Content-Type: application/json" --request POST --data '{"title": "Book 2", "author": "Author"}' http://localhost:8080/fbook
{"id":"5b39474daaac8a7c67f94368","title":"Book 2","author":"Author"}

$ curl http://localhost:8080/fbooks
[{"id":"5b394748aaac8a7c67f94367","title":"Book 1","author":"Author"},
 {"id":"5b39474daaac8a7c67f94368","title":"Book 2","author":"Author"}]

$ curl http://localhost:8080/fbook/5b39474daaac8a7c67f94368
{"id":"5b39474daaac8a7c67f94368","title":"Book 2","author":"Author"}

$ curl --header "Content-Type: application/json" --request DELETE http://localhost:8080/fbook/5b39474daaac8a7c67f94368

$ curl http://localhost:8080/fbooks
[{"id":"5b394748aaac8a7c67f94367","title":"Book 1","author":"Author"}]
~~~~