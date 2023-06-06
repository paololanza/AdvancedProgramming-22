module MSet(
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

add_mul :: Eq a => MSet a -> a -> a -> MSet a
add (MS[]) v o = MS([(v, o)])
add (MS((x, y):xs)) v o = if x==v then (MS ((x,y+o):xs)) else add (MS xs) v o

occs :: Eq a => MSet a -> a -> Int
occs (MS[]) v = 0
occs (MS((x, y):xs)) v = if x==v then y else occs (MS xs) v

elems :: MSet a -> [a]
elems (MS[]) = []
elems (MS((x, y):xs)) = x: elems (MS xs)

subeq :: Eq a => MSet a -> MSet a -> Bool
subeq (MS[]) mset = True
subeq (MS((x, y):xs) mset = if y == (occs mset x) then subeq (MS xs) mset else False

union :: Eq a => MSet a -> MSet a -> MSet a
union (MS[]) mset = mset
union (MS((x, y):xs)) mset = union (MS xs) (add_mul mset x y)



