(ns core
  (:require [clojure.java.io :as io]
            [clojure.string :as string]
            [clj-time.format :as f]))

(defn parse-date
  "Parses string from dd/MM/yyyy form into java date object"
  [date-string]
  (.parse
   (java.text.SimpleDateFormat. "dd/MM/yyyy")
   date-string))

(defn toRecord [str]
  (def strArray
    (string/split str #"[ \|,]"))
  {:first-name (nth strArray 0)
   :last-name (nth strArray 1)
   :gender (nth strArray 2)
   :favorite-color (nth strArray 3)
   :date-of-birth (parse-date (nth strArray 4))})

(defn read-file
  [file-name]
  (with-open [rdr (io/reader (str "./resources/" file-name))]
    (doall
     (map toRecord
          (drop 1
                (line-seq rdr))))))

(defn read-with-sort
  [sort-field]
  (sort-by sort-field
           (into []
                 (concat
                  (read-file "data.txt")
                  (read-file "data2.txt")
                  (read-file "data3.txt")))))



(defn append-to-file
  "Uses spit to append to a file specified with its name as a string, or
   anything else that writer can take as an argument. string-param is the string to
   append."
  [string-param]
  (spit "./resources/data.txt" (str string-param) :append true))