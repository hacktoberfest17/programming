class PriorityQueue {
  constructor(data = []) {
    this.data = data;
  }

  push(element, priority) {
    priority = +priority;
    for (let i = 0; i < this.data.length && this.data[i][1] > priority; i++);
    this.data.splice(i, 0, [element, priority]);
  }

  pop() {
    return this.data.shift()[0];
  }

  size() {
    return this.data.length;
  }
}