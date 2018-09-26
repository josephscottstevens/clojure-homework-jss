(ns api
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [cheshire.core :refer :all]
            [core]))


(defroutes app
  (POST "/records"  [data] (core/append-to-file data))
  (GET "/records/gender" [] (generate-string (core/read-with-sort :gender)))
  (GET "/records/birthdate" [] (generate-string (core/read-with-sort :birthdate)))
  (GET "/records/name" [] (generate-string (core/read-with-sort :name))))
