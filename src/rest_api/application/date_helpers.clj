(ns rest-api.application.date-helpers
  (require [clj-time.format :as f]))

(def custom-formatter (f/formatter "dd/MM/YYYY"))

(defn parse
  "Parses string from dd/MM/yyyy form into java date object"
  [date-string]
  (try  
    (.parse
     (java.text.SimpleDateFormat. "dd/MM/yyyy")
     date-string)
  (catch Exception e nil)))

(defn un-parse
  "Un-Parses string from dd/MM/yyyy form into date object"
  [date-string]
  (try (f/unparse custom-formatter date-string) (catch Exception e nil)))