(ns application.date-helpers
  (:require [clojure.test :refer :all]
            [rest-api.application.date-helpers :as date]
            [clj-time.core :as t]
            ))

(deftest parse-test
  (testing "Test that valid date can be constructed"
    (is (not (nil? (date/parse "10/10/2000"))))
    (is (nil? (date/parse "1/zy/2000")))
    (is (nil? (date/parse "")))
    (is (nil? (date/parse "a")))))

(deftest un-parse-test
  (testing "Test that valid date can be constructed"
    (is (not (nil? (date/un-parse (t/date-time 1986 10 14 4 3 27 456)))))
    (is (not (nil? (date/un-parse (t/date-time 1986 10 14)))))
    (is (nil? (date/un-parse "1/zy/2000")))
    (is (nil? (date/un-parse "")))
    (is (nil? (date/un-parse "a")))))
