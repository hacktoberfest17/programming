// The use case for this is when you want to have a general function that
// fetches from an API, and you want the argument to be the path to the
// resource, rather than a key.
// But the return type should be inferred properly through this path.
// I wanted to avoid having the path to the resource as the key
// in the type mapping, so I just made it so the keys are shared.
interface SomeType {
  a: number;
}

interface OtherType {
  b: number;
}

// This contains the map of possible values that the function can take
// Note that this MUST be const (all values readonly) to work.
const pathMap = {
  someResource: "/v1/some_resource",
  otherType: "/v1/other_resource",
} as const;

// This is the map that maps the keys in the table above
type PathTypes = {
  someResource: SomeType;
  otherType: OtherType;
};

// Create some basic types
type PathMap = typeof pathMap;
type PathValues = PathMap[keyof PathMap];

type AllValues<T extends Record<PropertyKey, any>> = {
  [P in keyof T]: { key: P; value: T[P] };
}[keyof T];

// This will create a map that has the value as the key and the key as the value
type InvertPaths = {
  [P in AllValues<PathMap>["value"]]: Extract<
    AllValues<PathTypes>,
    { key: Extract<AllValues<PathMap>, { value: P }>["key"] }
  >["value"];
};

// This function will take a path and fetch data, and will correctly
// resolve the correct type depending on the path
function pathFetch<T extends PathValues, M = InvertPaths[T]>(arg: T): M {
  // Implementation is irrelevant here so it is left out
  return {} as M;
}

// Auto completion works just as intended,
// you can either take the path from the pathMap, or enter it directly
// In this case, both a and a2 will be of type SomeType
const a = pathFetch(pathMap.someResource);
const a2 = pathFetch("/v1/some_resource");

// In this case, b will be of type OtherType
const b = pathFetch(pathMap.otherType);

// This is not allowed, because the given path is not specified in the pathMap
const a3 = pathFetch("/v1/some_resource2");

// Note that in the function calls above, the type of the values "pathMap.someType" and
// "pathMap.otherType" are strings.
// That means, the return type is not inferred directly from the argument, but is
// resolved with the key of the argument found in "pathMap"
