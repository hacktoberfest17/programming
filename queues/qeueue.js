function Queue(){
	this.dataStore = [];
	this.enqueue = enqueue;
	this.dequeue = dequeue;
	this.front = front;
	this.back = back;
	this.toString = toString;
	this.empty = empty;
}
function enqueue(element){
	this.dataStore.push(element);
}
function dequeue(){
	return this.dataStore.shift();
}
function front(){
	return this.dataStore[0];
}
function back(){
	return this.dataStore[this.dataStore.length - 1];
}
function toString(){
	var retStr = "";
	for(var i = 0; i < this.dataStore.length; ++i){
		retStr += this.dataStore[i] + ", ";
	}retStr += "\n";
	return retStr;
}
function empty(){
	if(this.dataStore.length == 0){
		return true;
	}else{
		return false;
	}
}
var q = new Queue();
q.enqueue("One");
q.enqueue("Two");
q.enqueue("Three");
print(q.toString());
q.dequeue();
print(q.toString());
print("Front of queue: "+q.front());
print("Back of queue: "+q.back());

function print(Data){
	console.log(Data);
}