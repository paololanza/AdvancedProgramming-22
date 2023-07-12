{-# OPTIONS_GHC -Wno-overlapping-patterns #-}

import MultiSets (MSet(MS), add, empty, union, elems, subeq)
import Data.List
import System.IO.Unsafe


ciao :: [String] -> [String]
ciao = map (\x -> sort x)

addWords :: [[Char]] -> MSet [Char] -> MSet [Char]
addWords words (MS mset) = 
    foldr (\x mset -> MultiSets.add mset x) (MS []) words

readMSet :: String -> IO(MSet [Char])
readMSet pathfile = do
    text <- readFile pathfile
    let ciao_words = ciao(words text)
    let empty_mset = empty
    let full_mset = addWords ciao_words empty_mset
    return full_mset
    
--writeMSet ::

main :: IO()
main = do
    let mset1 = unsafePerformIO(readMSet "/Users/paololanza/Downloads/aux_files/anagram.txt")
    let mset2 = unsafePerformIO(readMSet "/Users/paololanza/Downloads/aux_files/anagram-s1.txt")
    let mset3 = unsafePerformIO(readMSet "/Users/paololanza/Downloads/aux_files/anagram-s2.txt")
    let mset4 = unsafePerformIO(readMSet "/Users/paololanza/Downloads/aux_files/margana2.txt")

    -- domanda 1
    print (elems mset1 == elems mset4)
    print (subeq mset1 mset4)

    --domanda 2
    print (subeq mset1 (MultiSets.union mset2 mset3))
    return ()