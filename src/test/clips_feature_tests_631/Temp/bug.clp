(defmodule MAIN
   (export ?ALL))

(deffunction MAIN::problem (?p0))

(deffunction MAIN::problem
   (?x))

(defmodule M
   (import MAIN ?ALL)
   (export ?ALL))

