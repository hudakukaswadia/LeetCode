- k is an integer and a k duplicate removal is basically removing a portion of the string where there are k times consecutive characters
- the order of removal that we do won’t matter at all
- So the immediate solution that I can think of is that first scan through the entire input and anytime we find a group of k consecutive characters → we will do a removal
- After the above step, the string will be updated and we will repeat scanning the input again
- In this case, we have to scan through the entire array which is n size and in the worst case might have to do it n times hence the time complexity will be $O(n * n)$ so that will be $O(n^2)$  time complexity solution
- We will use a stack data structure because we will always be removing from the most recently added data structure
- So the way i will be taking the stack data structure is actually taking the character and then mapping it to the count of that character
- popping from a stack is: $O(1)$
- pushing to a stack is: $O(1)$
- In the worst case: we are adding every single character to the stack and removing every single character from the stack so that would be $O(n)$ to add every character plus $O(n)$  to remove every character so the overall time complexity is $O(2n)$ which is still $O(n)$
- Space: $O(n)$ because we are using stack as extra space

## Coding Explanation:

- I am using a stack and i will use a pair of values that will be a character and the count
- Then I will iterating through every single character in the string from the left to right because it doesn’t matter what order we go in
- And we will check if the stack is non-empty and the top of the stack and we are looking at first of the pair as we are looking at the character and we will check if that’s equal to the current character that we are at
- If it is → then we know that we can increment the count of the character by 1
- So in the code , 1 is the second value of the pair which is the count so we will take that and increment it by 1
- and if it is not the case → either our stack is empty or this is not the same character at the top of our stack →
- Then we are going to append to our stack this character and we are going to give it the initial count of 1 that means we have one consecutive of this character
- Now it’s also possible that the count of that character just reached k and we can tell that by checking the top of our stack and the count of it if it’s equal to k
- And if it’s → then we pop that from our stack
- Now another case is that → if it’s less than k → then we don’t do anything
- Also, it is never going to be greater than k as we are only increasing the count by 1 and if it ever reaches k → then it will be immediately popped off
- Then we will take our stack and convert it to the result string
- And the easiest way to do that is to iterate through our stack so basically the pair of values in the stack
- Then we will append to the result → this character and then we want to make this many copies of that character
- return result string

```
class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        stack = []
        
        for c in s:
            if stack and stack[-1][0] == c:
                stack[-1][1] += 1
            else:
                stack.append([c, 1])
                
            if stack[-1][1] == k:
                stack.pop()
                
        res = ""
        for char, count in stack:
            res += (char * count)
            
*         return res
```
