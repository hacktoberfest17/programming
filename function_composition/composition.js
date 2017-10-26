const compose = (...args) => {
    return function (x) {
        return args.reduceRight((acc, val) => {
            return val(acc);
        }, x);
    };
};

// Usage
// -----
// const add = x => y => x + y;
// const odd = x => x % 2 !== 0;
// const isOddAfterAdding2 = compose(odd, add(1), add(1));
// isOddAfterAdding2(12); // false
// isOddAfterAdding2(13); // true
