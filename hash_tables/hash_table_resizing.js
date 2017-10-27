//Hash Table with Resizing

//Cheap Hashing Function
var hashFunction = function(str, max) {
  var hash = 0;
  for (var i = 0; i < str.length; i++) {
    hash = (hash << 5) + hash + str.charCodeAt(i);
    hash = hash & hash;
    hash = Math.abs(hash);
  }
  return hash % max;
}

var hashTableResizing = function() {
  var result = {};
  var storage = [];
  var storageLimit = 4;
  var size = 4;

  var resizing = false;
  var resize = function(newSize) {
    if(!resizing) {
      resizing = true;
      var pairs = [];
      for (var i = 0; i < storage.length; i++) {
        if (!storage[i]) { continue; }
        for (var j = 0; j < storage[j].length; j++) {
          if (!storage[i][j]) { continue; }
          pairs.push(storage[i][j]);
        }
      }
      storageLimit = newSize;
      storage = [];
      size = 0;
      for (var k = 0; k < pairs.length; k++) {
        result.insert(pairs[k][0], pairs[k][1]);
      }
      resizing = false;
    }
  };

  result.insert = function(key, value) {
    var index = hashFunction(key, storageLimit);
    storage[index] = storage[index] || [];
    var pairs = storage[index];
    var pair;
    var replaced = false;

    for (var i = 0; i < pairs.length; i++) {
      pair = pairs[i];
      if (pair[0] === key) {
        pair[1] = value;
        replaced = true;
      }
    }

    if (!replaced) {
      pairs.push([key, value]);
      size++;
    }

    if (size >= storageLimit * 0.75) {
      resize(storageLimit * 2);
    }
  };

  result.retrieve = function(key) {
    var index = hashFunction(key, storageLimit);
    var pairs = storage[index];
    if (!pairs) { return; };
    var pair;

    for (var i = 0; i < pairs.length; i++) {
      pair = pairs[i];
      if (pair && pair[0] === key) {
        return pair[1];
      }
    }
  };

  result.remove = function(key) {
    var index = hashFunction(key, storageLimit);
    var pairs = storage[index];
    var pair;

    for (var i = 0; i < pairs.length; i++) {
      pair = pairs[i];
      if (pair[0] === key) {
        var value = pair[1];
        delete pairs[i];
        size--;
        if (size <= storageLimit * 0.25) {
          resize(storageLimit / 2);
        }
        return value;
      }
    }
  }
  return result;
};
