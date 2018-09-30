(ns application.date-helpers
  (:require [clojure.test :refer :all]
            [rest-api.application.date-helpers :as date]
            ))

(deftest parse-test
  (testing 
   "Test that valid date can be constructed
    Test that invalid dates cannot be constructed
   "
    (is (not (nil? (date/parse "10/10/2000"))))
    (is (nil? (date/parse "1/zy/2000")))
    (is (nil? (date/parse "")))
    (is (nil? (date/parse "a")))))