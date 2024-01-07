# Graph Mistakes

### [LeetCode 417]
(https://leetcode.com/problems/pacific-atlantic-water-flow/)

**My Initial Thought**

Initial Idea is to dfs each matrix and store the result matrix in the cache array
again while re-iterating use the cache array result. But in few cases above idea won't work,
reason how you are exploring the path is matters.

For example, this is my pseudocode:

<procedure title="Pseudo Code" id="pseudo-code-procedure">
    <step>
        <p>Initialize cache array of size heights with default value as <code>0</code></p>
    </step>
    <step>
        <p>With for loop Iterate the 2D matrix of height array </p>
    </step>
    <step>
        <p>In each iteration we have four choices up, down, left and right</p>
    </step>
    <step>
        <p>
        While discovering each choices store the result of each row and columm and again re-use them when the work repeats
        </p>
    </step>
</procedure>

JAVA CODE


<tabs>
    <tab title="Java 8">
        <code-block lang="java">
            // Legends :-
            // -1 -> yet to discover
            // 1 -> reach pacific Only
            // 2 -> reach Atlantic Only
            // 3 -> reach both the ends
            // 4 -> No reachablility
    int markIslandFlow(int r, int c, int prev, int[][] cache, int[][] heights) {
        int m = heights.length, n = heights[0].length;
        if (r == -1 || c == -1) {
            return 1;
        }
        if (r == m || c == n) {
            return 2;
        }
        if (r < 0 || c < 0 || r >= m || c > n || prev < heights[r][c]) {
            return 4;
        }
        if (cache[r][c] != 0) {
            return cache[r][c] ;
        }
        cache[r][c] = 4;
        int up = markIslandFlow(r - 1, c, heights[r][c], cache, heights);
        int down = markIslandFlow(r + 1, c, heights[r][c], cache, heights);
        int right = markIslandFlow(r, c + 1, heights[r][c], cache, heights);
        int left = markIslandFlow(r, c - 1, heights[r][c], cache, heights);
        if (up == 3 || left == 3 || down == 3 || right == 3) {
            cache[r][c] = 3;
        } else if ((up == 1 || left == 1) && (right == 2 || down == 2)) {
            cache[r][c] = 3;
        } else if ((up == 1 || left == 1)) {
            cache[r][c] = 1;
        } else if (down == 2 || right == 2) {
            cache[r][c] = 2;
        }
        return cache[r][c];
    }
        </code-block>
    </tab>
    <tab title="Test case ">
        <code-block lang=java>
        System.out.println(new Main().pacificAtlantic(new int[][]{
                {10, 10, 10},
                {10, 1, 10},
                {10, 10, 10}
        }));
        </code-block>
    </tab>
</tabs>

The above code won't work reason as I mentioned the way of discovering the path matters
In above case for every cell in a matrix we have four options

1. up
2. down
3. right
4. left

The code fails for the mentioned test case. Here is how for sake of explanation will consider
simple test case

       [10, 10],
       [10, 1]

1. code will start at r = 0 and c = 0
2. We have 4 choices up, down, right and left
3. up -> will hit base case and return 1
4. down -> okay now we reached new cell r = 1 and c = 0
5. again -> 4 choices 
6. will go up hit base case since we already discovered 0,0 which is where we came from
7. **Step 6 is the actual issue will return 4**
8. Hence, forth for a cell 1,0 `int up = 4`, But actual answer is 1 for the cell 0,0
9. Once  Cell (0, 0) is completed then only it should inform and reused to other cells (Which leads to kind of toposort solution)




