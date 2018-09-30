(ns rest-api.application.core
  (:require [rest-api.application.parse :as parse]
            [rest-api.application.file-helpers :as file]
            [rest-api.application.validation :as validation]))

(defn read-and-sort-records
  "Loads contents from disk
   formats text
   maps to a vector of records
   then sorts by atom reference
  "
  [sort-field]
    (sort-by sort-field
      (into []
        parse/load-records)))

(defn append-to-file-if-valid
  "If string can be converted into valid record
   append record to disk
   otherwise, nil
  "
  [string-param]
  (if (validation/record-string? string-param)
    (file/append string-param)
    "Error occurred, please try again later or check your format"))