import unittest
from algorithms import sorting

class Test( unittest.TestCase ):

  def testBucketsort( self ):
    A = [8, 5, 3, 1, 9, 6, 0, 7, 4, 2, 5]
    sorting.bucketsort( A )
    for i in range( 1, len( A ) ):
      if A[i - 1] > A[i]:
        self.fail( "bucketsort method fails." )

