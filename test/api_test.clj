(ns api-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [api]))

; (deftest test-app
;   (testing "users endpoint"
;     (let [response (api/app (mock/request :get "/records/gender"))]
;       (is (= (:status response) 200))
;       (is (= (get-in response [:headers "Content-Type"]) "application-json")))))

(deftest test-app
  (testing "users endpoint"
    (let [response (api/app (mock/request :get "/hello-world"))]
      (is (= (:status response) 200))
      (is (= (get-in response [:headers "Content-Type"]) "application-json")))))

