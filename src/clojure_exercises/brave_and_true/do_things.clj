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
  "expects a seq of maps with a :name and :size:"
  (for [body-part body-parts]
    (if (str/includes? (:name body-part) "left")
      (get-left-and-right body-part)
      body-part)))

(println (symmetrize-body-parts body-parts))


(defn get-right [body-part]
  (if (str/includes? (:name body-part) "left")
    (str/replace body-part "left" "right")
    body-part))


(defn symmetrize-body-parts-with-reduce [body-parts-input]
  "expects a seq of maps with a :name and :size:"
  (reduce (fn [output-body-parts part]
            (into output-body-parts (set [part (get-right part)])))
          []
          body-parts-input))

(println (symmetrize-body-parts-with-reduce body-parts))

(defn count-sheep [up-to]
(loop [iteration 1]
  (println (str iteration " sheep"))
  (if (> iteration (- up-to 1))
    (println "that's all the sheep")
    (recur (inc iteration)))))

(count-sheep 4)