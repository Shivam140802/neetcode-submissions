class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t) > len(s):
            return ""

        arr1 = [0] * 128  # Use ASCII (not just lowercase)
        arr2 = [0] * 128

        for ch in t:
            arr2[ord(ch)] += 1

        def contains():
            for i in range(128):
                if arr1[i] < arr2[i]:
                    return False
            return True

        left = 0
        min_len = float('inf')
        start = 0

        for right in range(len(s)):
            arr1[ord(s[right])] += 1

            while contains():
                if right - left + 1 < min_len:
                    min_len = right - left + 1
                    start = left

                arr1[ord(s[left])] -= 1
                left += 1

        return s[start:start + min_len] if min_len != float('inf') else ""
