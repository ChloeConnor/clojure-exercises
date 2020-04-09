(ns web-app.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/yay" [] "YAY")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
