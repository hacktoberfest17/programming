#lang racket

(define (isPalindrome str)
  (string=? (list->string (reverse (string->list str))) str))
