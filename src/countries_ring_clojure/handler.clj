(ns countries-ring-clojure.handler
  (:require [clojure.data.json :as json]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

;; Raw JSON data as String
(def ^:private json-data (slurp "countries.json"))

;; Countries as Vector[Map]
(def ^:private countries (json/read-str json-data))

;; Countries by CCA2 code as Map[String, Map]
(def ^:private countries-by-cca2
  (->> countries
       (mapcat (fn [country] [(get country "cca2") country]))
       (apply array-map)))

(defn country [cca2]
  (if-let [details (get countries-by-cca2 cca2)]
    {:headers {"Content-type" "application/json"}
     :body (json/write-str details)}
    {:status 404
     :headers {"Content-type" "application/json"}}
  )
)

(defroutes app-routes
  (GET "/countries/:cca2" [cca2] (country cca2))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
