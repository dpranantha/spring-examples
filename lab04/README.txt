for XML: curl -X GET -H "Content-type: application/xml" http://localhost:8080/rest-api/product/inxml
for json: curl -X GET -H "Content-type: application/json" http://localhost:8080/rest-api/product/injson

Request product in JSON: curl -X GET -H "Content-type: application/json" http://localhost:8080/rest-api/product/1
Save product in JSON: curl -X POST -H "Content-type: application/json" http://localhost:8080/rest-api/product --data '{"name":"ABC","price":9}'
Query all products in JSON: curl -X GET -H "Content-type: application/json" http://localhost:8080/rest-api/product