(ns clojure-exercises.living-clojure.training-plan.week-two
  (:require [clojure.set :as s]
            [clojure.string :as str]))

(defn fib-seq
  ([n]
   (fib-seq n [1 1]))
  ([n vec]
   (if (> (count vec) n)
     vec
     (recur n
            (conj vec (+ (nth vec (- (count vec) 2))
                         (last vec) ))))))

(println fib-seq 4)

(defn numbers-up-to
  ([n]
   (numbers-up-to n [0]))
  ([n vec]
   (if (> (count vec) n)
     (sort vec)
     (recur (- n 1)
            (conj vec (- n 1)))
     )))

(println (numbers-up-to 5))

(defn upper-case? [char]
  (= (str/upper-case char) (str char)))

(defn no-punctuation [string]
  (str/replace string (re-pattern "[, .!?\\\\-]") ""))

(defn get-caps [string]
  (let [characters (seq (char-array (no-punctuation string)))]
  (reduce (fn [x y] (str x y)) (filter upper-case? characters))))

(println (reduce (fn [x y] (str x y)) (get-caps "HeLlO, WoRlD!")))

(println (= (get-caps "HeLlO, WoRlD!") "HLOWRD"))