# ExchangeApi
how to build the docker image:	

docker build -t "exchange-docker" .

how to run the docker image:

docker run -e API_EXCHANGE_KEY='3HHrFU7Zh9D7uBVyYqfy1v56ol5Y36GX' -p 3030:3030 -e output.names='true' exchange-docker:latest

http://localhost:3030/api/v1/exchange/?from={currencyCodeUpperCase}&to={currencyCodeUpperCase}&quantity={DoubleQuantity}

Example

http://localhost:3030/api/v1/exchange/?from=EUR&to=JPY&quantity=500
