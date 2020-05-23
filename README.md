[![Clojars Project](https://img.shields.io/clojars/v/wavejumper/tonal.svg)](https://clojars.org/wavejumper/tonal)
[![CircleCI](https://circleci.com/gh/wavejumper/tonal-clj.svg?style=svg)](https://circleci.com/gh/wavejumper/tonal-clj)


# tonal-clj

Clojure (JVM) wrapper into the excellent [tonal](https://github.com/tonaljs/tonal) library.

> tonal is a music theory library. Contains functions to manipulate tonal elements of music (note, intervals, chords, scales, modes, keys). It deals with abstractions (not actual music or sound).

This is possible via [GraalVM's JavaScript engine](https://medium.com/graalvm/graalvms-javascript-engine-on-jdk11-with-high-performance-3e79f968a819)

# Usage



The wrapper library should work on the JVM with JDK11+ with the following `:jvm-opts`:

```clojure
["-XX:+UnlockExperimentalVMOptions" "-XX:+EnableJVMCI"]
```

```clojure
(require '[tonal.midi :as midi])

(time (midi/midi-to-freq 60))

;; "Elapsed time: 0.573886 msecs"
;; => 261.6255653005986

```


Refer to the [tonal documentation](https://github.com/tonaljs/tonal#documentation) for more information.
