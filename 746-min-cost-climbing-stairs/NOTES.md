- So the question says that if pay the cost at index i then we can either climb 1 step or 2 steps from index i
- So we are given an array of 10, 15, 20. And what we are told that if we pay this cost → which is 10 at position 1 → then we can either take 1 step which will land us to 15 or we can take 2 steps which will land us to the number 20
- We also have the option to start at index 0 or start at index 1
- Our goal is to reach the top floor of the stair case
- However the last position is not the top floor, the position after 20 is the top floor
- We can’t just be greedy and take 2 jumps every single time
- Make a decision tree where each node will have up to 2 branches and then keep doing that until you get to the base case which is index 3 that is the maximum height of the tree and we will have a potential level for every single position in the input array
- The height of the tree will be n which is equal to the length of the cost array and we know that we can have 2 branches for every single node so the time complexity will be $2^n$
- As we can see that we are doing a lot of repeated work and if we get rid of all this repeated work then we can get the time complexity down to $O(n)$ because what we are noticing is that to solve the original problem which is what’s the minimum cost → if we start at index 0 to reach index 3
- Hence the time complexity will be $O(n)$  where we have n sub problems
- So we are asking from index 0 → how long does it take to get to index 3, then from index 1 → how long does it take to get to index 3, then from index 2 → how long does it take to get to index 3
- Space complexity: $O(n)$
- If we take the idea of caching the recursive solution then we can actually get an iterative solution and will have the same time and memory complexity
​
## Iterative Solution - Dynamic Programming
​
- This solution will have a slightly better memory complexity because we can actually use the input array itself that we are given and then we can use 2 single variables to do the DP solution
- Every cell in the array has a dependency on the solution of the next cell
- So we will actually solve the problems from right to left instead of left to right which means that we will solve the sub problems first and then the original problem
- So we will start solving from index 2 which is number 20 and it will have 2 choices:
1. 1 jump → cost will be 20
2. 2 jumps → but it won’t do anything as it will go out of bounds
def minCostClimbingStairs(self, cost: List[int]) -> int: