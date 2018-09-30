(ns rest-api.application.date-helpers)

(defn parse
  "Parses string from dd/MM/yyyy form into java date object"
  [date-string]
  (try  
    (.parse
     (java.text.SimpleDateFormat. "dd/MM/yyyy")
     date-string)
  (catch Exception e nil)))