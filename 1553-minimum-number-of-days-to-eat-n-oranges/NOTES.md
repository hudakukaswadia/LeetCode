- The most brute force solution would be 3^n as we have 3 choices so worst case → the height of the tree would be n
- But with a little bit of caching and memoization → we can get this solution to be O(n) as you can see that the possible number of sub problems would be n
- So we can do n, n - 1, n - 2 and all the way up to 0
- So you can cache it and do it in a linear time solution with DFS
- But we can do even better than a linear time i.e. using a BFS approach without repeating the same sub problem that will actually going to get us a time complexity of $O(log_2 n)$ (read as log base 2 n).
- A greedy DFS solution can also give the same result as above.
- As with DFS, we are repeating sub problems so we will cache it. Hence with memoization → we could get a solution of O(n)
- So if we start out at n=10 so we know that it will never take us more than 10 days to eat all these oranges because we could take 1 orange and eat it every single day
- So we know that the solution would be bounded by 10 which means the result will be less than or equal to 10
- But that’s not the case, the boundary is actually less than 10
- Which means that for any input value n → the solution is proportional to $2 (log_2 n)$ but the constant can be ignore in time complexity.
- So we are starting out with 10 oranges → we know that either this is going to be divisible by 2 or not divisible by 2
- So in other words, either this is going to be an even number or an odd number
- So when we are starting with 10, → it is even hence we will divide it by 2 and it becomes 5 which is odd hence we can’t divide it by 2
- So we will do n - 1 which will become 4 and this is again an even number and we will divide it by 2 which will be further divided by 2 and you will end up with 1
- So worst case would be: that we will be able to divide by 2 then subtract by 1, then divide by 2 and subtract by 1 so on and so forth
- But how can we guarantee that once we reach a leaf node, we are going to stop going through our tree? We are not going to do any extra work which means that once we reach the first leaf node, we can stop and we can guarantee that by doing a BFS.
- So you can do a BFS, where you don’t visit the same node twice and you stop as soon as you reach the first leaf node
- Now there is also a slightly better greedy DFS solution where you can limit the choices to 2 to the power of log n
- So for example, we are taking an example of 10 → is it divisible by 3? No, it is not. So we have to calculate how far it is from being divisible by 3.
- Hence we will mod it by 3 so that will be 10%3 i.e. equal to 1 which means if we eat 1 orange then it will be divisible by 3
- We will be caching so that means we won’t be repeating the same subproblem multiple times
​
## Coding Explanation
​
- We will be doing it recursively and we will be caching so we will create a cache of dp and we will have 2 base cases
- So if we have zero oranges then we can return zero days and if we have one orange then we can return one day to eat that orange
- We will be doing recursion on n
- So we will say if n is in dp then we will return dp of n until then we will do the recursive case so like i said:
- there’s two recursive cases because we want to either divide it by 2 or divide it by 3 and if we can’t divide it by 2 or 3 then we will have to do some extra math for that