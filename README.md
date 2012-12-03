Cljotp
======

Generate one time passwords, HOTPs and TOTPs for your application.
Should work with the Google Authenticator.

Clojure API
-----------

Get a HTOP based on a interval number

``` clojure
(get-hotp secret, interval)
```

Get a TOTP based on the time

``` clojure
(get-totp secret)
```

The secret needs to be a base32 encoded secret key!

Licence
-------

Check the `LICENCE` file.
