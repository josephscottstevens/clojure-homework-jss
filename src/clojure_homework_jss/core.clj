(ns clojure-homework-jss.core
  (:require [clojure.java.io :as io]))


(defn -main
  "Reads file from command line, and prints to screen"
  [& args]
  (with-open [rdr (io/reader "./resources/data.txt")]
    (doseq [line (line-seq rdr)]
      (println line))))