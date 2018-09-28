(ns rest-api.application.parse
  (:require [clojure.string :as string]
            [rest-api.application.date-helpers :as date]
            [rest-api.application.file-helpers :as file]))

(defn to-record
  "takes a vector of strings
   then maps to record based on index
   (if not a vector, returns nil)
  "
  [array-param]
    (if (vector? array-param)
      {:first-name (nth array-param 0)
      :last-name (nth array-param 1)
      :gender (nth array-param 2)
      :favorite-color (nth array-param 3)
      :date-of-birth (date/parse (nth array-param 4))}
      nil
      ))

(defn split-string
  "takes a string
   splits into vector by space, comma or pipe
  "
  [string-param]
  (if (string? string-param)
    (string/split string-param #"[ \|,]")
    nil))

(defn string-to-record
  "takes a string
   splits into vector by space, comma or pipe
   maps to a record
  "
  [string-param]
  (to-record (split-string string-param)))

(def load-records
  "Loads contents from disk
   formats text
   maps to a vector of records
  "
  (into []
    (map string-to-record file/load-resource-into-string-array)))