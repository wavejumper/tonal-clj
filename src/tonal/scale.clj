(ns tonal.scale
  "https://github.com/tonaljs/tonal/tree/master/packages/scale"
  (:refer-clojure :exclude [get reduced])
  (:require [interop :as interop]))

(def ^:private members
  [:names
   :get
   :scaleChords
   :extended
   :reduced
   :scaleNotes
   :modeNames])

(def ^:private api
  (delay
   (interop/build-api (interop/Tonal) :Scale members)))

(defn- execute [path & args]
  (apply interop/execute @api path args))

(defn names []
  (execute [:names]))

(defn scale-chords [scale]
  (execute [:scaleChords] scale))

(defn extended [scale]
  (execute [:extended] scale))

(defn reduced [scale]
  (execute [:reduced] scale))

(defn scale-notes [notes]
  (execute [:scaleNotes] notes))

(defn modes [name]
  (execute [:modeNames] name))
