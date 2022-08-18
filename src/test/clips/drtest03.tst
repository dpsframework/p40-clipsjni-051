(unwatch all)
(clear)
(set-strategy depth)
(open "Results//drtest03.rsl" drtest03 "w")
(dribble-on "Actual//drtest03.out")
(batch "drtest03.bat")
(dribble-off)
(load "compline.clp")
(printout drtest03 "drtest03.bat differences are as follows:" crlf)
(compare-files "Expected//drtest03.out" "Actual//drtest03.out" drtest03)
; close result file
(close drtest03)