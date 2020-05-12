(ns clojure-exercises.quiz-categories)

(def categories-list-1 '(:history, :geography, :art-lit, :sport, :science+nat, :entertainment))
(def categories-list-2 '(:famous-people, :music, :food-and-drink, :general-knowledge, :anagrams, :business :places))
(def categories-list-3 '(:technology, :films, :netflix-series, :song-lyrics, :who-am-I, :acronyms :world-wars))
(def categories-list-4 '(:films, :geography, :music, :food-and-drink))

(def people-list '("julie" "mark" "cas" "ben" "chloe" "joe" "john"))
(def friends-list '("janet" "izzy" "ani" "chloe"))

(defn allocate-categories [people categories]
  (let [shuffled-categories (shuffle categories)]
    (zipmap people shuffled-categories))
  )

(defn order-people [people]
  (let [people-ordered (shuffle people)]
  (zipmap (range 1 (+ (count people) 1)) people-ordered )))
  
(println (allocate-categories friends-list categories-list-4))
(println (order-people people-list))
