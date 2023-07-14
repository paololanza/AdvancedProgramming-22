{-# OPTIONS_GHC -Wno-overlapping-patterns #-}

import MultiSets (MSet(MS), add, empty, union, elems, subeq, mapMSet)
import Data.List
import System.IO.Unsafe
import Control.Exception

{--
    Function that given a string ([Char]) returns the sorted string (ciao string)
--}
ciao :: [String] -> [String]
ciao = map (\x -> sort x)

{--
    Function that given a list of words and a MSet, add the words into the MSet by applying the foldr function
    and accumulate the computation in the MSet passed by parameter. 
--}
addWords :: [[Char]] -> MSet [Char] -> MSet [Char]
addWords words (MS mset) =
    foldr (\x mset -> MultiSets.add mset x) (MS mset) words

{--
    Function that given a MSet returns all the pairs contained into the MSet as a string.
--}
toString :: MSet [Char] -> String
toString (MS[]) = ""
toString (MS((x, y):xs)) = x ++ " - " ++ show y ++ "\n" ++ toString (MS xs)

{--
    Function that given a String that contains the path to the file to read return an MSet that contains 
    the words and their occourrences
--}
readMSet :: String -> IO(MSet [Char])
readMSet pathfile = do
    text <- readFile pathfile
    let ciao_words = ciao (words text)
    let empty_mset = empty
    let full_mset = addWords ciao_words empty_mset
    return full_mset

{--
    Function that given an MSet and a path to the file to write, write the content of the MSet into the file
--}
writeMSet :: MSet [Char] -> [Char] -> IO()
writeMSet mset filename =
    writeFile filename (toString mset)

main :: IO()
main = do

    let mset1 = unsafePerformIO (readMSet "/Users/paololanza/Downloads/aux_files/anagram.txt")
    let mset2 = unsafePerformIO (readMSet "/Users/paololanza/Downloads/aux_files/anagram-s1.txt")
    let mset3 = unsafePerformIO (readMSet "/Users/paololanza/Downloads/aux_files/anagram-s2.txt")
    let mset4 = unsafePerformIO (readMSet "/Users/paololanza/Downloads/aux_files/margana2.txt")

    print "Question 1:"
    print ("mset1 and mset4 are equal: mset1 == mset4 = " ++ show (mset1 == mset4))
    print ("mset1 and mset4 have the same elements: elems mset1 == elems mset4 = " ++ show (elems mset1 == elems mset4))

    print "Question 2:"
    print ("mset1 and the union between mset2 and mset3 are equal: mset1 == (union mset2 mset3) = " ++
            show (mset1 == MultiSets.union mset2 mset3))

    writeMSet mset1 "anag-out.txt"
    writeMSet mset4 "gana-out.txt"

    return ()