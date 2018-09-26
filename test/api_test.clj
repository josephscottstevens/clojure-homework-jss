(ns api-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [api]))

(deftest test-app
  (testing "users endpoint"
    (let [response (api/app (mock/request :get "/records/gender"))]
      (is (= (:status response) 200))
      (is (= (get-in response [:headers "Content-Type"]) "application/json; charset=utf-8")))))

(deftest test-birth-date
  (testing "users endpoint"
    (let [response (api/app (mock/request :get "/records/birthdate"))]
      (is (= (:status response) 200))
      (is (= (get-in response [:headers "Content-Type"]) "application/json; charset=utf-8")))))

(deftest test-name
  (testing "users endpoint"
    (let [response (api/app (mock/request :get "/records/name"))]
      (is (= (:status response) 200))
      (is (= (get-in response [:headers "Content-Type"]) "application/json; charset=utf-8")))))

(deftest test-post
  (testing "users endpoint"
    (let [response (api/app (mock/request :post "/records"))]
      (is (= (:status response) 200))
      (is (= (get-in response [:headers "Content-Type"]) "application/json; charset=utf-8")))))