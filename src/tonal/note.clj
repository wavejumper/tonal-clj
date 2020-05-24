(ns tonal.note
  "https://github.com/tonaljs/tonal/tree/master/packages/note"
  (:require [tonal.interop :as interop]
            [clj-polyglot.core :as poly]
            [clj-polyglot.js :as poly-js]))

(def ^:private members
  [:midi
   :freq
   :accidentals
   :transpose
   :pitchClass
   :octave
   :chroma
   :fromMidi
   :fromMidiSharps
   :transposeFrom
   :transposeFifths
   :names
   :sortedNames
   :simplify
   :enharmonic])

(def ^:private api
  (delay
   (poly-js/import @interop/Tonal :Note members)))

(defn- execute [path & args]
  (apply poly/eval @api path args))

(defn midi
  [note]
  (execute :midi note))

(defn freq
  [note]
  (execute :freq note))

(defn accidentials [note]
  (execute :accidentals note))

(defn transpose [note]
  (execute :transpose note))

(defn pitch-class [note]
  (execute :pitch-class note))

(defn from-midi [note]
  (execute :fromMidi note))

(defn from-midi-sharps [note]
  (execute :fromMidiSharps note))

(defn transpose-from [note]
  (execute :transposeFrom note))

(defn transpose-fifths [note]
  (execute :transposeFifths note))

(defn names [xs]
  (execute :names xs))

(defn sorted-names [xs]
  (execute :sortedNames xs))

(defn simplify [note]
  (execute :simplify note))

(defn enharmonic [note]
  (execute :enharmonic note))
