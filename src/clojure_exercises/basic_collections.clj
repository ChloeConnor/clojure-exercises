(ns clojure-exercises.basic-collections
  (:require [clojure-exercises.remove-letters :as rl]))

(defn get-second-element [my-list]
  (first (rest my-list))
  )

(defn add-to-vector [my-vector]
  (let [last-element (last my-vector)
        plus-one (+ last-element 1)]
    (conj my-vector plus-one)
    ))

(defn get-a-surname [people-map first-name]
  (let [new-map (assoc (merge people-map {:julie "bellm" :cas "connor"}) :ben "connor")]
    (first-name new-map)
    ))

(defn connor? [people-map first-name]
  (= (get-a-surname people-map first-name) "connor"))

(defn what-family [first-name people-map]
  (let [surname (get-a-surname people-map first-name)]
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

(defn chloe [people-map]
  ((partial what-family :chloe) people-map))

(defn count-unique-vals [people-map]
  (let [list-values (vals people-map)
        set-values (set list-values)]
    (count set-values)
    ))

(defn -main []
  (let [my-list '(:chloe :joe :ben :cas :john)
        my-vector [1 2 3 4]
        people-map {:chloe "connor", :joe "bellm"}
        another-people-map {:chloe "bellm", :joe "bellm"}
        partner-map {:chloe :joe, :cas :john, :julie :mark}]
    (println (get-a-surname people-map :chloe))
    (println (count-unique-vals people-map))
    (println (get-second-element my-list))
    (println (add-to-vector my-vector))
    (println (connor? people-map :chloe))
    (println (chloe another-people-map))
    (println (what-family :chloe people-map))
    (println (find-relationship :cas partner-map))
    ))