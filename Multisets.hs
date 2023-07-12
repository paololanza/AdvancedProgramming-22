module MultiSets(
    MSet(MS),
    empty,
    add,
    findElement,
    occs,
    elems,
    subeq,
    union,
    addMultiple,
    mapMSet
) where

data MSet a = MS [(a, Int)]
    deriving (Show)

instance Foldable MSet where
    foldr :: (a -> b -> b) -> b -> MSet a -> b
    foldr fun acc (MS[]) = acc
    foldr fun acc (MS((x, y):xs)) = fun x (foldr fun acc (MS xs))

instance Eq a => Eq (MSet a) where
    (==) :: Eq a => MSet a -> MSet a -> Bool
    {--
    Spiegare perché farlo in entrambe le direzioni
    --}
    (==) mset1 mset2 = subeq mset1 mset2 && subeq mset2 mset1

empty :: MSet a
empty = MS []

toList :: MSet a -> [(a, Int)]
toList (MS x) = x

add :: Eq a => MSet a -> a -> MSet a
add (MS []) v = MS [(v, 1)]
add (MS((x, y):xs)) v = if x==v then MS ((x,y+1):xs) else MS ((x, y) : toList (add (MS xs) v))

addMultiple :: Eq a => MSet a -> a -> Int -> MSet a
addMultiple (MS []) k v = MS [(k, v)]
addMultiple (MS((x,y) : xs)) k v = if x == k then MS ((x, y + v) : xs) else MS ((x, y) : toList (addMultiple (MS xs) k v))

occs :: Eq a => MSet a -> a -> Int
occs (MS[]) v = 0
occs (MS((x, y):xs)) v = if x==v then y else occs (MS xs) v

elems :: MSet a -> [a]
elems (MS[]) = []
elems (MS((x, y):xs)) = x : elems (MS xs)

subeq :: Eq a => MSet a -> MSet a -> Bool
subeq (MS[]) mset = True
subeq (MS((x, y):xs)) mset = (y == occs mset x) && subeq (MS xs) mset

union :: Eq a => MSet a -> MSet a -> MSet a
union (MS[]) mset = mset
union (MS((x, y):xs)) mset = union (MS xs) (addMultiple mset x y)

{--
TODO: spiegare perché non è possibilo
--}
mapMSet :: (a -> b) -> MSet a -> MSet b
mapMSet f (MS[]) = MS []
mapMSet f (MS ((x, y):xs)) = MS [(f x, y) | (x, y) <- xs]