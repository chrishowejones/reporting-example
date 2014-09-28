# reporting-example



## Prerequisites

You will need [Leiningen][1] 1.7.0 or above installed. You will also need [Postgresql][2] installed.

[1]: https://github.com/technomancy/leiningen
[2]: http://www.postgresql.org/

## Initialisation

You will need to initialise a postgresql database named 'reporting'. You need to edit reporting-example/src/reporting_example/models/db to set the correct user and password.

## Running

To start a web server for the application, run:

    lein ring server

## License

Copyright © 2014 Eclipse 
