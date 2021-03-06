[![Clojars Project](https://img.shields.io/clojars/v/wavejumper/tonal.svg)](https://clojars.org/wavejumper/tonal)
[![CircleCI](https://circleci.com/gh/wavejumper/tonal-clj.svg?style=svg)](https://circleci.com/gh/wavejumper/tonal-clj)


# tonal-clj

Clojure (JVM) bindings into the excellent [tonal](https://github.com/tonaljs/tonal) library.

> tonal is a music theory library. Contains functions to manipulate tonal elements of music (note, intervals, chords, scales, modes, keys). It deals with abstractions (not actual music or sound).

This is possible via [GraalVM's JavaScript engine](https://github.com/wavejumper/clj-polyglot)

# Usage

Requires JDK11+ or a graalvm runtime

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
