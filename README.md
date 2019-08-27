# inteca
To make it work locally change the services path in CreditController to localhost. Will work perfect.
Example calls:
- curl -i -X POST -H 'Content-Type: application/json' -d '{"firstName": "szymon", "lastName": "poi", "identityNumber": "95101008816", "productName": "kredyt", "productValue": "50000", "creditName": "szybki"}' http://localhost:8761/credits
- curl -i -X POST -H 'Content-Type: application/json' -d '{"firstName": "szymon", "lastName": "poi", "identityNumber": "95101008816", "creditNumber": "3046b28e-d79f-4777-932a-3c0ee0b26ee8"}' http://localhost:8081/customers
- curl -i -X POST -H 'Content-Type: application/json' -d '{"productName": "kredyt", "productValue": "50000", "creditName": "szybki", "creditNumber": "3046b28e-d79f-4777-932a-3c0ee0b26ee8"}' http://localhost:8080/products
- curl -i -X GET http://localhost:8761/credits
- curl -i -X GET http://localhost:8081/customers?creditNumber=9d783bf4-c64e-11e9-88b6-0c54a52d7951
- curl -i -X GET http://localhost:8080/products?creditNumber=9d783bf4-c64e-11e9-88b6-0c54a52d7951

On docker i'm getting an error "error on POST request for \"http://localhost:8080/products\": Connection refused (Connection refused);" although i know the address to endpoint is correct "http://192.168.99.100:8080/products?creditNumber={creditNumber}"
