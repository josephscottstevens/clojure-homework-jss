(ns rest-api.routes
  (:require [compojure.core :refer [GET POST defroutes context]]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [ring.util.json-response :refer [json-response]]
            [rest-api.application.core :as core]
            [rest-api.application.parse :as parse]))

(def records (atom []))

(defn post-record
  [data]
  (println (str "|!" data))
  (swap! records conj (parse/string-to-record data))
  "record added successfully")

(defroutes routes
  (GET "/records/gender" [] (json-response (map parse/parse-date (sort core/by-gender-descending-and-last-name @records))))
  (GET "/records/birthdate" [] (json-response (map parse/parse-date (sort-by :birthdate @records))))
  (GET "/records/name" [] (json-response (map parse/parse-date (sort core/by-last-name-descending @records))))
  (POST "/records" request (post-record (slurp (:body request))))
  (route/not-found "Route not found"))