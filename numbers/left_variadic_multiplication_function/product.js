// Write a function that returns the product of the parameters

function product(...args) {
  return args.reduce(
    (product, val) => product *
      (Array.isArray(val) ?
        val.reduce((product, val) => product * val, 1) :
        val), 1);

}

module.exports = product;