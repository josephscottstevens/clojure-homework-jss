(ns api-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [rest-api.application.parse :as parse]
            [cheshire.core :refer :all]
            [rest-api.routes :as api]))

(defn test-ok-json
  [request-type path]
  (testing "tests response returns status of ok, and json response"
  (let [response (api/routes (mock/request request-type path))]
      (is (= (:status response) 200))
      (is (= (get-in response [:headers "Content-Type"]) "application/json")))))

(deftest test-api
  "validating new record can be posted, ignoring validating dates as I could not figure it out"
  ; smoke test get routes
  (test-ok-json :get "/records/name")
  (test-ok-json :get "/records/birthdate")
  (test-ok-json :get "/records/gender")
  ; post three users, verify each has been posted
  (let [response (api/routes (-> (mock/request :post "/records")
                                 (mock/body "Adam|Smith|M|Red|05/02/2018")))]
    (is (= "record added successfully" (:body response))))
  (let [response (api/routes (-> (mock/request :post "/records")
                                 (mock/body "Jane|Doe|F|Blue|01/01/2000")))]
    (is (= "record added successfully" (:body response))))
  (let [response (api/routes (-> (mock/request :post "/records")
                                 (mock/body "Jane|Stevens|F|Green|02/02/1990")))]
    (is (= "record added successfully" (:body response))))
  
  ; verify each endpoint is returning sorted records correctly
  (testing "Testing gender route returns sorted records"
    (let [response (api/routes (mock/request :get "/records/gender"))]
      (is (= "Jane" ((first (parse-string (:body response) true)) :first-name)))))
  
  (testing "Testing birthdat route returns sorted records"
    (let [response (api/routes (mock/request :get "/records/birthdate"))]
      (is (= "Jane" ((first (parse-string (:body response) true)) :first-name)))))
  
  (testing "Testing name route returns sorted records"
    (let [response (api/routes (mock/request :get "/records/name"))]
      (is (= "Jane" ((first (parse-string (:body response) true)) :first-name)))))
  
  (testing "Bad Route returns route not found"
    (let [response (api/routes (mock/request :get "/unknownroute"))]
      (is (= "Route not found" (:body response))))))