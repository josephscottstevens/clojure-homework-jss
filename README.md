# Web API to parse and sort a set of records

## to run console application ##
  lein run "FilePath1" "FilePath2" "FilePath3"
# For example: 
  lein run "./resources/comma_delimited.txt" "./resources/pipe_delimited.txt" "./resources/space_delimited.txt"
##                            ##

## start web API with
  lein ring server

## to run tests
  lein test

## then browser to
  http://localhost:3000/

## Endpoints
- POST /records - Post a single data line in any of the 3 formats supported by your existing code
- GET /records/gender - returns records sorted by gender
- GET /records/birthdate - returns records sorted by birthdate
- GET /records/name - returns records sorted by name
