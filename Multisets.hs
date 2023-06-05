data MSet a = MS [(a, Int)]
    deriving (Show)

findElement :: Eq a => a -> ListBag a -> Bool
findElement a (LB []) = False
findElement a (LB ((x,y):xs)) = x == a || findElement a (LB xs)

empty :: MSet a
empty = MS []

add :: 
findElement 

occs ::

elems ::

subeq ::

union ::