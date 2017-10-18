def bsort(n1,n2,b,n,bucket,r):
    for i in range(len(n)):
        j = ((n[i]-n1)/r)
        bucket[j].append(a[i])
    for i in range(b):
        f = len(bucket[i])
        bucket[i] = isort(f,bucket[i])
    ar = []
    for i in  range(b):
        ar.extend(bucket[i])
    return ar


def isort(f,ar):
    for j in range (1,f):
            k = j-1
            key = ar[j]
            while k >= 0 and key < ar[k]:
                ar[k+1] = ar[k]
                k -= 1
            ar[k+1] = key
        return ar






n1,n2,b = raw_input().strip().split(' ')
n1,n2,b = [int(n1),int(n2),int(b)]
n = list(map(int,raw_input().strip().split(' ')))
r = (n2-n1)/b
bucket = [[] for i in range(b)]
result = bsort(n1,n2,b,n,bucket,r)
print(result)
