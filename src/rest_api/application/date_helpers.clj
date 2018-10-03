(ns rest-api.application.date-helpers)

(defn parse
  "Parses string from dd/MM/yyyy form into java date object"
  [date-string]
  (try  
    (.parse
     (java.text.SimpleDateFormat. "dd/MM/yyyy")
     date-string)
  (catch Exception e nil)))

(defn un-parse
  "Parses java date object into M/D/YYYY string"
  [date]
  (.format 
    (java.text.SimpleDateFormat. "MM/dd/yyyy")
    date))