(ns clojure-homework-jss.core
  (:require [clojure.java.io :as io]))

(def x
  (with-open [rdr (io/reader "./resources/data.txt")]
    (doall (line-seq rdr))))

(defn -main
  "Reads file from command line, and prints to screen"
  [& args]
  (println x))