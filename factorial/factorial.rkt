#lang racket

(define (factorial n)
  (if (= n 1)
      1
      (* n (factorial (sub1 n)))))
