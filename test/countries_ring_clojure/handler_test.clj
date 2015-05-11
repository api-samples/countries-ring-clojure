(ns countries-ring-clojure.handler-test
  (:require [clojure.data.json :as json]
            [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [countries-ring-clojure.handler :refer :all]))

(deftest test-app
  (testing "get details of Finland, including capital"
    (let [response (app (mock/request :get "/countries/FI"))]
      (is (= (:status response) 200))
      (is (= (get (json/read-str (:body response)) "capital") "Helsinki"))))

  (testing "not-found country"
    (let [response (app (mock/request :get "/countries/nonexistent"))]
      (is (= (:status response) 404))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
