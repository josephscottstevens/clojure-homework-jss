(ns clojure-homework-jss.core
  (:require [clojure.java.io :as io]))

(defn toRecord [str]
  [str])

(def x
  (with-open [rdr (io/reader "./resources/data.txt")]
    (doall (map toRecord (line-seq rdr)))))

(defn -main
  "Reads file from command line, and prints to screen"
  [& args]
  (println x))