(ns clojure-exercises.living-clojure.java-interop-and-polymorphism)


(def chloe (String. "chloe"))
(println (.toUpperCase chloe))

(def joe-doto
  (doto (StringBuffer. "Joe")
    (.append " Bellm")
    (.toString)))
(println joe-doto)


(defn what-am-i [input]
  (let [class (class input)]
    (cond
      (= String class) "I'm a string"
      (= Integer class) "I'm a number"
      :else "No idea")))

(println (what-am-i "Chloe"))


(defmulti what-are-you class)
(defmethod what-are-you String [input]
  (str input ", you're a string"))
(defmethod what-are-you Long [input]
  (str input ", you're a long"))
(defmethod what-are-you :default [input]
  (str input ", I don't know what you are"))

(println (what-are-you "Chloe"))
(println (what-are-you 6))
(println (what-are-you true))

(defprotocol Eat
  (eat-lemons [this])
  (eat-chicken [this]))

(defrecord Person [name age]
  Eat
  (eat-lemons [this]
    (str "I ate lemons, they were tasty!"))
  (eat-chicken [this]
    (str "I ate chicken, nom!")))

(defrecord Cat [name age colour]
  Eat
  (eat-lemons [this]
    (str "I ate lemons, they were sour!"))
  (eat-chicken [this]
    (str "I ate chicken, it was yummy!")))

(def joe (Person. "Joe" 25))
(def joe-cat (Cat. "Joe" 8 "purple"))
(def doris (Cat. "Doris" 3 "black-and-ginger"))

(defn tell-me-more [you eat]
  (str "I'm " (.-name you) " and I'm " (.-age you) " years old. " (eat you)))

(println (tell-me-more joe eat-chicken))
(println (tell-me-more doris eat-lemons))
(println (tell-me-more joe-cat eat-chicken))