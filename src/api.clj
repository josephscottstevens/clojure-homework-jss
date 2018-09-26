(ns api
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [cheshire.core :refer :all]
            [core]))

(defn- to-json
  "any data to json"
  [items]
  (generate-string items {:date-format "MM/dd/yyyy"}))

(defroutes app
  (POST "/records"  [data] (core/append-to-file data))
  (GET "/records/gender" [] (to-json (core/read-with-sort :gender)))
  (GET "/records/birthdate" [] (to-json (core/read-with-sort :birthdate)))
  (GET "/records/name" [] (to-json (core/read-with-sort :last-name))))
