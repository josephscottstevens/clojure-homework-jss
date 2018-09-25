(ns core
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(defn toRecord [str]
  (def strArray
    (string/split str #"\|"))
  {:first-name (nth strArray 0)
   :last-name (nth strArray 1)
   :gender (nth strArray 2)
   :favorite-color (nth strArray 3)
   :date-of-birth (nth strArray 4)})

(defn read-file
  [fileName sortField]
  (with-open [rdr (io/reader (str "./resources/" fileName))]
    (doall
     (sort-by sortField
              (map toRecord
                   (drop 1
                         (line-seq rdr)))))))

; (defn -main
;   "Reads file from command line, and prints to screen"
;   [& args]
;   (println (read-file "data.txt" :first-name)))