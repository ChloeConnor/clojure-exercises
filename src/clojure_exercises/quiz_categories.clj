(ns clojure-exercises.quiz-categories)

(def categories-list '(:history, :geography, :art-lit, :sport, :science+nat, :entertainment))

(def people-list '(:julie :mark :cas :ben :chloe :joe))

(def order '(1 2 3 4 5 6 7))

(defn -main []
  (let [shuffle-cats (shuffle categories-list)
        shuffle-people (shuffle people-list)]
    (println (zipmap shuffle-people shuffle-cats))
    (println (zipmap order (conj shuffle-people :john))))
  )