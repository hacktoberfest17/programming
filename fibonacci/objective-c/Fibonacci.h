//
//  Fibonacci.h
//  fibo
//
//  Created by Piotr Bogdan on 30/10/2018.
//  Copyright © 2018 Mobiem. All rights reserved.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface Fibonacci : NSObject

-(int)iterativeNth: (int) num;
-(int)recursiveNth: (int) num;

@end

NS_ASSUME_NONNULL_END
