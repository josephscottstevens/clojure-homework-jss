(ns rest-api.application.core
  (:require [clojure.string :as str]
            [clojure.pprint :as pp]
            [rest-api.application.parse :as parse]
            [rest-api.application.date-helpers :as date]))

(defn parse-file
  "Reads in the file and then parses to vector of records"
  [file-path]
  (map parse/string-to-record (str/split-lines (slurp file-path))))

(defn by-gender-descending-and-last-name
  [x y]
  (compare [(:gender x) (:last-name y)]
           [(:gender y) (:last-name x)]))

(defn by-last-name-descending
  [x y]
  (compare [(:last-name y)]
           [(:last-name x)]))

(defn output-files
  "Prints sorted and combined records"
  [records]
  (println "Output 1: sorted by gender (females before males) then by last name ascending.")
  (pp/print-table (map parse/parse-date (sort by-gender-descending-and-last-name records)))
  (println "Output 2: sorted by birth date, ascending.")
  (pp/print-table (map parse/parse-date (sort-by :birthdate records)))
  (println "Output 3: sorted by last name, descending.")
  (pp/print-table (map parse/parse-date (sort by-last-name-descending records)))
  :success
  )

(defn print-files
  "Runs application only if three aguments are passed, as defined in spec"
  [args]
  (if (= 3 (count args))
    (output-files (apply concat (map parse-file args)))
    :invalid-args))

(defn -main
  "Start the command line application for homework assessment"
  [& args]
  (print-files args))