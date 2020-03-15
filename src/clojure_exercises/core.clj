(ns clojure-exercises.core)

(defrecord Person [first-name last-name])

(defn add-three-numbers [one, two, three]
  (+' one two three))

(defn print-greeting [greeting, name, apples]
  (
    let [new (apply str greeting " " name ", here's " apples " apples!")]
    (println new)
    ))

(defn add-element-to-list [list]
  (conj list "hi" "hello"))

(defn -main []
  (
    let [apples (add-three-numbers 1 2 3),
         chloe-person (Person. "chloe" "connor")
         greeting (first (add-element-to-list ["yo"]))]
    (print-greeting greeting (:first-name chloe-person) apples)))

