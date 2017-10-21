var a = [ 9, 10, 2, 1, 5, 4, 3, 6, 8, 7, 13 ];

function swap(a, i, j) {
    var tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
}

function max_heapify(a, i, length) {
    while (true) {
        var left = i*2 + 1;
        var right = i*2 + 2;
        var largest = i;

        if (left < length && a[left] > a[largest]) {
            largest = left;
        }

        if (right < length && a[right] > a[largest]) {
            largest = right;
        }

        if (i == largest) {
            break;
        }

        swap(a, i, largest);
        i = largest;
    }
}

function heapify(a, length) {
    for (var i = Math.floor(length/2); i >= 0; i--) {
        max_heapify(a, i, length);
    }
}

function heapsort(a) {
    heapify(a, a.length);

    for (var i = a.length - 1; i > 0; i--) {
        swap(a, i, 0);

        max_heapify(a, 0, i-1);
    }
}

heapsort(a);
