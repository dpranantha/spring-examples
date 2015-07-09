for XML: curl -X GET -H "Accept: application/xml" http://localhost:8080/rest-api/product/inxml
for json: curl -X GET -H "Accept: application/json" http://localhost:8080/rest-api/product/injson

Request product in JSON: curl -X GET -H "Accept: application/json" http://localhost:8080/rest-api/product/1
save product in JSON: curl -X POST -H "Content-type: application/json" http://localhost:8080/rest-api/product --data '{"name":"ABC","price":9}'
