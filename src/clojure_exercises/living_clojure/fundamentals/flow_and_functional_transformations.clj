(ns clojure-exercises.living-clojure.fundamentals.flow-and-functional-transformations
  (:require [clojure-exercises.living-clojure.fundamentals.basic-collections :as bc])
  (:require [clojure.string :as cs]))

(defn connor? [people-map first-name]
  (= (bc/get-a-surname people-map first-name) "connor"))

(defn what-family [first-name people-map]
  (let [surname (bc/get-a-surname people-map first-name)]
    (cond
      (= surname "bellm") "Bellm family"
      (= surname "connor") "Connor family"
      :else "Not a Connor or a Bellm"
      ))
  )

(defn in-a-relationship-with [first-name]
  (str "You are in a relationship with " first-name)
  )

(defn what-partner [first-name partner-map]
  (first-name partner-map)
  )

(defn find-relationship [first-name partner-map]
  ((comp in-a-relationship-with what-partner) first-name partner-map)
  )

(defn get-some-random-numbers [how-many]
  (let [take-number (* how-many 3)]
    (take take-number (cycle (take how-many (repeatedly #(rand-int 10)))))
    ))

(defn chloe-family [people-map]
  ((partial what-family :chloe) people-map))

(defn get-full-name [names-list people-map]
  (map  #(str (cs/replace % ":" "") " " (people-map %)) names-list)
  )

(defn -main []
  (let [people-map {:chloe "connor", :joe "bellm"}
        another-people-map {:chloe "bellm", :joe "bellm"}
        partner-map {:chloe :joe, :cas :john, :julie :mark}
        names-list '(:chloe :joe)]
    (println (connor? people-map :chloe))
    (println (chloe-family another-people-map))
    (println (what-family :chloe people-map))
    (println (find-relationship :cas partner-map))
    (println (get-some-random-numbers 3))
    (println (get-full-name names-list people-map))
    ))