(ns clojure-homework-jss.core
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(defn toRecord [str]
  (def strArray
    (string/split str #"\|"))
  {:last-name (nth strArray 0)
   :first-name (nth strArray 1)
   :gender (nth strArray 2)
   :favorite-color (nth strArray 3)
   :date-of-birth (nth strArray 4)})

(def read-file
  (with-open [rdr (io/reader "./resources/data.txt")]
    (doall (map toRecord (line-seq rdr)))))

(defn -main
  "Reads file from command line, and prints to screen"
  [& args]
  (println read-file))