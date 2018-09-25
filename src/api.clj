(ns api
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [core]))

(defroutes app
  (GET "/" [] (resp/file-response (str "index.html")))
  (GET "/test" [] "<h1>test</h1>")
  (GET "/test2" [] (str (core/read-file "data.txt" :first-name)))
  (route/resources "/")
  (route/not-found "<h1>Page not found</h1>"))
