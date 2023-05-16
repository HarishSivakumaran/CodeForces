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

	cons := readArrInt64(in)
	spNums := readArrInt64(in)

	batch := int64(1)

	i := 0
	ans := 0
	diff := int64(0)

	for i < len(spNums) {
		start, end := ((batch-1)*cons[2])+1, (batch)*cons[2]
		if spNums[i]-diff > end {
			if (spNums[i]-diff)%(cons[2]) == 0 {
				batch = (spNums[i] - diff) / (cons[2])
			} else {
				batch = (spNums[i] - diff) / (cons[2])
				batch++
			}
			continue
		}
		for i < len(spNums) && spNums[i]-diff >= start && spNums[i]-diff <= end {
			i++
		}
		ans++
		diff = int64(i)
	}
	fmt.Println(ans)

}

func abs(i int) int {
	if i < 0 {
		return -1 * i
	}
	return i
}

func gcd(i, j int) int {
	if j == 0 {
		return i
	}

	return gcd(j, i%j)
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
