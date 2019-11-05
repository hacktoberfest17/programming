//Implement Binary Search tree in Javascript using Classes (ES6)



function Node(data,left,right){
    this.data = data;
    this.left = left;
    this.right = right;
}

const trace = (curr)=>{
    if(curr.left !== null){
        trace(curr.left);
    }
    if(curr.right !== null){
        trace(curr.right);
    }
}

const append = (curr,data)=>{
    if(data<=curr.data){
        if(curr.left === null){
            curr.left = new Node(data,null,null);
        }else{
            append(curr.left,data);
        }
    }else{
        if(curr.right === null){
            curr.right = new Node(data,null,null);
        }else{
            append(curr.right,data);
        }
    }
}

class BinaryTree{
    constructor(){
        this.root = new Node(null,null,null);
    }

    append(data){
        if(this.root.data === null){
            this.root = new Node(data,null,null);
        }else{
            const curr = this.root;
            append(curr,data);
        }
    }

    trace(){
        if(this.root.data === null){
            return this.root.data;
        }else{
            const curr = this.root;
            trace(curr);
        }
    }
}


const tree = new BinaryTree();
tree.append(10);
tree.append(5);
tree.append(20);
tree.append(6);
tree.append(15);
tree.trace();
console.log(tree);