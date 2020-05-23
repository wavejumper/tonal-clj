(ns tonal-test
  (:require [clojure.test :refer :all]
            [tonal.midi :as midi]))

(deftest basic-interop
  (is (= (midi/midi-to-freq 60)
         261.6255653005986)))
