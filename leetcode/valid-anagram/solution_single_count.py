# Time: O(n + m) on average, Space: O(1)
# n = len(s), m = len(t); at most 26 distinct lowercase letters.
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        count_s = {}
        for char in s:
            if char in count_s:
                count_s[char] += 1
            else:
                count_s[char] = 1

        for char in t:
            if char in count_s:
                if count_s[char] == 0:
                    return False
                count_s[char] -= 1
            else:
                return False

        return True

