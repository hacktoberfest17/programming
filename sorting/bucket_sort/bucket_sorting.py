#=======================================================================
#  Author: Isai Damier
#  Title: Bucketsort
#  Project: geekviewpoint
#  Package: algorithms
#
#  Statement:
#  Given a disordered list of integers, rearrange them in natural
#     order.
#
#  Sample Input: [8,5,3,1,9,6,0,7,4,2,5]
#  Sample Output: [0,1,2,3,4,5,6,7,8,9,5]
#
#  Time Complexity of Solution:
#  Best Case O(n); Average Case O(n); Worst Case O(n).
#
# Approach:
# If it sounds too good to be true, then most likely it's not true.
# Bucketsort is not an exception to this adage. For bucketsort to
#   work at its blazing efficiency, there are multiple prerequisites.
#   First the hash function that is used to partition the elements need
#   to be very good and must produce ordered hash: if i < k then
#   hash(i) < hash(k). Second, the elements to be sorted must be
#   uniformly distributed.
#
# The aforementioned aside, bucket sort is actually very good
#   considering that counting sort is reasonably speaking its upper
#   bound. And counting sort is very fast. The particular distinction
#   for bucket sort is that it uses a hash function to partition the
#   keys of the input array, so that multiple keys may hash to the same
#   bucket. Hence each bucket must effectively be a growable list;
#   similar to radix sort.
#
# Numerous Internet sites, including university pages, have
#   erroneously written counting sort code and call them bucket sort.
#   Bucket sort uses a hash function to distribute keys; counting sort
#   creates a bucket for each key. Indeed there are perhaps greater
#   similarities between radix sort and bucket sort, than there are
#   between counting sort and bucket sort.
#
# In the presented program insertionsort is used to sort
#   each bucket. This is to inculcate that the bucket sort algorithm
#   does not specify which sorting technique to use on the buckets.
#   A programmer may choose to continuously use bucket sort on each
#   bucket until the collection is sorted (in the manner of the radix
#   sort program below). Whichever sorting method is used on the
#   buckets, bucket sort still tends toward O(n).
#=======================================================================
 def bucketsort( A ):
  # get hash codes
  code = hashing( A )
  buckets = [list() for _ in range( code[1] )]
  # distribute data into buckets: O(n)
  for i in A:
    x = re_hashing( i, code )
    buck = buckets[x]
    buck.append( i )

  # Sort each bucket: O(n).
  # I mentioned above that the worst case for bucket sort is counting
  # sort. That's because in the worst case, bucket sort may end up
  # with one bucket per key. In such case, sorting each bucket would
  # take 1^2 = O(1). Even after allowing for some probabilistic
  # variance, to sort each bucket would still take 2-1/n, which is
  # still a constant. Hence, sorting all the buckets takes O(n).

  for bucket in buckets:
    insertionsort( bucket )

  ndx = 0
  # merge the buckets: O(n)
  for b in range( len( buckets ) ):
    for v in buckets[b]:
      A[ndx] = v
      ndx += 1

import math

def hashing( A ):
  m = A[0]
  for i in range( 1, len( A ) ):
    if ( m < A[i] ):
      m = A[i]
  result = [m, int( math.sqrt( len( A ) ) )]
  return result


def re_hashing( i, code ):
  return int( i / code[0] * ( code[1] - 1 ) )
