(ns clojure-exercises.living-clojure.training-plan.week-one
  (:require [clojure.set :as s]
            [clojure.test :refer :all]
            [clojure.string :as str]))

(println (= [:a :b :c]
            (list :a :b :c)
            (vec '(:a :b :c))
            (vector :a :b :c)))

(println (= (set '(:a :b :c :d))
            (set '(:a :a :b :c :c :c :c :d :d)))
         (= (set '(:a :b :c :d))
            (s/union #{:a :b :c} #{:b :c :d})))

(testing "equals 8" (is (= 8 ((fn add-five [x] (+ x 5)) 3))))
(= 8 ((fn [x] (+ x 5)) 3))
(= 8 (#(+ % 5) 3))
(= 8 ((partial + 5) 3))

(println (count (re-seq #"joe" "how many joes in joe")))

(println (= '(5 4 3 2 1) ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5)))

(println (sort-by str/upper-case (str/split (str/replace "Have a nice day." "." "") #" ")))
(println (= (sort (str/split "have a nice day" #" "))
            ["a" "day" "have" "nice"]))

(println (= (reduce (fn [x y] (+ x y)) (list 0 -2 5 5)) 8))

(println (= (filter odd? #{1 2 3 4 5}) '(1 3 5)))

(println (take 5 (iterate #(+ 3 %) 1)))
(println (= '(1 4 7 10 13) (take 5 (iterate #(+ 3 %) 1))))

(defn duplicate-list [list number-of-times]
   (sort (flatten (take number-of-times (iterate conj list)))))

(println (= (duplicate-list [1 2 3] 2) '(1 1 2 2 3 3)))