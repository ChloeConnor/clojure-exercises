(ns clojure-exercises.remove-letters)

(defn characters-to-remove
  "For a given string of As and Bs find the number of
 characters to be removed so that no adjacent character
 is the same"
  [input]
  (let [with-index (map-indexed vector input),
        mapped (for [x with-index] (if (=  (keys x) "A") 1 0))]
    (loop [y with-index] (println y))
    (println mapped)
    ))
