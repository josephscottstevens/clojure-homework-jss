(ns application.parse
  (:require [clojure.test :refer :all]
            [rest-api.application.parse :as parse]))

(def test-user
  { :first-name "Clark"
    :last-name "Bennett"
    :gender "M"
    :favorite-color "indigo"
    :birthdate (.parse (java.text.SimpleDateFormat. "dd/MM/yyyy") "05/02/2018")
  })

(deftest parse-date
  (testing "validate users birthdate is now formatted correctly for display"
    (is (= "02/05/2018" ((parse/parse-date test-user) :birthdate)))))

(deftest parse-record
  (testing "Validate vector of strings can be parsed into record"
   (is (= test-user (parse/parse-record ["Clark" "Bennett" "M" "indigo" "05/02/2018"])))))

(deftest string-to-record
  (testing "Validate string can be parsed into record via all three delimiters"
    (is (= test-user (parse/string-to-record "Clark|Bennett|M|indigo|05/02/2018")))
    (is (= test-user (parse/string-to-record "Clark,Bennett,M,indigo,05/02/2018")))
    (is (= test-user (parse/string-to-record "Clark Bennett M indigo 05/02/2018")))
    ))