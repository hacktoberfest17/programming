#lang racket

(define (fibonacci n)
  (cond [(zero? n) 0]
        [(or (= n 1) (= n 2)) 1]
        [else (+ (fibonacci (- n 1)) (fibonacci (- n 2)))]))
