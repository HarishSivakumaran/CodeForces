func topKFrequent(nums []int, k int) []int {
	n := len(nums) + 1
	freq := make([][]int, n)
	freqMap := map[int]int{}

	for _, val := range nums {
		freqMap[val]++
	}

	for key, val := range freqMap {
		freq[val] = append(freq[val], key)
	}

	out := []int{}

	for i := len(freq) - 1; i >= 0; i-- {
		if len(freq[i]) > 0 {
			for _, v := range freq[i] {
				out = append(out, v)
				if len(out) == k {
					return out
				}
			}
		}
	}

	return out
}