(ns rest-api.application.parse
  (:require [clojure.string :as string]
            [rest-api.application.date-helpers :as date]))

(defn parse-date
  "updates date field in records map to string format"
  [record]
  (update record :birthdate date/un-parse))

(defn parse-record
  "takes a vector of strings
   then maps to record based on index
   (if not a vector, returns nil)
  "
  [array-param]
  {:first-name (nth array-param 0)
  :last-name (nth array-param 1)
  :gender (nth array-param 2)
  :favorite-color (nth array-param 3)
  :birthdate (date/parse (nth array-param 4))})

(defn string-to-record
  "takes a string
   splits into vector by space, comma or pipe
   maps to a record
  "
  [string-param]
  (parse-record (string/split string-param #"[ \|,]")))