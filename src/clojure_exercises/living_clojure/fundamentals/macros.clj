(ns clojure-exercises.living-clojure.macros)

(defn get-greeting [greeting]
  (println (str greeting ", how are you?")))

(defmacro def-hello [person greeting]
  (list 'defn
        (symbol person)
        []
        (list 'get-greeting greeting)))

(println (macroexpand-1 '(def-hello chloe-greeting "I'm Chloe")))

(def-hello chloe-greeting "I'm Chloe")
(def-hello joe-greeting "Yo my name is Joe")

(chloe-greeting)
(joe-greeting)
