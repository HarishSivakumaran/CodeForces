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
		len := readInt(in)
		len++
		arr := readArrInt64(in)

		primeMap := map[int64]int64{}

		for _, val := range arr {
			for j := int64(2); j*j <= val; j++ {
				for val%j == 0 {
					val /= j
					primeMap[j]++
				}
			}

			if val != 1 {
				primeMap[val]++
			}
		}

		res := int64(0)
		rem := int64(0)

		for _, val := range primeMap {
			res += val / 2
			rem += val % 2
		}

		res += rem / 3

		fmt.Println(res)
	}

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
