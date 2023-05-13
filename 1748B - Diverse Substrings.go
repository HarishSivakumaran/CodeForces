package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

func main() {
	in := bufio.NewReader(os.Stdin)
	cases := readInt(in)

	for z := 0; z < cases; z++ {
		readInt(in)
		nStr, _ := in.ReadString('\n')
		nStr = strings.ReplaceAll(nStr, "\r", "")
		nStr = strings.ReplaceAll(nStr, "\n", "")
		strArr := []rune(nStr)

		res := 0

		for i, _ := range strArr {
			uniqChar := map[rune]int{}
			maxF := 0
			for j := i; j < i+100 && j < len(strArr); j++ {
				uniqChar[strArr[j]]++
				if uniqChar[strArr[j]] > maxF {
					maxF = uniqChar[strArr[j]]
				}

				if maxF <= len(uniqChar) {
					res++
				}
			}
		}

		fmt.Println(res)
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
