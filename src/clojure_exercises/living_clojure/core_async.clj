(ns clojure-exercises.living-clojure.core-async
  (:require [clojure.core.async :as async]))

(def food-channel (async/chan 2))

(async/>!! food-channel :steak)
(async/>!! food-channel :chips)

(println (async/<!! food-channel))


(def people-channel (async/chan 2))

(async/go (async/>! people-channel :joe))

(println (async/<!! people-channel))