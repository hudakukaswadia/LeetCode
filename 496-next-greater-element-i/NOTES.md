## Explanation 1 - $O(n^2)$ or $O(n * m)$

- First we will do the $O(n^2)$ solution where n is the size of the larger input array
- We are given 2 arrays where nums1 is actually the subset of nums2
- Since nums1 is a subset of nums2, we actually only want to find the next greater element of the values in this array that are also included in the first array
- So we don’t want to find the next greater element of every one of these, we only want to find the ones that are in nums1 which are 4, 1 and 2
- So lets say, we want to find the next greater element of 4 while we look at our second array. So 2 is not greater than 4 hence 4 doesn’t have a next greater element so the default value that we will use in this case is -1 so we will put a -1 in the output
- Now the next value is 1 in nums1. Now looking at nums2, the next greater element is 3 which is greater than 1 so that is the next greater element of 1. Now 4 is also greater than 1 but as 3 is closer to 1 on the right side hence we will use 3 as the next greater element
- Now for 2 → 2 doesn’t have any elements to the right of it so it doesn’t have a negative element so we can put a -1 there
- So one way to approach this problem is to find the next greater element of each of the elements in nums2 and then we can create the output
- But then also, we can skip the values that we don’t need so for example 3 is not in nums1 hence we can skip 3
- So what i will do is convert the first array in hashmap where we will be mapping every single value in that array to the index that it shows up at, in the same array
- The reason why we are going to be doing that is because lets say we are iterating through each value in n2
- So we have 1 in nums2:
    - So first we would want to know that does 1 even show up in nums1? Yes, it does. So now we will find the next greater element of 1
    - We found 3 in nums2. Now we want to add 3 in the output in our result.
    - Now where will we add it in our result? Well it depends where did ‘1’ show up in the input array.
    - As ‘1’ showed up at index1 and that will be the same index that we add it at the output and that’s the reason why we require a hashmap so that we know the index of every single value
    - And then we will repeat the same process for the rest of the array and iterate through the entire array
- The overall time complexity will be $O(n^2)$  because for every single value in nums2, we will have to potentially iterate through the entire input array to find the next greater element and we are gonna have to do that for every single value in the array in the worst case
- Now for example the size of nums1 is n and the size of nums2 is m so technically the time complexity will actually be $O(n *m)$ because we are **not** finding the next greater element for every element in nums2, we are **only finding the next greater element for every element in nums1**
- The memory complexity is going to be O(n) because we have a hashmap for the first array and we are also building the output as well

## Coding Explanation 1 - $O(n^2)$ or $O(n * m)$

- I will start by initialising the hashmap and the way to do this is by taking every single value in nums1 and then mapping it to the index that it shows up in
- Then we have our result which is an array and it will be the same length of nums1 and initially it will be all -1s because we know that -1 is the default value
- Now we will do our nested for loops
- So we will go through every value in nums2 which is the bigger array
- Then we are checking → does that value even show up in nums1 →
    - if it doesn’t → then we will skip this value and then go to the next iteration of the loop
    - If it does show up → then we will do our nested loop
- In the nested loop → we will go through every single value → starting at i + 1 because we only want to look at values that come after the original value
- And then we are checking which is the first value i.e. greater than the value that we started at
- If we find the next greater value → then we will get the index of the original value then → we will set the result equal to the next greater value and then break out of this loop as we are already done
- But if the above doesn’t execute and we never find the next greater element → then the result will stay the same at that index and it will stay as a negative 1 which is the default value
- Once the above nested for loop is done → we will return the result

## Explanation 2 -  $O(n + m)$

- This is going to take a stack to solve
- This is the monotonic stack technique
- Now lets take an example of:
    - n1 = [4, 1, 2]
    - n2 = [2, 1, 3, 4]
- We know that 2 shows up in the first array so we want to find the next greater element of 2
- Now we look at the next greater element of 2 i.e. 1 which is not the next greater element then we look at the next value i.e. 3 which is greater than 2
- Now if 3 is the next greater element of 2 → shouldn’t it also be the next greater element of 1? That’s only the case when 1 even shows up in the 1st array(n1) which it does!
- Now because we want to remember the values between 2 and 3 hence we will use a stack
- This will be a one pass solution
- Notice that the stack will always be in a decreasing order
- We will compare 3 with ALL values in the stack to the left
- We won’t add 3 to the stack as 3 doesn’t show up in n1 hence we don’t need to find the next greater element of 3
- So result for the above example will be [-1, 3, 3]
- We did this with one pass through the input array
- Also, we are adding elements to the stack but we are also going to be popping each element from the stack only once
- So the overall time complexity: O(n + m)
- Space complexity: O(m) because the hashmap will be the size of the first array
- Also, the stack will only be the size of the first array because we are only adding elements from the size of the first array to the stack

## Coding Explanation 2 -  $O(n + m)$

- We will have the exact same hashmap as we did in solution 1 and we will initialise the result the exact same way too
- We will also have a stack that will initially be empty just like in the drawing explanation
- Then we will start iterating through every element in the second array just like we did in solution 1
- Now we will look at the current value which is nums2 at index i
- And we want to know if this is the next greater element for any previous values that could be on our stack
- Now initially our stack is empty but later on it could be non-empty
- So we want to know if the stack is non-empty AND is current greater than the top of the stack (You can get the top of the stack using -1 in python
- If the above is the case then we want to pop from our stack and we will set it to val
- We know that current is the next greater element of the above popped val so we want to find the index of this val
- Now we will get the index using the hashmap
- And at that index we can set the result which is going to be cur as cur is the next greater value
- Now after the above is done, the question is - does cur show up in the first array?
- If cur is in nums1 index hashmap then that means it does show up in the first array and that further means that we should add this to our stack
- And if it doesn’t show up then we won’t add this to our stack as we don’t need to find the next greater element of that value

## Coding Solution 1 - $O(n^2)$ or $O(n * m)$
```
class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # O(n * m)
        nums1Idx = { n : i for i, n in enumerate(nums1) }
        res = [-1] * len(nums1)
        
        for i in range(len(nums2)):
            if nums2[i] not in nums1Idx:
                continue
            for j in range(i + 1, len(nums2)):
                if nums2[j] > nums2[i]:
                    idx = nums1Idx[nums2[i]]
                    res[idx] = nums2[j]
                    break
                    
        return res
```

## Coding Solution 2 - $O(n * m)$
```
class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # O(n * m)
        nums1Idx = { n : i for i, n in enumerate(nums1) }
        res = [-1] * len(nums1)
        
        stack = []
        for i in range(len(nums2)):
            cur = nums2[i]
            while stack and cur > stack[-1]:
                val = stack.pop()
                idx = nums1Idx[val]
                res[idx] = cur
            if cur in nums1Idx:
                stack.append(cur)
                
        return res
```
