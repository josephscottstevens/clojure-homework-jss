(ns application.validation
  (:require [clojure.test :refer :all]
            [rest-api.application.validation :as validation]))

(deftest record-fields?
  (testing
   "Validates string has 5 non blank fields
    as there are five fields in the record
   "
    (is (true? (validation/record-fields? "a|b|d|e|f")))
    (is (false? (validation/record-fields? "abcd")))
    (is (nil? (validation/record-fields? nil)))))

(deftest record-delimited?
  (testing
   "validate string containts 4 delimiters
    as there are five fields in the record
   "
    (is (true? (validation/record-delimited? "a|b|d|e|f")))
    (is (false? (validation/record-delimited? "a|b|d|e")))
    (is (nil? (validation/record-delimited? nil)))
    ))

(deftest record-string?
  (testing
   "Validates string can be converted to record"
    ; (is (true? (validation/record-string? "a|b|d|e|f")))
    (is (false? (validation/record-string? "abcd")))
    ; (is (nil? (validation/record-string? nil)))
    ))