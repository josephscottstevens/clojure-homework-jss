(ns application.parse
  (:require [clojure.test :refer :all]
            [rest-api.application.parse :as parse]))

(deftest to-record
  (testing 
    "validate records cant be created from nil
     validate records cant be created from a string
     validate records can be created from string array
    "
    (is (nil? (parse/to-record nil)))
    (is (nil? (parse/to-record "a|b|c|d|e")))
    (is (not (nil? (parse/to-record ["Jane","Doe","F","red","12/12/2012"]))))))

(deftest split-string
  (testing
   "validate string can be split from valid data
    validate string split from nil is nil
    validate string split is the correct amount
   "
   (is (vector? (parse/split-string "a|b|c|d|e")))
   (is (nil? (parse/split-string nil)))
   (is (= 5 (count (parse/split-string "a|b|c|d|e"))))))


(deftest string-to-record
  (testing
   "validate records cant be created from nil
    validate records cant be created from an array
    validate records can be created from string
   "
    (is (nil? (parse/string-to-record nil)))
    (is (nil? (parse/string-to-record ["a" "b"])))
    (is (map? (parse/string-to-record "Keane,Rojas,M,orange,05/12/2017")))
   ))


(deftest load-records
  (testing
   "validate records loaded from disk are not nil
    validate records loaded from disk are indeed a list
   "
    (is (not (nil? parse/load-records)))
    (is (vector? parse/load-records))))