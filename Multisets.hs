module Ex1(
    MSet(MS),
    empty,
    add,
    findElement
) where

data MSet a = MS [(a, Int)]
    deriving (Show)

findElement :: Eq a => a -> MSet a -> Bool
findElement a (MS []) = False
findElement a (MS ((x,y):xs)) = x == a || findElement a (MS xs)

empty :: MSet a
empty = MS []

add :: Eq a => MSet a -> a -> MSet a
add (MS[]) v = MS([(v, 1)])
add (MS((x, y):xs)) v = if x==v then (MS ((x,y+1):xs)) else add (MS xs) v
