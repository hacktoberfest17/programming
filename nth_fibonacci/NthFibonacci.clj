; define N as 15
(def N 15)

; define a function that returns a lazy sequence of fibonacci numbers
(def lazy-fib
	(fn
		([] (lazy-fib 1 1))
		([a b]
			(lazy-seq
				(cons a
				(lazy-fib b (+ a b)))))))

; get the last element from a sequence of N fibonacci numbers
(last (take N (lazy-fib)))

; example of how to run this program
; 1. obtain clojure files (zip) from https://clojure.org/community/downloads
; 2. extract the zipped files and move clojure-1.x.0.jar to your dev directory,
;    where x is a version number
; 3. place this clj file in your dev directory
; 4. open Terminal and cd to your dev directory
; 5. enter the following line to start the clojure REPL (replace x)
;     java -cp clojure-1.x.0.jar clojure.main
; 6. You should see the following in Terminal (it's the REPL!)
;     Clojure 1.x.0
;     user=>
; 7. Enter the following text to run this file
;     (load-file "NthFibonacci.clj")
; 8. If N is kept at 15, the output should be 610
