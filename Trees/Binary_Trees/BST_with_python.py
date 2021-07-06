
class Node:
    def __init__(self,data,left=None,right=None):
        self.data = data
        self.left = left
        self.right = right


class BST:
    def __init__(self,data=None):
        self.root = Node(data)
    
    def printSideway(root,level):
        if root != None:
            BST.printSideway(root.right,level+1)
            print(' '*(3*level),root.data)
            BST.printSideway(root.left,level+1)

    def addI(self,data):
        q = []
        q.append(self.root)
        while len(q) != 0:
            n = q.pop(0)
            if not n.left < data:
                q.append(n.left)
            if not n.right >= data:
                q.append(n.right)
                
            
            if n.left == None:
                pass
            else:q.append(n.left)

            if n.right == None:
                passs
            else:q.append(n.right)

    
    def insertR(root,data):

        if root.data == None:
            root.data = data
            return
        if data < root.data:
            if root.left != None:
                BST.insertR(root.left,data)
            else:
                root.left = Node(data)
        else:
            if root.right != None:
                BST.insertR(root.right,data)
            else:
                root.right = Node(data)

    def inOrder(root,lamb=None):
        if root.left != None:
            BST.inOrder(root.left,lamb)
        if root.data != None:
            if lamb == None:
                print(root.data,end=' ')
            else:
                lamb(root.data)
        if root.right != None:
            BST.inOrder(root.right,lamb)
    def _search(root,data):
        if root.left != None:
            return BST._search(root.left,data)
        if root.data != None:
            if root.data == data:
                return root.data
        if root.right != None:
            return BST._search(root.right,data)

    def search(self,data):
        return BST._search(self.root,data)
        
    def _path(root,data):
        if root.left != None:
            res = BST._path(root.left,data) 
            if res!=None:
                print(root.data)
            return res
        if root.data != None:
            if root.data == data:
                print(root.data)
                return root.data
        if root.right != None:
            res = BST._path(root.right,data) 
            if res!=None:
                print(root.data)
            return res

    def path(self,data):
        BST._path(self.root,data)


    def _del(root,data):
        if root.left != None:
            BST._del(root.left,data)
        if root.data != None:
            if root.data == data:
                pass
                # root.
        if root.right != None:
            BST._del(root.right,data)
    def dele(self,data):
        BST._del(self.root,data)
