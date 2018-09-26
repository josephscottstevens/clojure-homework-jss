(defproject compojure-example "0.1.0-SNAPSHOT"
  :description "Homework for Guarenteed Rate"
  :url "http://localhost:3000/"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [cheshire "5.8.1"]
                 [clj-time "0.14.4"]
                 [ring/ring-json "0.4.0"]
                 [ring/ring-mock "0.3.2"]]
  :plugins [[lein-ring "0.8.11"]]
  :ring {:handler api/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
