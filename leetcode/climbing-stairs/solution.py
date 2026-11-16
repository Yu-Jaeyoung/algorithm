from math import comb

# Time Complexity: O(n)
# Space Complexity: O(1)
# These bounds assume 1 <= n <= 45, where CPython's math.comb
# uses fixed-size integer fast paths and all values remain small.
class Solution:
    def climbStairs(self, n: int) -> int:
        step = 0
        for k in range(n // 2 + 1):
            step += comb(n - k, k)

        return step

