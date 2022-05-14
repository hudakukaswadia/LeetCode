​
## Coding Explanation
​
- We will be doing it recursively and we will be caching so we will create a cache of dp and we will have 2 base cases
- So if we have zero oranges then we can return zero days and if we have one orange then we can return one day to eat that orange
- We will be doing recursion on n
- So we will say if n is in dp then we will return dp of n until then we will do the recursive case so like i said:
- there’s two recursive cases because we want to either divide it by 2 or divide it by 3 and if we can’t divide it by 2 or 3 then we will have to do some extra math for that
- So we want to call dfs on n integer division divided by 2
- But it’s possible that n is not divisible by 2 and in which case → we would want to add a constant to this
- This DFS is going to return the number of days but if n is not divisible by 2 meaning there’s a remainder of one then we are going to add an extra day to eat that extra orange
- How do we know that there’s a remainder? n % 2 + dfs(n // 2)
- So if n is divisible by 2 then (n%2) will evaluate to zero
- So basically what we are calculating is that if we divide it by 2 then how many days will it take us and we will store that in a variable so lets just call it ***one.*** We will also have a 1 + at the beginning because when we are dividing it by 2 that also takes a day for us
- Now we will compute if we divided it by 3 and store it in a variable called ***two.***
- So either (n%3) will evaluate to zero which means n can be divided by 3 or it will evaluate to 1 which means we have one extra orange that we will have to eat and it will take us one day to eat each orange or we have two oranges
- Then we will take minimum of one and two and set it equal to dp of n so we have found the result of dp of n and we can go ahead and cache that and then return it
- Then we can call our dfs and pass in n and return the result from there
​
```
class Solution:
def minDays(self, n: int) -> int:
dp = { 0 : 0, 1 : 1 }
def dfs(n):
if n in dp:
return dp[n]
one = 1 + (n % 2) + dfs(n // 2)
two = 1 + (n % 3) + dfs(n // 3)
dp[n] = min(one, two)
return dp[n]
return dfs(n)
```