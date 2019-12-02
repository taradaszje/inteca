# Inteca prework
## Setup
### 1
Browse to microservices directories and type : ```mvn package ```
to build jar files.
To run this microservices 
To build docker images let's execute mvn package in credit application directory.  
Next please run docker-compose file to 

## Example usage
```  
  Example calls:
- curl -i -X POST -H 'Content-Type: application/json' -d '{"firstName": "Jan", "lastName": "Nowak", "identityNumber": "95101008816", "productName": "Kredyt", "productValue": "50000", "creditName": "Kredyt dla Jana"}' http://192.168.99.100:8600/createCredit
- curl -i -X POST -H 'Content-Type: application/json' -d '{"firstName": "Jan", "lastName": "Nowak", "identityNumber": "95101008816", "creditID": "3046b28e-d79f-4777-932a-3c0ee0b26ee8"}' http://192.168.99.100:8081/createCustomer
- curl -i -X POST -H 'Content-Type: application/json' -d '{"productName": "kredyt", "productValue": "50000", "creditName": "szybki", "creditID": "3046b28e-d79f-4777-932a-3c0ee0b26ee8"}' http://192.168.99.100:8080/createProduct
- curl -i -X GET http://192.168.99.100:8600/getCredits
- curl -i -X GET http://192.168.99.100:8081/getCustomer/9d783bf4-c64e-11e9-88b6-0c54a52d7951
- curl -i -X GET http://192.168.99.100:8080/getProduct/9d783bf4-c64e-11e9-88b6-0c54a52d7951
```


