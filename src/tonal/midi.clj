(ns tonal.midi
  "https://github.com/tonaljs/tonal/tree/master/packages/midi"
  (:require [tonal.interop :as interop]))

(def ^:private members
  [:toMidi
   :midiToFreq
   :midiToNoteName
   :freqToMidi])

(def ^:private api
  (delay
   (interop/build-api (interop/Tonal) :Midi members)))

(defn- execute [path & args]
  (apply interop/execute @api path args))

(defn to-midi [note]
  (execute [:toMidi] note))

(defn midi-to-freq
  ([note]
   (midi-to-freq note 440))
  ([note tuning]
   (execute [:midiToFreq] note tuning)))

(defn midi-to-note-name
  [midi]
  (execute [:midiToNoteName] midi))

(defn freq-to-midi
  [freq]
  (execute [:freqToMidi] freq))
