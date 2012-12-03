(ns cljotp.crypto
  (:import (org.apache.commons.codec.binary Base32)
           (javax.crypto.spec SecretKeySpec)
           (javax.crypto Mac)))

(defn sha_mac
  "Return the SHA1 MAC digest for a given key and data"
  [secret, data]
  (let [spec (SecretKeySpec. secret "HmacSHA1")
        sha-mac (let [mac (Mac/getInstance "HmacSHA1")]
                  (.init mac spec)
                  mac)
        hash (into [] (.doFinal sha-mac data))]
    hash))

(defn decode-base32
  "Decode a base32 string to binary."
  [string]
  (.decode (Base32.) string))