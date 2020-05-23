# tonal-clj

Clojure wrapper library into the excellent [tonal](https://github.com/tonaljs/tonal) JavaScript library.

> tonal is a music theory library. Contains functions to manipulate tonal elements of music (note, intervals, chords, scales, modes, keys). It deals with abstractions (not actual music or sound).

This is possible via [GraalVM's JavaScript engine](https://medium.com/graalvm/graalvms-javascript-engine-on-jdk11-with-high-performance-3e79f968a819)

# Usage

The wrapper library should work with on the JVM with JDK11+ with by adding the following `:jvm-opts`:

```
["-XX:+UnlockExperimentalVMOptions" "-XX:+EnableJVMCI"]
```

```clojure
(require '[tonal.midi :as midi])

(midi/midi-to-freq 60)
;; => 261.6255653005986
```

