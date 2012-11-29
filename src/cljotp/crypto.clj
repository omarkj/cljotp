(ns cljotp.crypto
  (:import (org.apache.commons.codec.binary Base32)))

(defn decode-base32
  "Decode a base32 string to binary."
  [string]
  (.decode (Base32.) string))