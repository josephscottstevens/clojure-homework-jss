(ns rest-api.routes
  (:require [compojure.core :refer [GET POST defroutes context]]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [ring.util.json-response :refer [json-response]]
            [rest-api.application.core :as core]))

(defroutes routes
  (GET "/records/gender" [] (json-response (core/read-and-sort-records :gender)))
  (GET "/records/birthdate" [] (json-response (core/read-and-sort-records :birthdate)))
  (GET "/records/name" [] (json-response (core/read-and-sort-records :name)))
  (POST "/records" [data] (json-response (core/append-to-file-if-valid data)))
  )