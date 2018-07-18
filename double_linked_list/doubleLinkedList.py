class DNode():
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None
        

class DLink_List():

    def __init__(self):        
        self._head = None
        self._tail = None
        self._probe = None
        self._size = 0

    def size(self):
        return self._size

    def insert(self,item):
        node = DNode(item)
        if self._head == None:
            self._head = node
            self._tail = self._head
        elif item < self._head.data:
            node.next = self._head
            self._head.prev = node
            self._head = node
        elif item > self._tail.data:
            node.prev = self._tail
            self._tail.next = node
            self._tail = node
        else:
            probe = self._head
            while probe is not None and probe.data < item:
                probe = probe.next
            node.next = probe
            node.prev = probe.prev
            probe.prev.next = node
            probe.prev = node
        self._size += 1

    def remove(self,item):
        assert not self._size == 0, "Cannot delete from empty list"
              
        if item == self._tail.data:
            if self._tail == self._head:
                self._tail,self._head = None,None
                
            else:
                self._tail = self._tail.prev
                self._tail.next = None
                
            
        elif item == self._head.data:
            self._head = self._head.next
            self._head.prev = None
            
            
        else:
            probe = self._head
            while not item == probe.data:
                probe = probe.next
            if probe == None:
                return "Node not in list"
            else:
                probe.prev.next = probe.next
                probe.next.prev = probe.prev
        self._size -= 1
                
    def search(self,item):
        if self._head is None:
            return False
        elif self._probe is None:
            self._probe = self._head

        if item < self._probe.data:
            while self._probe is not None and self._probe.data >= item:
                if self._probe.data == item:
                    return True
                else:
                    self._probe = self._probe.prev
        else:
            while self._probe is not None and self._probe.data <= item:
                if self._probe.data == item:
                    return True
                else:
                    self._probe = self._probe.next
        return False


a = DLink_List()
        
        
