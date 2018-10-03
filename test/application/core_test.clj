(ns application.core-test
  (:require [clojure.test :refer :all]
            [rest-api.application.core :as core]))

(def testUsers 
  [{ :first-name "Adam"
     :last-name "Smith"
     :gender "M"
     :favorite-color "Red"
     :birthdate (.parse (java.text.SimpleDateFormat. "dd/MM/yyyy") "05/02/2018")
     }
   { :first-name "Jane"
     :last-name "Doe"
     :gender "F"
     :favorite-color "Blue"
     :birthdate (.parse (java.text.SimpleDateFormat. "dd/MM/yyyy") "01/01/2000")
    }
   {:first-name "Jane"
    :last-name "Stevens"
    :gender "F"
    :favorite-color "Green"
    :birthdate (.parse (java.text.SimpleDateFormat. "dd/MM/yyyy") "02/02/1990")
   }])

(deftest print-files
  (testing "Passing 3 args will run the command line version."
    (is (thrown? java.io.FileNotFoundException (core/print-files ["invalidfilename" "invalidfilename" "invalidfilename"])))
    (is (= :success (core/print-files ["./resources/comma_delimited.txt" "./resources/pipe_delimited.txt" "./resources/space_delimited.txt"])))
    (is (= :invalid-args (core/print-files ["./resources/pipe_delimited.txt" "./resources/space_delimited.txt"])))
    (is (= :invalid-args (core/print-files [])))))

(deftest output-files
  (testing "tests prints sorted records"
    (is (= :success (core/output-files testUsers)))))

(deftest by-gender-descending-and-last-name
  (testing "tests that records are sorted by gender descending, then be last name"
    (is (= "Stevens" ((first (sort core/by-gender-descending-and-last-name testUsers)) :last-name)))
    (is (= "Smith" ((last (sort core/by-gender-descending-and-last-name testUsers)) :last-name)))))

(deftest by-last-name-descending
  (testing "tests that records are sorted by last name"
    (is (= "Stevens" ((first (sort core/by-last-name-descending testUsers)) :last-name)))
    (is (= "Doe" ((last (sort core/by-last-name-descending testUsers)) :last-name)))))

(deftest by-last-name-descending
  (testing "test that file Reads in the then parses to vector of records"
    (is (= testUsers (core/parse-file "./resources/pipe_delimited.txt")))))