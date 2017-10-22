//Hashtable implementation in Javascript

var  hash = (string,max)=>{
    var hash = 0;
    for(let i = 0;i<string.length;i++){
        hash += string.charCodeAt(i);
    }
    return hash%max;
}

const HashTable = function(){
    this.storage = [];
    this.storageLimit = 4;

    this.print = ()=>{
        console.log(this.storage);
    }
    this.add = (key,value)=>{
        const index = hash(key,this.storageLimit);
        if(this.storage[index] === undefined){
            this.storage[index] = [[key,value]];
        }else{
            var inserted  = false;
            for(let i = 0;i<this.storage[index].length;i++){
                if(this.storage[index][i][0] === key){
                    this.storage[index][i][1] = value;
                    inserted = true;
                }

                if(inserted === false){
                    this.storage[index].push([key,value]);
                }
            }
        }
    }

    this.lookUp = (key)=>{
        const index = hash(key,this.storageLimit);
        if(this.storage[index] === undefined){
            return "Not found";
        }else{
            for(let i = 0;i<this.storage[index].length;i++){
                if(this.storage[index][i][0] === key){
                    return this.storage[index][i];
                }else{
                    return "Not entry found";
                }
            }
        }
    }

    this.remove = (key)=>{
        const index = hash(key,this.storageLimit);
        if(this.storage[index] === undefined){
            return false;
        }else{
            for(let i = 0;i<this.storage[index].length;i++){
                if(this.storage[index][i][0] === key){
                    delete this.storage[index][i];
                }
            }
        }
    }

}


var setH = new HashTable();
setH.add('sam','js');
setH.add('ben','java');
setH.add('123','php');
setH.add('abra','Dexter');
setH.remove('sam');
console.log(setH.lookUp('am'));
setH.print();
