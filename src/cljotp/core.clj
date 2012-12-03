(ns cljotp.core
  (:import (java.util Date)
           (java.nio ByteBuffer))
  (:require (cljotp (crypto :as crypto))))

(declare get-timestamp)

(defn get-hotp
  "Get a one time token based on a secret and a
  interval number."
  [secret interval]
  (let [secret (crypto/decode-base32 secret)
        data (.array (.putLong (ByteBuffer/allocate 8) interval))
        digest (crypto/sha_mac secret data)
        offset (bit-and (digest 19) 0xf)
        code (bit-or (bit-shift-left (bit-and (digest offset) 0x7f) 24)
                     (bit-shift-left (bit-and (digest (+ offset 1)) 0xff) 16)
                     (bit-shift-left (bit-and (digest (+ offset 2)) 0xff) 8)
                     (bit-and (digest (+ offset 3)) 0xff))]
      (rem code 1000000)))
  
(defn get-totp
  "Get a one time token based on the time."
  [secret]
  (let [interval (int (/ (get-timestamp (.getTime (Date.))) 30))]
    (get-hotp secret interval)))

(defn get-timestamp
  "Convert milliseconds since epoch to a Unix Timestamp"
  [milliseconds]
  (int (/ milliseconds 1000)))