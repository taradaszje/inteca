# Inteca prework
## Microservices
The goal of the task is to create application in distributed architecture
## Setup
### First step
Browse to microservices directory and type : ```mvn package```
to build jar files and docker images.(without local db, jars can't be build)
### Last step
Execute ```docker-compose up``` in the same directory. 
This step will build postgres image with initial database, next will run all the rest application components. 
## Testing
### Browser
You can test app via html using this URLs:

[getCredits](http://192.168.99.100:8080/api/credits)    
[getCustomer](http://192.168.99.100:8080/cs/customers/9d783bf4-c64e-11e9-88b6-0c54a52d7951)  
[getProduct](http://192.168.99.100:8080/ps/products/9d783bf4-c64e-11e9-88b6-0c54a52d7951)  
###  Command line
Or via console:
```  
curl -i -X POST -H 'Content-Type: application/json' -d '{"firstName": "Jan", "lastName": "Nowak", "identityNumber": "95101008816", "productName": "Kredyt", "productValue": "50000", "creditName": "Kredyt dla Jana"}' http://192.168.99.100:8080/api/credits
curl -i -X POST -H 'Content-Type: application/json' -d '{"firstName": "Jan", "lastName": "Nowak", "identityNumber": "95101008816", "creditID": "3046b28e-d79f-4777-932a-3c0ee0b26ee8"}' http://192.168.99.100:8080/cs/customers
curl -i -X POST -H 'Content-Type: application/json' -d '{"productName": "kredyt", "productValue": "50000", "creditName": "szybki", "creditID": "3046b28e-d79f-4777-932a-3c0ee0b26ee8"}' http://192.168.99.100:8080/ps/products
curl -i -X GET http://192.168.99.100:8080/api/credits
curl -i -X GET http://192.168.99.100:8080/cs/customers/9d783bf4-c64e-11e9-88b6-0c54a52d7951
curl -i -X GET http://192.168.99.100:8080/ps/products/9d783bf4-c64e-11e9-88b6-0c54a52d7951
```
## TODO
+ Use kubernetes.
+ Push images to public docker repo

