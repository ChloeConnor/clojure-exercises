(ns clojure-exercises.core)

(defn add-three-numbers [one, two, three]
  (+' one two three))

(defn print-greeting [name, apples]
  (let [new (apply str "Hello " name ", here's " apples " apples!")]
  (println new)))

(defn -main
  []
  (let [apples (add-three-numbers 1 2 3)]
  (print-greeting  "Chloe" apples)))
