class Matrix {
	constructor (source, goal, row, col, numBlocked) {
		const arr = [];
		//blocked nodes cannot be traversed
		const blocked = [];
		const reservedNodes = [source, goal];
		//choose random nodes to be blocked
		for (let n = 0; n < numBlocked; n++) {
			let x = Math.round(Math.random() * (row-1));
			let y = Math.round(Math.random() * (col-1));
			//source and goal cannot be blocked
			while(isIn(reservedNodes, [x, y])) {
				x = Math.round(Math.random() * (row-1));
				y = Math.round(Math.random() * (col-1));
			}
			blocked.push([y, x]);
		}
		for (let i = 0; i < row; i++) {
			arr.push([]);
			arr[i].push(new Array(col));
			for(let j = 0; j < col; j++) {
				if (isIn(blocked, [j, i])) {
					arr[i][j] = 1;
				} else {
					arr[i][j] = 0;
				}
			}
		}
		console.log("Blocked cells:\n[[" + blocked.join("], [") + "]]\n")
		console.log("Matrix:\n[\n[" + arr.join("],\n[") + "]\n]\n")
		return arr;
	}
}

class PriorityQueue {
	constructor (data = []) {
		this.data = data;
	}

	push (element, priority) {
		priority = +priority
		for (var i = 0; i < this.data.length && this.data[i][1] > priority; i++);
		this.data.splice(i, 0, [element, priority])
	}

	pop () {
		return this.data.reverse().shift()[0];
	}

	size () {
		return this.data.length;
	}
}

function isIn (arr1, arr2) {
	const check = JSON.stringify(arr1).indexOf(JSON.stringify(arr2));
	return check !== -1 ? true : false; 
}

// function areEqual (arr1, arr2) {
// 	return JSON.stringify(arr1) === JSON.stringify(arr2);
// }

function neighbors (arr, i, j) {
	const n = [];
	const rowLimit = arr[0].length - 1;
	const colLimit = arr.length - 1;
	if (i+1 <=  rowLimit){
		n.push([i+1, j]);
	}
	if (j+1 <= colLimit){
		n.push([i, j+1]);
	}
	if (i-1 >= 0) {
		n.push([i-1, j]);
	}
	if (j-1 >= 0) {
		n.push([i, j-1]);
	}
	return n;
}

function distance (p1, p2) {
	return Math.sqrt(Math.pow(p1[0]-p2[0], 2) + Math.pow(p1[1]-p2[1], 2));
}

//main path-finding function (A* star algorithm)
function findPath (arr, source, goal) {
	const rows = arr[0].length - 1;
	const cols = arr.length - 1;
	var checked = [];
	var path = [];
	var forChecking = new PriorityQueue();
	path.push(source);
	forChecking.push(source, 0);
	var currNode = forChecking.pop();
	var last = path[path.length - 1]
	while (distance(last, goal) !== 0) {
		var n = neighbors(arr, currNode[0], currNode[1]);
		//num of neighbors is at most 4 lol
		for(let neighbor of n) {
			if (arr[neighbor[1]][neighbor[0]] !== 1 && !isIn(checked, neighbor)) {
				//Use a (reversed) priority queue to push according to distance to goal node		
				forChecking.push(neighbor, distance(neighbor, goal));
			}
		}
		var top = forChecking.pop();
		path.push(top);
		checked.push(currNode);
		currNode = top;
		last = path[path.length - 1];
	}

	return path;
}

//Example
const source = [0, 0];
const goal = [9, 4];
const rows = 5;
const cols = 10;
const blocked = 12;
const m = new Matrix(source, goal, rows, cols, blocked);

console.log("Path found:\n[\n[" + findPath(m, source, goal).join("], \n[") + "]\n]")
