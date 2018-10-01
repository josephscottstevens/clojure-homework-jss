(ns core-test
  (:require [clojure.test :refer :all]
            [rest-api.application.core :as core]))

(deftest read-and-sort-records
  (testing 
    "Test that files can be read and sorted via
     Gender, birthdate and name
    "
    (is (>= (count (core/read-and-sort-records :gender)) 1))
    (is (>= (count (core/read-and-sort-records :birthdate)) 1))
    (is (>= (count (core/read-and-sort-records :name)) 1))))