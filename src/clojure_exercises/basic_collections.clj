(ns clojure-exercises.basic-collections)

(defn get-second-element [my-list]
  (first (rest my-list))
  )

(defn add-to-vector [my-vector]
  (let [last-element (last my-vector)
        plus-one (+ last-element 1)]
    (conj my-vector plus-one)
    ))

(defn get-a-surname [my-map first-name]
  (let [new-map (assoc (merge my-map {:julie "bellm" :cas "connor"}) :ben "connor")]
    (first-name new-map)
    ))

(defn count-unique-vals [my-map]
  (let [list-values (vals my-map)
        set-values (set list-values)]
    (count set-values)
    ))

(defn -main []
  (let [my-list '(1 2 3 4)
        my-vector [1 2 3 4]
        my-map {:chloe "connor", :joe "bellm"}]
    (println (get-a-surname my-map :chloe))
    (println (count-unique-vals my-map))
    (println (get-second-element my-list))
    (println (add-to-vector my-vector))
    ))