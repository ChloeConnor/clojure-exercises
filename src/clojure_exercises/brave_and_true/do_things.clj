(ns clojure-exercises.brave-and-true.do-things
  (:require
    [clojure.string :as str]))

(defn get-first [[first-item second-item & others]]
  (str "first item: " first-item ", second item: " second-item ", other items: " (str/join ", " others)))

(println (get-first ["apple", "orange", "pineapple", "mango"]))



(def body-parts [{:name "head" :size 3}
                 {:name "left-eye" :size 1}
                 {:name "left-foot" :size 2}
                 {:name "teeth" :size 1}])

(defn get-left-and-right [left-body-part]
  (list left-body-part (str/replace left-body-part "left" "right")))

(defn symmetrize-body-parts [body-parts]
  (for [body-part body-parts]
    (if (str/includes? (:name body-part) "left")
      (get-left-and-right body-part)
      body-part)))

(println (symmetrize-body-parts body-parts))
