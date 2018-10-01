(defproject compojure-example 
  "0.2.0"
  :description "Homework for Guarenteed Rate"
  :url "http://localhost:3000/"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [cheshire "5.6.3"]
                 [compojure "1.5.1"]
                 [org.clojure/data.json "0.2.6"]
                 [ring/ring-defaults "0.2.1"]
                 [ring/ring-json "0.4.0"]
                 [ring-json-response "0.2.0"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler rest-api.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
