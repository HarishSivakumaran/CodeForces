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
		nStr, _ := in.ReadString('\n')
		nStr = strings.ReplaceAll(nStr, "\r", "")
		nStr = strings.ReplaceAll(nStr, "\n", "")

		letter := []rune(nStr)
		arr := []int{}

		for i := 0; i < len(letter)-2; i++ {
			if letter[i] == 'o' && letter[i+1] == 'n' && letter[i+2] == 'e' {
				letter[i+1] = 'x'
				arr = append(arr, i+1+1)
			}

			if letter[i] == 't' && letter[i+1] == 'w' && letter[i+2] == 'o' {
				if i+4 < len(letter) && letter[i+3] == 'n' && letter[i+4] == 'e' {
					letter[i+2] = 'x'
					arr = append(arr, i+2+1)
				} else {
					letter[i+1] = 'x'
					arr = append(arr, i+1+1)
				}
			}
		}

		fmt.Println(len(arr))
		for _, val := range arr {
			fmt.Print(val, " ")
		}
		fmt.Print("\n")
	}

}

func mod(i int) int {
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
