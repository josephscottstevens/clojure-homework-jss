(ns api
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [cheshire.core :refer :all]
            [core]))

(defroutes app
  (POST "/records" [] (resp/file-response (str "index.html")))
  (GET "/records/gender" [] (generate-string (core/read-with-sort :gender)))
  (GET "/records/birthdate" [] (generate-string (core/read-with-sort :birthdate)))
  (GET "/records/name" [] (generate-string (core/read-with-sort :name))))
