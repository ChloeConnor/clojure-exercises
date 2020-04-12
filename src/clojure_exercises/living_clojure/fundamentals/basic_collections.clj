(ns clojure-exercises.living-clojure.fundamentals.basic-collections)

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

(defn count-unique-vals [people-map]
  (let [list-values (vals people-map)
        set-values (set list-values)]
    (count set-values)
    ))

(defn -main []
  (let [my-list '(:chloe :joe :ben :cas :john)
        my-vector [1 2 3 4]
        people-map (hash-map :chloe "connor", :joe "bellm")]
    (println (get-a-surname people-map :chloe))
    (println (count-unique-vals people-map))
    (println (get-second-element my-list))
    (println (add-to-vector my-vector))
    (println (get people-map :cas :default))
    ))