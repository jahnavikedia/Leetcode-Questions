class Pair {
    char character;
    int rem;
    Pair(char character, int rem) {
        this.character = character;
        this.rem = rem;
    }
}

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((d, e) -> e.rem - d.rem);

        if (a > 0) maxHeap.add(new Pair('a', a));
        if (b > 0) maxHeap.add(new Pair('b', b));
        if (c > 0) maxHeap.add(new Pair('c', c));

        StringBuilder sb = new StringBuilder();
        char lastChar = ' ';
        int repeatCount = 0;

        while (!maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();

            if (sb.length() > 0 && current.character == lastChar && repeatCount == 2) {
                // If we can't use the same char, pick the next one
                if (maxHeap.isEmpty()) break; // No valid char left

                Pair next = maxHeap.poll();
                sb.append(next.character);
                lastChar = next.character;
                repeatCount = 1;

                if (next.rem - 1 > 0) {
                    maxHeap.add(new Pair(next.character, next.rem - 1));
                }
                // Put back the previous character
                maxHeap.add(current);
            } else {
                // Use current character
                sb.append(current.character);
                if (current.character == lastChar) {
                    repeatCount++;
                } else {
                    lastChar = current.character;
                    repeatCount = 1;
                }

                if (current.rem - 1 > 0) {
                    maxHeap.add(new Pair(current.character, current.rem - 1));
                }
            }
        }

        return sb.toString();
    }
}
