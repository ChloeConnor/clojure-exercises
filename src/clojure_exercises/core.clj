(ns clojure-exercises.core)

(defn print-greeting [name]
  (let [new (apply str "Hello, " name "!")]
  (println new)))

(defn -main
  []
  (print-greeting  "Chloe"))
