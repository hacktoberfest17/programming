#lang racket

(define prime?                         ;define global
  (lambda (x)
    (letrec ((is-prime?                ;declare local that can call itself
      (lambda (x n)
        (if (= (remainder x n) 0)      ;divisable by current n?
          #f                           ;not prime
          (or                          ;checked enoghe or check again?
            (> n (sqrt x))             ;checked engohe
            (is-prime? x (+ n 1))))))) ;check again
      (case x                          ;handle exceptions to algorthim
        ((0) #f)                       ;numbers that is-prime? breaks on
        ((1) #f)
        ((2) #t)
        (else (is-prime? x 2))))))     ;check from 2 to (sqrt x)

(define factorize
    (lambda (n)
    (cond
      [(not (integer? n)) (printf "The parameter must be an integer\n")]
      [(<= n 0) (printf "The integer must be possitive\n")]
      [else (factorize-function n 2 0 '() ) ] )))

(define factorize-function
    (lambda (n curr-prime times R)
      (cond
          [(> curr-prime n) (if (> times 0)                                 ; if the prime is greater than the number is an end condition
                                (append R (list(list curr-prime times)))    ; when the exponent counter is greater than 0, we must add a factor
                                R) ]                                        ; if not, the result is complete
          [(not (prime? curr-prime))                                        ; if the number received as prime isn't, use the next one
           (factorize-function n (+ 1 curr-prime) 0 R)]
          [(zero? (remainder n curr-prime))                                 ; if the remainder is 0, try again with this prime
           (factorize-function (/ n curr-prime) curr-prime (+ times 1) R) ]
          [else                                                             ; if the remainder isn't 0
           (if (> times 0)                                                  ; if it has been divided more than once, add it to the result
               (factorize-function n (+ 1 curr-prime) 0 (append R (list(list curr-prime times))))  
               (factorize-function n (+ 1 curr-prime) 0 R ) ) ] )))         ; else continue with the next number


(factorize 17)
(factorize 5460)
(factorize 50)
(factorize "Error")

