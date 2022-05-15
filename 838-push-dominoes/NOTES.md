- Now this entire iteration was one second
- But how do we know that we have reached the end?
- When our queue is empty → because right now we have a bunch of new dominoes that were just tipped over
- Now either these dominoes are stuck together or they have been knocked over to being flat
- Time complexity: $O(n)$  because in the worst case → every single domino could be added to the queue and then popped from the queue
- Space complexity: $O(n)$  because our queue will potentially contain every single domino that was given to us in the input
​
## Coding Explanation:
​
- So the dominoes are actually given to us in a string and it will be helpful for us to covert that into a list and the main reasoning is that as we will be updating the dominoes and you can’t really update a character in a string in python
- In python, you can use a double ended queue using deque
- So firstly, i will enumerate through all the dominoes so our list of dominoes and we will get the index and the domino
- Now we want to add all the dominoes that are not standing straight to our queue initially so we will queue dot append each domino if it’s not standing straight up
- And we will be adding a pair of values to our queue so we are going to actually include the index because you are going to see that the index is actually going to come in handy because after we pop a domino from our queue → we want to know the index of it so that we can check the neighbours of that domino
- Now we will continue the loop until the queue is completely empty and on each iteration of the loop → we just pop the element from the queue and in this case → we will pop the left most and from that we will get the index and a domino
- So there are 2 cases → a domino could be a left domino OR a domino could be a right domino as we know that it won’t be standing straight up because if it was then we wouldn’t have even added it to our queue
- In the left case → all we have to do is check that its left neighbour is standing straight up and that means we just tipped our left neighbour over
- How do we know that our left neighbour exists and is standing straight up?
- Firstly, ‘i’ has to be greater than zero because if it’s zero index then it means that we don’t have any left neighbours
- Secondly, we will get the left index by subtracting the existing index by 1 and if it’s equal to a dot which means that our left neighbour is standing straight up
- Now this means that we will add our left neighbour to the queue and its index is i minus 1 and its value will now be LEFT because we just tipped it over
- Now we will update it in the dominoes list as that’s what we are actually going to return in the end so we will set dom of i minus 1 to be left
- In the right case → first we will check if we do have the right neighbour
- How do we know that our right neighbour exists and is standing straight up?
- ‘i’ has to be less than the length of dominoes minus 1 which means there has to be atleast one domino to the right of it and that domino has to be standing straight up
- Now we will check if there is another domino to the right and that domino happens to be the domino that’s leaning to the left
- And if that’s the case → then we can’t knock this domino over that means it is stuck
- In that case → we should pop from the queue one more time
- And the reason we are doing the above is that if we don’t pop this domino that’s leaning to the left then it means on the next iteration → we are going to visit that domino again and our code will run and then the first if statement will run → and then the left domino will knock over the standing straight domino even though it shouldn’t because the straight domino is in between 2 dominoes i.e. a right domino and a left domino hence it is stuck