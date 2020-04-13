(ns clojure-exercises.quiz-categories)

(def categories-list-1 '(:history, :geography, :art-lit, :sport, :science+nat, :entertainment))
(def categories-list-2 '(:famous-people, :music, :food-and-drink, :general-knowledge, :anagrams, :business :places))

(def people-list '(:julie :mark :cas :ben :chloe :joe :john))

(def order '(1 2 3 4 5 6 7))

(defn -main []
  (let [shuffle-cats (shuffle categories-list-2)
        shuffle-people (shuffle people-list)]
    (println (zipmap shuffle-people shuffle-cats))
    (println (zipmap order  shuffle-people))))