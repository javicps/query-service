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
