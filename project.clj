(defproject wavejumper/tonal "3.6.5-0"
  :description "Clojure API into the JavaScript tonal library"
  :url "https://github.com/wavejumper/tonal-clj"

  :dependencies
  [[org.clojure/clojure "1.10.1"]
   [org.graalvm.sdk/graal-sdk "20.0.0"]
   [org.graalvm.js/js "20.0.0"]
   [org.graalvm.js/js-scriptengine "20.0.0"]]

  :uberjar {:prep-tasks  ["clean" "compile"]}

  :compile-path
  "target"

  :resource-paths
  ["resources"]
  
  :jvm-opts
  ["-XX:+UnlockExperimentalVMOptions" "-XX:+EnableJVMCI"]

  :source-paths
  ["src"])
