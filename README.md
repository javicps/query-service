# Price Endpoint

A simple service to obtain applicable prices for retail products.


## API REST

### GET /api/prices
Query this endpoint to retrieve the applicable prices for a product in a brand in within specific dates.

### Parameters:
- **productId**: a string defining a particular product
- **brandId**: the identifier for a brand
- **date**: the date where you want to check for the applicable tariff/price (normally current date)

### Exceptions
#### PriceNotFoundException

### Sample usage:

```jshelllanguage
/api/prices?productId=35455&brandId=1&date=2020-06-14%2016:00:00
```

## Testing
### PriceControllerTest.java 
A collection of several tests that retrieve data from the H2 table prices.


### PriceTest.java
Unit tests for the Price model which defines the prices table


### Load testing

Steps:

1. Download wrk
2. Run QueryServiceApplication.java
2. Run a load test:
    ```shell 
   wrk -t4 -c100 -d30s "http://localhost:8080/api/prices?productId=35455&brandId=1&date=2020-06-14%2010:00:00"
   Running 20s test @ http://localhost:8080/api/prices?productId=35455&brandId=1&date=2020-06-14%2010:00:00
    4 threads and 100 connections
    Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    17.44ms   36.84ms 433.31ms   94.07%
    Req/Sec     2.92k     1.02k    4.55k    71.26%
    227112 requests in 20.03s, 49.64MB read
    Socket errors: connect 0, read 1, write 0, timeout 0
    Requests/sec:  11340.89

    ```
