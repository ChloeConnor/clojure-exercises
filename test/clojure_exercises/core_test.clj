(ns clojure-exercises.core-test
  (:require [clojure.test :refer :all]
            [clojure-exercises.core :refer :all]
            [clojure-exercises.living-clojure.basic-collections :as bc]))

(deftest test-second-element
  (let [list '(1 2 4)
        second-elem (bc/get-second-element list)]
    (testing "Test second element is 2" (is (= second-elem 2)))))