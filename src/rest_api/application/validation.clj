(ns rest-api.application.validation
  (:require [clojure.string :as string]))

(defn record-fields?
  "Validates string has 5 non blank fields
   as there are five fields in the record
  "
  [string-param]
  (if (nil? string-param)
    nil
    (<= 9 (count string-param))))

(defn record-delimited?
  "validate string containts 4 delimiters
   as there are five fields in the record
  "
  [string-param]
  (if (nil? string-param)
    nil
    (if (= 4 (count (re-seq #"[ \|,]" string-param))) true false)))

(defn record-string?
  "Validates string can be converted to record"
  [string-param]
  (if (nil? string-param)
    nil
    (every? true? [(record-delimited? string-param) (record-fields? string-param)])))