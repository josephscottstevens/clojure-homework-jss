(ns api
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :refer [response]]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
            [cheshire.core :refer :all]
            [core]))

(defn- to-json
  "any data to json"
  [items]
  (generate-string items {:date-format "MM/dd/yyyy"}))

(defroutes app-routes
  (POST "/records"  [data] (core/append-to-file data))
  (GET "/hello-world" [] (response {:msg "hello-world"}))
  (GET "/records/gender" [] (response (to-json (core/read-with-sort :gender))))
  (GET "/records/birthdate" [] (to-json (core/read-with-sort :birthdate)))
  (GET "/records/name" [] (to-json (core/read-with-sort :last-name))))

(def app (->
          app-routes
          (wrap-json-body {:keywords? true :bigdecimals? true})
          (wrap-json-response)))