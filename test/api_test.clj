(ns api-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [rest-api.routes :as api]))

; testing 200 status code
; test returns json
; test json is array
; test each field
; test date format is correct

; POST, only write if format is correct

;TODO, view https://github.com/ring-clojure/ring-mock for cleaner test

(defn test-ok-json
  [request-type path]
  (testing "tests response returns status of ok, and json response"
  (let [response (api/routes (mock/request :get "/records/gender"))]
      (is (= (:status response) 200))
      (is (= (get-in response [:headers "Content-Type"]) "application/json")))))

(deftest test-get-gender
  (test-ok-json :get "/records/gender")
  (testing "users endpoint"
    (let [response (api/routes (mock/request :get "/records/gender"))]
      (is (= (:status response) 200))
      (is (= (get-in response [:headers "Content-Type"]) "application/json")))))

(deftest test-birth-date
  (test-ok-json :get "/records/birthdate")
  (testing "users endpoint"
    (let [response (api/routes (mock/request :get "/records/birthdate"))]
      (is (= (:status response) 200))
      (is (= (get-in response [:headers "Content-Type"]) "application/json")))))


; (deftest test-birth-date
;   (testing "users endpoint"
;     (let [response (api/app (mock/request :get "/records/birthdate"))]
;       (is (= (:status response) 200))
;       (is (= (get-in response [:headers "Content-Type"]) "application/json; charset=utf-8")))))

; (deftest test-name
;   (testing "users endpoint"
;     (let [response (api/app (mock/request :get "/records/name"))]
;       (is (= (:status response) 200))
;       (is (= (get-in response [:headers "Content-Type"]) "application/json; charset=utf-8")))))

; (deftest test-post
;   (testing "users endpoint"
;     (let [response (api/app (mock/request :post "/records"))]
;       (is (= (:status response) 200))
;       (is (= (get-in response [:headers "Content-Type"]) "application/json; charset=utf-8")))))