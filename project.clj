(defproject wavejumper/tonal "3.6.5-4"
  :description "Clojure API into the JavaScript tonal library"
  :url "https://github.com/wavejumper/tonal-clj"

  :dependencies
  [[org.clojure/clojure "1.10.1"]
   [wavejumper/clj-polyglot "1.0.0"]]

  :uberjar {:prep-tasks  ["clean" "compile"]}

  :compile-path
  "target"

  :test-paths
  ["test"]

  :resource-paths
  ["resources"]
  
  :jvm-opts
  ["-XX:+UnlockExperimentalVMOptions" "-XX:+EnableJVMCI"]

  :source-paths
  ["src"])
