//Implementing Linked List and it's method in Javascript (ES5)

function Node(data){
    this.data = data;
    this.next = null;
}

function LinkedList(){
    this._length = 0;
    this.head = null;
}

LinkedList.prototype.isEmpty = function(){
    if(this.head===null){
        return true;
    }else{
        return false;
    }
}

LinkedList.prototype.add = function(data){

    if(!data){
        console.error("No data found");
    }else{
        if(this.head === null){
            this.head = new Node(data);
        }else{
            var newHead = new Node(data);
            newHead.next = this.head;
            this.head = newHead;
        }
    }
    this._length++;
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

LinkedList.prototype.addAt = function(data,where){
    var current = this.head;
    var prev = null;
    var newNode = new Node(data);
    //debugger
    while(current.data !== where){
        prev = current;
        current = current.next;
    }
    //prev.next = newNode;
    //newNode.next = current;
    var something = current.next;
    current.next = newNode;
    newNode.next = something;


}

LinkedList.prototype.append= function(data){
    var current = this.head;
    while(current.next !== null){
        current = current.next;
    }
    current.next = new Node(data);
    this._length++;
}

LinkedList.prototype.delete = function(data){
    var current = this.head;
    var prev = null;
    if(this.head.data === data){
        this.head = this.head.next;
        this._length--;
        return;
    }
    while(current.data !== data){
        prev = current;
        current = current.next;
    }
    prev.next = current.next;
    this._length--;
}
var list = new LinkedList()
list.add(10);
list.add(20);
list.add(30);
list.add(40);
list.append(50);
list.addAt(15,20)
console.log(list.contains(20));
console.log(list)
