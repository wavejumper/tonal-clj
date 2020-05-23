(ns tonal.interop
  (:refer-clojure :exclude [import])
  (:require [clojure.java.io :as io])
  (:import (org.graalvm.polyglot Context Source Value)
           (org.graalvm.polyglot.proxy ProxyArray ProxyObject)))

;; https://medium.com/graalvm/graalvms-javascript-engine-on-jdk11-with-high-performance-3e79f968a819
;; https://github.com/graalvm/graal-js-jdk11-maven-demo/blob/master/src/main/java/com/mycompany/app/App.java

(def ^String tonal-src
  (slurp (io/resource "tonal.min.js")))

(def js
  (delay
   (let [ctx (-> (Context/newBuilder (into-array String ["js"]))
                 (.allowExperimentalOptions true)
                 (.option "js.experimental-foreign-object-prototype" "true")
                 (.build))
         src (.build (Source/newBuilder "js" tonal-src "src.js"))]
     (.eval ctx src)
     ctx)))

(defn warmup! []
  (deref js)
  true)

(defn ^Value Tonal []
  (let [ctx      ^Context @js
        bindings (.getBindings ctx "js")]
    (.getMember bindings "Tonal")))

(defn import
  [^Value tonal api-name members]
  (let [member (.getMember tonal (name api-name))]
    (into {}
          (map (fn [f]
                 [f (.getMember member (name f))]))
          members)))

(defn parse-result
  [^Value result]
  (cond
    (.isNumber result)
    (try (.asInt result)
         (catch Throwable _ (.asDouble result)))

    (.isString result)
    (.asString result)

    (.hasArrayElements result)
    (let [n (.getArraySize result)]
      (into [] (map (fn [idx]
                      (parse-result (.getArrayElement result idx)))
                    (range 0 n))))
    :else
    result))

(defn serialize-arg [arg]
  (cond
    (map? arg)
    (ProxyObject/fromMap arg)

    (coll? arg)
    (ProxyArray/fromArray (into-array Object arg))

    :else
    arg))

(defn execute
  [api path & args]
  (let [value (get-in api path)]
    (let [result (.execute ^Value value (into-array Object (map serialize-arg args)))]
      (parse-result result))))
