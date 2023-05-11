package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	in := bufio.NewReader(os.Stdin)
	cases := readInt(in)

	for i := 0; i < cases; i++ {
		nStr, _ := in.ReadString('\n')
		nStr = strings.ReplaceAll(nStr, "\r", "")
		nStr = strings.ReplaceAll(nStr, "\n", "")
		runes := []rune(nStr)
		uniqChar := map[rune]int{}

		for _, val := range runes {
			uniqChar[val]++
		}

		if len(uniqChar) > 1 {
			fmt.Printf("%d\n", len(runes)-1)
		} else {
			fmt.Printf("-1\n")
		}
	}

}

func solve(n int64, m int64) bool {
	if n == m {
		return true
	}

	if n%3 != 0 {
		return false
	}

	return solve(n/3, m) || solve((2*n)/3, m)
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
