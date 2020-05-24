(ns tonal.interop
  (:require [clojure.java.io :as io]
            [clj-polyglot.js :as poly.js]))

;; https://medium.com/graalvm/graalvms-javascript-engine-on-jdk11-with-high-performance-3e79f968a819
;; https://github.com/graalvm/graal-js-jdk11-maven-demo/blob/master/src/main/java/com/mycompany/app/App.java

(def ^String tonal-src
  (slurp (io/resource "tonal.min.js")))

(def Tonal
  (delay
   (let [ctx (poly.js/js-ctx tonal-src)]
     (poly.js/require ctx "Tonal"))))

(defn warmup! []
  (deref Tonal)
  true)