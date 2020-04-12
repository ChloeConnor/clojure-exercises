(ns clojure-exercises.living-clojure.fundamentals.state-and-concurrency)

;Atom Synchronous Uncoordinated
;Ref Synchronous Coordinated
;Agent Asynchronous Uncoordinated


(def glass-atom (atom :empty))

(defn fill-up [state]
  (case state
    :empty :half-full
    :half-full :full
    :full))

(println (swap! glass-atom fill-up))


(def fullness (ref 0))
(def pour-water (ref 7))

(defn pour-some-water []
  (dosync (when (pos? @pour-water)
            (alter pour-water dec)
            (alter fullness #(+ % 5)))))
(let [n 1]
  (future (dotimes [_ n] (pour-some-water)))
  (future (dotimes [_ n] (pour-some-water)))
  (future (dotimes [_ n] (pour-some-water))))

(println @fullness)
(println @pour-water)

;agent will only process one action at a time
(def pint-agent (agent :empty))

(println @(send pint-agent fill-up))

