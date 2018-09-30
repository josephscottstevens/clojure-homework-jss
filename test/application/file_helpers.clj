(ns application.validation
  (:require [clojure.test :refer :all]
            [clojure.string :as string]
            [rest-api.application.file-helpers :as file]))

(deftest file-path
  (testing
   "validates file exists at path"
    (is (not (string/blank? (slurp file/file-path))))))

(deftest load-resource
  (testing
   "validate file loads at path"
    (is (not (string/blank? load-resource)))))

(deftest load-resource-into-string-array
  (testing
   "validate file loads at path
    validates contents split into array
   "
   (is (not (string/blank? load-resource-into-string-array)))
   (is (vector? load-resource-into-string-array))
   (is (< 1 (count load-resource-into-string-array)))))

(deftest append
  (testing 
    "validate successful write to file location"
    (is (= nil? (file/append "Nasim|Bright|M|blue|15/04/2019")))))