(ns tonal.midi
  "https://github.com/tonaljs/tonal/tree/master/packages/midi"
  (:require [tonal.interop :as interop]
            [clj-polyglot.js :as poly-js]
            [clj-polyglot.core :as poly]))

(def ^:private members
  [:toMidi
   :midiToFreq
   :midiToNoteName
   :freqToMidi])

(def ^:private api
  (delay
   (poly-js/import @interop/Tonal :Midi members)))

(defn- execute [path & args]
  (apply poly/eval @api path args))

(defn to-midi [note]
  (execute :toMidi note))

(defn midi-to-freq
  ([note]
   (midi-to-freq note 440))
  ([note tuning]
   (execute :midiToFreq note tuning)))

(defn midi-to-note-name
  [midi]
  (execute :midiToNoteName midi))

(defn freq-to-midi
  [freq]
  (execute :freqToMidi freq))
