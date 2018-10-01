(ns api-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [clojure.data.json :as json]
            [rest-api.routes :as api]))

(defn test-ok-json
  [request-type path]
  (testing "tests response returns status of ok, and json response"
  (let [response (api/routes (mock/request request-type path))]
      (is (= (:status response) 200))
      (is (= (get-in response [:headers "Content-Type"]) "application/json")))))

(defn test-record-list
  [request-type path]
  (testing
   "Validates a vector of results is returned
    Validates map at index 0 contains the key first-name
    Validates map at index 0 contains the key last-name
    Validates map at index 0 contains the key gender
    Validates map at index 0 contains the key favorite-color
    Validates map at index 0 contains the key birthdate
    Note: Not checking values since all values are optional and nil is valid
    "
    (let [response (api/routes (mock/request request-type path))]
      (is (vector? (json/read-str (:body response))))
      (is (contains? (first (json/read-str (:body response))) "first-name"))
      (is (contains? (first (json/read-str (:body response))) "last-name"))
      (is (contains? (first (json/read-str (:body response))) "gender"))
      (is (contains? (first (json/read-str (:body response))) "favorite-color"))
      (is (contains? (first (json/read-str (:body response))) "birthdate"))))
  )

(deftest test-get-gender
  (test-ok-json :get "/records/gender")
  (test-record-list :get "/records/gender"))

(deftest test-get-name
  (test-ok-json :get "/records/name")
  (test-record-list :get "/records/name"))

(deftest test-get-birthdate
  (test-ok-json :get "/records/birthdate")
  (test-record-list :get "/records/birthdate"))

(deftest test-post
  (test-ok-json :post "/records"))