import time, hashlib, json


"""
Created by trustgeek on 2017-10-23 (11:04).
"""

class Block:
    def __init__(self, index, timestamp, data, previous_hash):
        self._index = index
        self._timestamp = timestamp
        self._data = data
        self._previous_hash = previous_hash
        self._nounce = None
        self._hash = self.hash()

    def valid_hash(self, the_hash):
        return the_hash.startswith('0000')

    def mined(self):
        return self._nounce is not None

    def mine(self):
        start_time = time.time()
        the_nounce = self._nounce or 0
        while True:
            the_hash = self.hash(nonce=the_nounce)
            if self.valid_hash(the_hash):
                self._hash = the_hash
                self._nounce = the_nounce
                end_time = time.time()
                time_taken = end_time - start_time
                print("----- Mine time: %s -----" % time_taken)
                return
            else:
                the_nounce += 1

    def hash(self, nonce=None):
        self._nounce = nonce or self._nounce
        block_json = {'index': self._index, 'timestamp': self._timestamp, 'data': self._data,
                      'previous_hash': self._previous_hash, 'nounce': self._nounce}

        return hashlib.sha256(json.dumps(block_json).encode('utf-8')).hexdigest()

    def __str__(self):
        return json.dumps(
            {'index': self._index, 'timestamp': self._timestamp, 'data': self._data,
             'previous_hash': self._previous_hash,
             'hash': self._hash, 'nounce': self._nounce})


# genesis block is the first block in the blockchain
def genesis_block():
    return Block(0, time.time(), "This is genesis block", '0')


# create next block for blockchain
def next_block(_previous_block, data):
    _new_index = _previous_block._index + 1
    _new_timestamp = time.time()
    _previous_hash = _previous_block._hash
    return Block(_new_index, _new_timestamp, data, _previous_hash)


blockchain = [genesis_block()]

# first block for blockchain
previous_block = blockchain[0]
num_of_blocks = 20

# iteratively adding block to blockchain
for i in range(0, num_of_blocks):
    transaction = {'from': '0x12345' + str(i), 'to': '0x54321' + str(i * 3), 'amount': 100}
    new_block = next_block(previous_block, transaction)
    new_block.mine()
    blockchain.append(new_block)
    previous_block = new_block
    print("Block added to blockchain")
    print(new_block)
