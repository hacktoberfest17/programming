Basics of Blockchain
---
This is a very simple code to learn about blockchain technology. 
Blockchain is a digital ledger, a public database, in which the transactions made are accessible to all the users in 
the blockchain using it, but is cryptographically secured. This digital ledger is maintained in distributed form. 

Each record is stored in the form of blocks which is linked together to form a long chain of blocks called blockchain. 
Blocks generally includes information about the index of the block in the chain, timestamp of when block was created, 
previous block ie. previous hash, some data (like transactions), etc. The new hash of the block is generated with all 
the information in the block that makes it tamperproof. The hash of the block is distributed in all the nodes in the 
blockchain, thus making sure the integrity of the blocks is maintained and if a block is tampered all the nodes in the 
chain knows it.
```
class Block:
    def __init__(self, index, timestamp, data, previous_hash):
        self._index = index
        self._timestamp = timestamp
        self._data = data
        self._previous_hash = previous_hash
        self._nounce = None
        self._hash = self.hash()
```

This example includes index, timestamp, data, previous_hash, nounce and hash. 

The first block in the blockchain is generated manually or is hardcoded and included in the chain. The initial block is 
called Genesis Block since initial block doesn't have the information of the previous block.
```
def genesis_block():
    return Block(0, time.time(), "This is genesis block", '0')
```
What is mining? 
Mining is to create a valid new block and add it into the blockchain. 

Checking valid block for blockchain:
```
def valid_hash(self, the_hash):
    return the_hash.startswith('0000')
```

In this simple blockchain, we add the blocks with a loop included in the code. To create a new block in blockchain a 
simple task is created, ie. to create a new valid block in blockchain, the hash created must have preceeding 0000 for 
new block, the content of the block is changed by a nounce value which is incremented until the hash of the block does
not have preceeding 0000.

Right now the code works for a machine only. But overview of how a blockchain works should be clear. 