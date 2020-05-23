(ns tonal.chord
  "https://github.com/tonaljs/tonal/tree/master/packages/chord"
  (:refer-clojure :exclude [get reduced])
  (:require [tonal.interop :as interop]))

(def ^:private members
  [:getChord
   :get
   :detect
   :transpose
   :chordScales
   :extended
   :reduced])

(def ^:private api
  (delay
   (interop/import (interop/Tonal) :Chord members)))

(defn- execute [path & args]
  (apply interop/execute @api path args))

(defn get-chord
  ([type]
   (get-chord type nil nil))
  ([type tonic]
   (get-chord type tonic nil))
  ([type tonic root]
   (execute [:getChord] type tonic root)))

(defn get [name]
  (execute [:get] name))

(defn detect [notes]
  (execute [:detect] notes))

(defn transpose
  [chord-name interval-name]
  (execute [:transpose] chord-name interval-name))

(defn chord-scales
  [chord-name]
  (execute [:chord-scales] chord-name))

(defn extended [chord]
  (execute [:extended] chord))

(defn reduced [chord]
  (execute [:reduced] chord))
