#lang racket

(define (linearSearch arr ele)
  (local [(define (helper arr index)
            (cond [(empty? arr) -1]
                  [else
                   (if (equal? (first arr) ele)
                       index
                       (helper (rest arr) (add1 index)))]))]
  (helper arr 0)))
