package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
	"math"
)

func main() {
	in := bufio.NewReader(os.Stdin)
	cases := readInt(in)
	
	for z := 0; z < cases; z++ {
	    _ = readInt(in)
	    arr := readArrInt(in)
	    swaped := make([]bool, len(arr))
	    index := map[int]int{}
	    
	    for i,val := range arr{
	        index[val-1] = i
	    }
	    
	    for i := 0; i < len(arr); i++{
	        curr := index[i]
	        
	        for curr > i && swaped[curr-1] == false && arr[curr-1] > arr[curr]{
	           swaped[curr-1] = true
	           index[arr[curr]-1] = curr-1
	           index[arr[curr-1]-1] = curr
	           arr[curr], arr[curr-1] =  arr[curr-1], arr[curr]
	           curr--
	        }
	    }
	    
        for _, val := range arr{
            fmt.Print(val, " ")
        }
        
        fmt.Print("\n")
	}
    
}

func powInt(x, y int64) int64 {
    return int64(math.Pow(float64(x), float64(y)))
}

func readInt(in *bufio.Reader) int {
	nStr, _ := in.ReadString('\n')
	nStr = strings.ReplaceAll(nStr, "\r", "")
	nStr = strings.ReplaceAll(nStr, "\n", "")
	n, _ := strconv.Atoi(nStr)
	return n
}

func readLineNumbs(in *bufio.Reader) []string {
	line, _ := in.ReadString('\n')
	line = strings.ReplaceAll(line, "\r", "")
	line = strings.ReplaceAll(line, "\n", "")
	numbs := strings.Split(line, " ")
	return numbs
}

func readArrInt(in *bufio.Reader) []int {
	numbs := readLineNumbs(in)
	arr := make([]int, len(numbs))
	for i, n := range numbs {
		val, _ := strconv.Atoi(n)
		arr[i] = val
	}
	return arr
}

func readArrInt64(in *bufio.Reader) []int64 {
	numbs := readLineNumbs(in)
	arr := make([]int64, len(numbs))
	for i, n := range numbs {
		val, _ := strconv.ParseInt(n, 10, 64)
		arr[i] = val
	}
	return arr
}
s