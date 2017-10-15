 def radixsort( aList ):
  RADIX = 10
  maxLength = False
  tmp , placement = -1, 1
 
  while not maxLength:
    maxLength = True
    buckets = [list() for _ in range( RADIX )]
 
    for  i in aList:
      tmp = i / placement
      buckets[tmp % RADIX].append( i )
      if maxLength and tmp > 0:
        maxLength = False

    a = 0
    for b in range( RADIX ):
      buck = buckets[b]
      for i in buck:
        aList[a] = i
        a += 1

    placement *= RADIX

  print aList

def main():
  a = [18,5,100,3,1,19,6,0,7,4,2]
  radixsort(a)