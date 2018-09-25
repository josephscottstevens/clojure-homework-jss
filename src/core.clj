(ns core
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(defn toRecord [str]
  (def strArray
    (string/split str #"[ \|,]"))
  {:first-name (nth strArray 0)
   :last-name (nth strArray 1)
   :gender (nth strArray 2)
   :favorite-color (nth strArray 3)
   :date-of-birth (nth strArray 4)})

(defn read-with-sort
  [sortField]
  (sort-by sortField
           (into []
                 (concat
                  (read-file "data.txt")
                  (read-file "data2.txt")
                  (read-file "data3.txt")))))


(defn read-file
  [fileName]
  (with-open [rdr (io/reader (str "./resources/" fileName))]
    (doall
     (map toRecord
          (drop 1
                (line-seq rdr))))))