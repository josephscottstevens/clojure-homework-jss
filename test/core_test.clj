(ns core-test
  (:require [clojure.test :refer :all]))

(def test-value
  "\nTestLastName|TestFirstName|TestGender|TestFavoriteColor|10/10/2000")

; (deftest data-exists
;   (testing "Verify path is point to a file with contents")
;   ()
;   )

; Use a mock file, not a real file.


; (deftest gender-test
;   (testing "Test that files can be read and sorted via Gender"
;     (is (>= (count (core/read-with-sort :gender)) 300))))

; (deftest birthdate-test
;   (testing "Test that files can be read and sorted via Birth Date"
;     (is (>= (count (core/read-with-sort :date-of-birth)) 300))))

; (deftest last-name-test
;   (testing "Test that files can be read and sorted via Last Name"
;     (is (>= (count (core/read-with-sort :last-name)) 300))))

; (deftest append-test
;   (testing "Test that files can be read and sorted via Last Name"
;     (is (= (file/append test-value) nil))))