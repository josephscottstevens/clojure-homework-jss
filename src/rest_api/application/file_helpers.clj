(ns rest-api.application.file-helpers
  (:require [clojure.string :as string]))

(def file-path "./resources/data.txt")

(def load-resource
  "Loads file from resources folder"
  (slurp file-path))

(def load-resource-into-string-array
  "Loads file from resources folder,
   and then splits text into rows
  "
  (string/split load-resource #"\r\n"))

(defn append
  "Appends text row into the live data text file"
  [string-row]
  (spit file-path (str "\n" string-row) :append true))