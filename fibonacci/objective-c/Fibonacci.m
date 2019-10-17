//
//  Fibonacci.m
//  fibo
//
//  Created by Piotr Bogdan on 30/10/2018.
//  Copyright © 2018 Piotr Bogdan. All rights reserved.
//

#import "Fibonacci.h"

@implementation Fibonacci

- (int)iterativeNth: (int) num {
    if (num == 0 || num == 1) {
        return 1;
    }
    int fibo = 1;
    int helper = 0;
    for (int i = 0; i < num; ++i) {
        int swap = fibo;
        fibo = helper;
        helper = swap;
        fibo += helper;
    }
    return fibo;
}

- (int)recursiveNth: (int) num {
    if (num == 0 || num == 1) {
        return 1;
    } else {
        return [self recursiveNth: (num -1)] + [self recursiveNth: (num - 2)];
    }
}

@end

