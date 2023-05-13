// 1263B - PIN Codes
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
		l := readInt(in)
		arr := make([]int, l)
		set := map[int]int{}

		for i := 0; i < l; i++ {
			val := readInt(in)
			set[val]++
			arr[i] = val
		}

		changes := 0
		changed := false

		for i := 0; i < l; i++ {
			val := arr[i]
			changed = false
			count := 0
			v := 1
			for set[val] > v {
				val = val / 10
				val = val*10 + count
				count++
				changed = true
				v = 0
			}
			if changed {
				set[arr[i]]--
				changes++
				set[val] = 2
			}

			arr[i] = val

		}
		fmt.Println(changes)
		for _, val := range arr {
			fmt.Printf("%04d\n", val)
		}
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
