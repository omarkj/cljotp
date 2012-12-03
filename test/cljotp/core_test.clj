(ns cljotp.core-test
  (:use clojure.test
        cljotp.core))

(deftest test-hotp
  (testing "HOTP code generation"
    (is (= 765705 (get-hotp "MFRGGZDFMZTWQ2LK" 1)))
    (is (= 816065 (get-hotp "MFRGGZDFMZTWQ2LK" 2)))))