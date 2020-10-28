//Implementing Doubly LinkedList in JavaScript

function Node(data){
    this.prev = null;
    this.data = data;
    this.next = null;
}

function LinkedList(){
    this.head = null;
}

LinkedList.prototype.add = function(data){
    if(this.head === null){
        this.head = new Node(data);
    }else{
        var newNode = new Node(data);
        newNode.next = this.head;
        this.head.prev = newNode;
        this.head = newNode;
    }
}


LinkedList.prototype.size = function(){
    var current = this.head;
    var count = 0;
    while(current !== null){
        current = current.next;
        count++;
    }

    return count;
}

LinkedList.prototype.contains = function(data){
    var current = this.head;

    while(current !== null){
        if(current.data === data){
            return true;
        }
        current = current.next;
    }
    return false;
}

LinkedList.prototype.append = function(data){
    var current = this.head;

    while(current.next !== null){
        current = current.next;
    }

    var newNode = new Node(data);
    current.next = newNode;
    newNode.prev = current;
}

LinkedList.prototype.remove = function(){

    this.head = this.head.next;
    this.head.prev = null;

}

var list = new LinkedList();

list.add(10);
list.add(20);
list.add(30);
list.append(40);
list.remove();
console.log(list.contains(40));
console.log(list.size());
console.log(list);