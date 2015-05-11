REST JSON API: Countries
=========================

Simple interface for querying country information by CCA2 two-character country code,
per assignment https://bitbucket.org/mikaelhg/interview-countries

# Find the beef
* Test: [test/countries_ring_clojure/handler_test.clj](test/countries_ring_clojure/handler_test.clj)
* Implementation: [src/countries_ring_clojure/handler.clj](src/countries_ring_clojure/handler.clj)

# Install prerequisites
1. [Leiningen](https://github.com/technomancy/leiningen) 2.0.0 or above

# Test it
`lein do clean, test`

# Run it locally
`lein ring server`

Check out the details of Finland at http://localhost:3000/countries/FI

# Deploy on Heroku
Prerequisites:

1. A [Heroku](https://heroku.com/) account, obviously
2. [Heroku toolbelt](https://toolbelt.heroku.com/) installed and ready to go

Set up a new app on Heroku and deploy:
```
heroku create
git push heroku master
```
