# inteca
To make it work locally change the services path in CreditController to localhost. Will work perfect.  
  Example calls:
- curl -i -X POST -H 'Content-Type: application/json' -d '{"firstName": "szymon", "lastName": "poi", "identityNumber": "95101008816", "productName": "kredyt", "productValue": "50000", "creditName": "szybki"}' http://localhost:8761/credits
- curl -i -X POST -H 'Content-Type: application/json' -d '{"firstName": "szymon", "lastName": "poi", "identityNumber": "95101008816", "creditNumber": "3046b28e-d79f-4777-932a-3c0ee0b26ee8"}' http://localhost:8081/customers
- curl -i -X POST -H 'Content-Type: application/json' -d '{"productName": "kredyt", "productValue": "50000", "creditName": "szybki", "creditNumber": "3046b28e-d79f-4777-932a-3c0ee0b26ee8"}' http://localhost:8080/products
- curl -i -X GET http://localhost:8761/credits
- curl -i -X GET http://localhost:8081/customers?creditNumber=9d783bf4-c64e-11e9-88b6-0c54a52d7951
- curl -i -X GET http://localhost:8080/products?creditNumber=9d783bf4-c64e-11e9-88b6-0c54a52d7951
  
On docker i'm getting an error "error on POST request for \"http://localhost:8080/products\": Connection refused (Connection refused);" although i know the address to endpoint is correct "http://192.168.99.100:8080/products?creditNumber={creditNumber}" . The same error i'm getting on GET request. 


To build app on docker pull docker images from hub
- docker pull taradaszje/work:credit-microservice
- docker pull taradaszje/work:customer-microservice
- docker pull taradaszje/work:product-microservice
- docker pull taradaszje/work:postgres
  
Next build images in this order:
- docker run -d --name postgres  --expose 5432 -p 127.0.0.1:5432:5432 -e POSTGRES_PASSWORD=admin -e POSTGRES_USER=postgres -e POSTGRES_DB=inteca_work --link postgres  postgres:latest
- docker run -d --name credit --expose 8761 -p 192.168.99.100:8761:8761 -e SPRING_DATASOURCE_PASSWORD=admin -e SPRING_DATASOURCE_USERNAME=postgres -e SPRING_DATASOURCE_URL=jdbc:postgresql://postgres/inteca_work --link postgres credit-microservice:latest  
- docker run -d --name product --expose 8080 -p 192.168.99.100:8080:8080 -e SPRING_DATASOURCE_PASSWORD=admin -e SPRING_DATASOURCE_USERNAME=postgres -e SPRING_DATASOURCE_URL=jdbc:postgresql://postgres/inteca_work --link postgres --link credit product-microservice:latest 
- docker run -d --name customer --expose 8081 -p 192.168.99.100:8081:8081 -e SPRING_DATASOURCE_PASSWORD=admin -e SPRING_DATASOURCE_USERNAME=postgres -e SPRING_DATASOURCE_URL=jdbc:postgresql://postgres/inteca_work --link postgres --link credit customer-microservice:latest  


Example calls:


- curl -i -X POST -H 'Content-Type: application/json' -d '{"firstName": "szymon", "lastName": "poi", "identityNumber": "95101008816", "productName": "kredyt", "productValue": "50000", "creditName": "szybki"}' http://192.168.99.100:8761/credits , doesn't work ;(
- curl -i -X POST -H 'Content-Type: application/json' -d '{"firstName": "szymon", "lastName": "poi", "identityNumber": "95101008816", "creditNumber": "3046b28e-d79f-4777-932a-3c0ee0b26ee8"}' http://192.168.99.100:8081/customers
- curl -i -X POST -H 'Content-Type: application/json' -d '{"productName": "kredyt", "productValue": "50000", "creditName": "szybki", "creditNumber": "3046b28e-d79f-4777-932a-3c0ee0b26ee8"}' http://192.168.99.100:8080/products
- curl -i -X GET http://192.168.99.100:8761/credits , doesn't work ;(
- curl -i -X GET http://192.168.99.100:8081/customers?creditNumber=9d783bf4-c64e-11e9-88b6-0c54a52d7951
- curl -i -X GET http://192.168.99.100:8080/products?creditNumber=9d783bf4-c64e-11e9-88b6-0c54a52d7951
