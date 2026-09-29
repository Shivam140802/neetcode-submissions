class RadixHeap:
    """
    Monotone integer priority queue.
    Every newly inserted key must be >= the last popped key.
    """

    def __init__(self):
        self.last = 0
        self.buckets = [[]]
        self.size = 0

    def _bucket(self, key):
        if key == self.last:
            return 0
        return (key ^ self.last).bit_length()

    def push(self, key, value):
        idx = self._bucket(key)

        while idx >= len(self.buckets):
            self.buckets.append([])

        self.buckets[idx].append((key, value))
        self.size += 1

    def pop(self):
        if self.size == 0:
            raise IndexError("empty heap")

        if not self.buckets[0]:

            idx = 1

            while not self.buckets[idx]:
                idx += 1

            bucket = self.buckets[idx]

            self.last = min(key for key, _ in bucket)

            self.buckets[idx] = []

            for key, value in bucket:

                new_idx = self._bucket(key)

                while new_idx >= len(self.buckets):
                    self.buckets.append([])

                self.buckets[new_idx].append((key, value))

        self.size -= 1

        return self.buckets[0].pop()

    def __bool__(self):
        return self.size > 0


class PairStream:
    """
    Lazily generates pair sums.

    ascending=True:
        smallest pair sums first

    ascending=False:
        largest pair sums first
    """

    def __init__(self, values, counts, ascending):

        self.values = values
        self.counts = counts
        self.n = len(values)

        self.ascending = ascending

        self.heap = RadixHeap()

        self.pending = None

        self.base = self.n + 1

        if ascending:

            self.bound = 2 * values[0]

            for i in range(self.n):

                # Pair (i, i) is allowed only if
                # that number appears at least twice.
                if counts[i] >= 2:
                    j = i
                else:
                    j = i + 1

                if j < self.n:
                    self._push(i, j)

        else:

            self.bound = 2 * values[-1]

            for i in range(self.n):

                j = self.n - 1

                if j > i:
                    self._push(i, j)

                elif j == i and counts[i] >= 2:
                    self._push(i, j)

    def _key(self, pair_sum, i):

        if self.ascending:
            primary = pair_sum - self.bound
        else:
            primary = self.bound - pair_sum

        return primary * self.base + i

    def _push(self, i, j):

        pair_sum = self.values[i] + self.values[j]

        key = self._key(pair_sum, i)

        self.heap.push(
            key,
            (pair_sum, i, j)
        )

    def _pop(self):

        if self.pending is not None:

            item = self.pending
            self.pending = None

            return item

        if not self.heap:
            return None

        _, item = self.heap.pop()

        return item

    def _advance(self, i, j):

        if self.ascending:

            j += 1

            if j < self.n:
                self._push(i, j)

        else:

            j -= 1

            if j < i:
                return

            if j == i and self.counts[i] < 2:
                return

            self._push(i, j)

    def next_group(self):
        """
        Returns all pairs having the same pair sum.

        Example:

        sum = 3

        pairs =
        [
            (index_of_1, index_of_2),
            (index_of_0, index_of_3)
        ]
        """

        first = self._pop()

        if first is None:
            return None

        pair_sum, i, j = first

        group = []

        while True:

            group.append((i, j))

            self._advance(i, j)

            nxt = self._pop()

            if nxt is None:
                break

            new_sum, ni, nj = nxt

            if new_sum != pair_sum:

                self.pending = nxt
                break

            i = ni
            j = nj

        # Required by our merge logic later.
        group.sort()

        return pair_sum, group

class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        
        if len(nums) < 4:
            return []

        nums.sort()

        # --------------------------------------------------
        # 1. Compress duplicate values
        #
        # [-2,-1,-1,0,0,0,1]
        #
        # values = [-2,-1,0,1]
        # counts = [1,2,3,1]
        # --------------------------------------------------

        values = []
        counts = []

        for num in nums:

            if values and values[-1] == num:
                counts[-1] += 1

            else:
                values.append(num)
                counts.append(1)

        # --------------------------------------------------
        # 2. Pair sums from both directions
        # --------------------------------------------------

        left_stream = PairStream(
            values,
            counts,
            True
        )

        right_stream = PairStream(
            values,
            counts,
            False
        )

        left_group = left_stream.next_group()
        right_group = right_stream.next_group()

        result = []

        # --------------------------------------------------
        # 3. Two-pointer logic over PAIR SUMS
        # --------------------------------------------------

        while (
            left_group is not None
            and right_group is not None
        ):

            left_sum, left_pairs = left_group
            right_sum, right_pairs = right_group

            # Once they cross, nothing useful remains.
            if left_sum > right_sum:
                break

            current = left_sum + right_sum

            if current < target:

                left_group = left_stream.next_group()
                continue

            if current > target:

                right_group = right_stream.next_group()
                continue

            # ------------------------------------------------
            # left_sum + right_sum == target
            #
            # left pair:
            #
            #     i <= j
            #
            # right pair:
            #
            #     k <= l
            #
            # canonical quadruplet requires:
            #
            #     i <= j <= k <= l
            # ------------------------------------------------

            p = len(right_pairs)

            for i, j in left_pairs:

                # Because left_pairs are sorted by i,
                # their j values move in the opposite
                # direction for a fixed sum.
                #
                # Move p until:
                #
                #     k >= j
                #
                while (
                    p > 0
                    and right_pairs[p - 1][0] >= j
                ):
                    p -= 1

                for k, l in right_pairs[p:]:

                    # ---------------------------------------
                    # Usually j < k, so there is no overlap.
                    #
                    # Only tricky case:
                    #
                    #     j == k
                    #
                    # meaning the same VALUE appears on both
                    # pair boundaries.
                    # ---------------------------------------

                    if j == k:

                        required = 2  # j and k

                        if i == j:
                            required += 1

                        if l == j:
                            required += 1

                        if counts[j] < required:
                            continue

                    result.append([
                        values[i],
                        values[j],
                        values[k],
                        values[l]
                    ])

            left_group = left_stream.next_group()
            right_group = right_stream.next_group()

        return result