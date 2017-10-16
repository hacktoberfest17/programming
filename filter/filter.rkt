#lang racket

;; (X -> Boolean) (listof X) -> (listof X)
(define (list-filter f lox)
  (cond [(empty? lox) empty]
        [else
         (if (f (first lox))
             (cons (first lox) (list-filter f (rest lox)))
             (list-filter f (rest lox)))]))
