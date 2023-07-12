module MultiSets(
    MSet(MS),
    empty,
    add,
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

{--
    The equality check is done by applying the subset function two times: the first check if the first MSet
    is fully contained in the second one and the second check the vice versa.
--}
instance Eq a => Eq (MSet a) where
    (==) :: Eq a => MSet a -> MSet a -> Bool
    (==) mset1 mset2 = subeq mset1 mset2 && subeq mset2 mset1


{--
    Constructor to create an empty MSet
--}
empty :: MSet a
empty = MS []

{--
    Function that returns a list of pair contained in MSet passed as a parameter
--}
toList :: MSet a -> [(a, Int)]
toList (MS x) = x

{-- 
    Function that add an element to MSet, it check if the key is already present in MSet by recursevely scan 
    the MSet. If the element is in the MSet then increase the related value by 1 otherwise it insert a new 
    pair containing the new element with value 1.
--}
add :: Eq a => MSet a -> a -> MSet a
add (MS []) v = MS [(v, 1)]
add (MS((x, y):xs)) v = if x==v then MS ((x,y+1):xs) else MS ((x, y) : toList (add (MS xs) v))

{--
    Function that add multiple element with the same key to MSet, it check if the key is already present in 
    MSet by recursevely scan the MSet. If the element is in the MSet then increase the related value by the
    number of elements to insert otherwise it insert a new pair containing the new element with value as the
    number of elements to insert.
--}
addMultiple :: Eq a => MSet a -> a -> Int -> MSet a
addMultiple (MS []) k v = MS [(k, v)]
addMultiple (MS((x,y) : xs)) k v = if x == k then MS ((x, y + v) : xs) else MS ((x, y) : toList (addMultiple (MS xs) k v))

{--
    Function that given an MSet and a key returns the number of occourrences of that key. 
--}
occs :: Eq a => MSet a -> a -> Int
occs (MS[]) v = 0
occs (MS((x, y):xs)) v = if x==v then y else occs (MS xs) v

{--
    Function that given a MSet returns all the key of that MSet.
--}
elems :: MSet a -> [a]
elems (MS[]) = []
elems (MS((x, y):xs)) = x : elems (MS xs)

{--
    Function that given two MSet, check if the second one contains all the key and the same value of the first MSet.
--}
subeq :: Eq a => MSet a -> MSet a -> Bool
subeq (MS[]) mset = True
subeq (MS((x, y):xs)) mset = (y == occs mset x) && subeq (MS xs) mset

{--
    Function that given two MSet returns a unique MSet that contains the union of both MSet passed by parameter.
--}
union :: Eq a => MSet a -> MSet a -> MSet a
union (MS[]) mset = mset
union (MS((x, y):xs)) mset = union (MS xs) (addMultiple mset x y)

{--
    It's not possible to define an instance of Functor for MSet because applying map function it's not 
    guaranteed that the molteplicity of the elements are preserved. For example if we apply a function that
    maps two keys in the same result into the resulting MSet will contains only one pair that will contain 
    the sum of the values related of the two keys. 
    For this reason we need to add the Eq b in the signature in order to manage this case, then fmap signature: 
        (a -> b) -> MSet a -> MSet b 
    is not respected.

    Given a function and an MSet as parameters, the function applies the union function between the MSet mapped 
    with the function passed by the parameter and an MSet empty.  The union allows uniting the keys that are 
    mapped with the same value.
--}
mapMSet :: Eq b => (a -> b) -> MSet a -> MSet b
mapMSet f (MS xs) = union (MS(map (\(x, n) -> (f x, n)) xs)) (MS[])
