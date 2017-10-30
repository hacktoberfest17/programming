// identity functor
const Box = x =>
({
  map: f => Box(f(x)),
  fold: f => f(x),
  inspect: () => `Box(${x})`
})

//useage
const nextCharForNumberString = str =>
  Box(str)
  .map(s => s.trim())
  .map(r => parseInt(r))
  .map(i => i + 1)
  .map(i => String.fromCharCode(i))
  .fold(c => c.toLowerCase())

const basicBox = nextCharForNumberString('  64 ')
console.log(basicBox)

/***********************/
// enforce null checks with code spliting
const Right = x =>
({
  map: f => Right(f(x)),
  fold: (f, g) => g(x),
  inspect: () => `Right(${x})`
})

const Left = x =>
({
  map: f => Left(x),
  fold: (f, g) => f(x),
  inspect: () => `Left(${x})`
})

const fromNullable = x =>
  x != null ? Right(x) : Left(null)

const findColor = name =>
  fromNullable({red: '#ff4444', blue: '#3b5998', yellow: '#fff68f'}[name])

const codeSplit = findColor('blue')
            .map(c => c.slice(1))
            .map(c => c.toUpperCase())
            .fold(e => 'no color', x => x)
console.log(codeSplit)

/************************/
// Semi-Groups
const Sum = x =>
({
  x,
  concat: ({x: y}) =>
    Sum(x + y),
  inspect: () =>
    `Sum(${x})`,
  toString: () =>
    `Sum(${x})`
})

//const res = Sum(1).concat(Sum(2))

const All = x =>
({
  x,
  concat: ({x: y}) =>
    All(x && y),
  inspect: () =>
    `All(${x})`,
  toString: () =>
    `All(${x})`
})

//const res = All(false).concat(All(true))

const First = x =>
({
  x,
  concat: _ =>
    First(x),
  inspect: () =>
    `First(${x})`,
  toString: () =>
    `First(${x})`
})

const semiGroups = First("blah").concat(First("ice cream")).concat(First('meta programming'))
console.log(semiGroups)

/****************************************/
// failsafe combination using monoids

Sum.empty = () => Sum(0)

All.empty = () => All(true)


const sum = xs =>
  xs.reduce((acc, x) => acc + x, 0)

const all = xs =>
  xs.reduce((acc, x) => acc && x, true)

const first = xs =>
  xs.reduce((acc, x) => acc)

console.log(first([1,2,3]))
