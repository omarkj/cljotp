(ns cljotp.core
  (:import (java.util Date))
  (:require (cljotp (crypto :as crypto))))

(declare get-timestamp)

(defn get-hotp
  "Get a one time token based on a secret and a
  interval number."
  [secret interval]
  (println secret "Hello, World!"))

(defn get-totp
  "Get a one time token based on the time."
  [secret]
  (let [interval (int (/ (get-timestamp (.getTime (Date.))) 30))]
    (get-hotp secret interval)))

(defn get-timestamp
  "Convert milliseconds since epoch to a Unix Timestamp"
  [milliseconds]
  ((int (/ milliseconds 1000))))