(ns clojure-exercises.brave-and-true.do-things
  (:require
    [clojure.string :as str]))

(defn get-first [[first-item second-item & others]]
  (str "first item: " first-item ", second item: " second-item ", other items: " (str/join ", " others)))

(println (get-first ["apple", "orange", "pineapple", "mango"]))