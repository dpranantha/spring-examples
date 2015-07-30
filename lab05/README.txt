Request book list for XML: curl -X GET -H "Content-type: application/xml" http://localhost:8080/rest-api/book/books.xml
Save a book in XML: curl -X POST -H "Content-type: application/xml" http://localhost:8080/rest-api/book --data '<?xml version="1.0" encoding="UTF-8" standalone="yes"?><book><title>the martian</title></book>'
Or use Poster in Firefox or Postman in Chrome