import Control.Lens hiding ((<|), (|>), (:<), (:>))
import Control.Monad (void)
import Control.Monad.IO.Class (liftIO)
import Control.Monad.State.Lazy (StateT(..), runStateT, get, gets)
import Data.Sequence

-- 'Seq' is a dequeue
type Dequeue a = Seq a

main :: IO ()
main = do
  putStrLn "-- pure operations"
  let xs  = fromList [10]
      xs' = 20 <| xs -- push front
      xs'' = xs' |> 30 -- push back
  mapM_ print [xs, xs', xs'']
  --NOTE: these are unsafe operations (Please see 'context' for safe operations)
  let (x' :< xs') = viewl xs''
      (xs :> x) = viewr xs'
  mapM_ print [x', x]
  void $ runStateT context xs

context :: StateT (Dequeue Int) IO ()
context = do
  liftIO $ putStrLn "-- inpure operations"
  printState
  simple %= (20 <|)
  printState
  simple %= (|> 30)
  printState
  --NOTE: these are safe operations by 'Prism'
  maybeHead <- gets $ preview _head
  liftIO $ print maybeHead
  maybeLast <- gets $ preview _last
  liftIO $ print maybeLast
  where
    printState :: Show s => StateT s IO ()
    printState = get >>= liftIO . print
